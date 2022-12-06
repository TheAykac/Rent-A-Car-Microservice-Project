package com.kodlamaio.invoiceservice.business.concretes;

import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.invoiceservice.business.abstracts.InvoiceService;
import com.kodlamaio.invoiceservice.business.generate.GenerateRandomCode;
import com.kodlamaio.invoiceservice.business.requests.CreateInvoiceRequest;
import com.kodlamaio.invoiceservice.business.responses.CreateInvoiceResponse;
import com.kodlamaio.invoiceservice.business.responses.GetAllInvoiceResponse;
import com.kodlamaio.invoiceservice.dataAccess.InvoiceRepository;
import com.kodlamaio.invoiceservice.entities.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private ModelMapperService modelMapperService;
    private InvoiceRepository invoiceRepository;




    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest) {

        Invoice invoice = this.modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
        invoice.setId(UUID.randomUUID().toString());

        this.invoiceRepository.save(invoice);
        CreateInvoiceResponse createInvoiceResponse = this.modelMapperService.forResponse().map(invoice,CreateInvoiceResponse.class);
        return createInvoiceResponse;
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


}
