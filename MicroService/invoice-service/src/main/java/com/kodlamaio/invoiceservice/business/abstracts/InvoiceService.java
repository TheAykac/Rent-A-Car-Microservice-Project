package com.kodlamaio.invoiceservice.business.abstracts;

import com.kodlamaio.invoiceservice.business.requests.CreateInvoiceRequest;
import com.kodlamaio.invoiceservice.business.responses.CreateInvoiceResponse;
import com.kodlamaio.invoiceservice.business.responses.GetAllInvoiceResponse;

import java.util.List;

public interface InvoiceService {
    List<GetAllInvoiceResponse> getAll();

    CreateInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest);

    void createAndAddInvoice(String rentalId, String paymentId);
}
