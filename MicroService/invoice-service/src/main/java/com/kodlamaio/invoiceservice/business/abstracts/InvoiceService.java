package com.kodlamaio.invoiceservice.business.abstracts;

import com.kodlamaio.invoiceservice.business.requests.CreateInvoiceRequest;
import com.kodlamaio.invoiceservice.business.responses.CreateInvoiceResponse;
import com.kodlamaio.invoiceservice.entities.Invoice;

public interface InvoiceService {
   CreateInvoiceResponse add (CreateInvoiceRequest createInvoiceRequest);
}
