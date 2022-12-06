package com.kodlamaio.invoiceservice.business.abstracts;

import com.kodlamaio.invoiceservice.business.requests.CreateInvoiceRequest;
import com.kodlamaio.invoiceservice.business.responses.CreateInvoiceResponse;
import com.kodlamaio.invoiceservice.business.responses.GetAllInvoiceResponse;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceService {


    CreateInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest);

    void createInvoice(LocalDate startDate,int totalRentalDay,double priceOfDays,double rentalCarTotalPrice,String rentalCarId);


}
