package com.kodlamaio.invoiceservice.business.concretes;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.common.utilities.messages.BusinessMessage;
import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.common.utilities.result.SuccessDataResult;
import com.kodlamaio.common.utilities.result.SuccessResult;
import com.kodlamaio.invoiceservice.business.abstracts.InvoiceService;
import com.kodlamaio.invoiceservice.business.generate.GenerateRandomCode;
import com.kodlamaio.invoiceservice.business.requests.CreateInvoiceRequest;
import com.kodlamaio.invoiceservice.business.responses.CreateInvoiceResponse;
import com.kodlamaio.invoiceservice.business.responses.GetAllInvoiceResponse;
import com.kodlamaio.invoiceservice.business.responses.GetInvoiceResponse;
import com.kodlamaio.invoiceservice.dataAccess.InvoiceRepository;
import com.kodlamaio.invoiceservice.entities.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private ModelMapperService modelMapperService;
    private InvoiceRepository invoiceRepository;


    @Override
    public DataResult<CreateInvoiceResponse> add(CreateInvoiceRequest createInvoiceRequest) {

        Invoice invoice = this.modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
        invoice.setId(UUID.randomUUID().toString());
        this.invoiceRepository.save(invoice);
        CreateInvoiceResponse createInvoiceResponse = this.modelMapperService.forResponse().map(invoice, CreateInvoiceResponse.class);
        return new SuccessDataResult<>(createInvoiceResponse, BusinessMessage.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
    }

    @Override
    public void createInvoice(LocalDate startDate, int totalRentalDay, double priceOfDays, double rentalCarTotalPrice, String rentalCarId) {

        CreateInvoiceRequest createInvoiceRequest = new CreateInvoiceRequest();

        createInvoiceRequest.setStartDate(startDate);
        createInvoiceRequest.setPriceOfDays(priceOfDays);
        createInvoiceRequest.setTotalRentalDay(totalRentalDay);
        createInvoiceRequest.setRentalCarTotalPrice(rentalCarTotalPrice);
        createInvoiceRequest.setRentalCarId(rentalCarId);
        createInvoiceRequest.setInvoiceNo(generateCode());
        add(createInvoiceRequest);
    }

    private String generateCode() {
        while (true) {
            String code = GenerateRandomCode.generate();
            if (!this.invoiceRepository.existsByInvoiceNo(code)) {
                return code;
            }
        }
    }

    @Override
    public DataResult<List<GetAllInvoiceResponse>> getAll() {
        List<Invoice> invoices = this.invoiceRepository.findAll();
        List<GetAllInvoiceResponse> getAllInvoiceResponses = invoices.stream().map(invoice -> this.modelMapperService.forResponse().map(invoice, GetAllInvoiceResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllInvoiceResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<GetInvoiceResponse> getById(String id) {
        checkIfExitsById(id);
        Invoice invoice = this.invoiceRepository.findById(id).get();
        GetInvoiceResponse getInvoiceResponse=this.modelMapperService.forResponse().map(invoice,GetInvoiceResponse.class);
        return new SuccessDataResult<>(getInvoiceResponse,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public Result delete(String id) {
        checkIfExitsById(id);
        Invoice invoice = this.invoiceRepository.findById(id).get();
        this.invoiceRepository.delete(invoice);
        return new SuccessResult(BusinessMessage.GlobalMessages.DATA_DELETED_SUCCESSFULLY);
    }

    private void checkIfExitsById(String id){
        if (!this.invoiceRepository.existsById(id)){
            throw new BusinessException(BusinessMessage.GlobalMessages.ID_NOT_FOUND+id);
        }
    }
}
