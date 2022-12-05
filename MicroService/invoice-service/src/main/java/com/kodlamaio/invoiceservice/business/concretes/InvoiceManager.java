package com.kodlamaio.invoiceservice.business.concretes;

import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.invoiceservice.business.abstracts.InvoiceService;
import com.kodlamaio.invoiceservice.business.requests.CreateInvoiceRequest;
import com.kodlamaio.invoiceservice.business.responses.CreateInvoiceResponse;
import com.kodlamaio.invoiceservice.business.responses.GetAllInvoiceResponse;
import com.kodlamaio.invoiceservice.dataAccess.InvoiceRepository;
import com.kodlamaio.invoiceservice.entities.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private ModelMapperService modelMapperService;
    private InvoiceRepository invoiceRepository;

    @Override
    public List<GetAllInvoiceResponse> getAll() {
        return null;
    }

    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest) {

        Invoice invoice = this.modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
        invoice.setId(0);

        CreateInvoiceResponse createInvoiceResponse = this.modelMapperService.forResponse().map(invoice,CreateInvoiceResponse.class);
        return createInvoiceResponse;
    }

    @Override
    public void createAndAddInvoice(String rentalId, String paymentId) {

        CreateInvoiceRequest createInvoiceRequest = new CreateInvoiceRequest();
        createInvoiceRequest.setRentalCarId(rentalId);
        createInvoiceRequest.setPaymentId(paymentId);

    }
}
