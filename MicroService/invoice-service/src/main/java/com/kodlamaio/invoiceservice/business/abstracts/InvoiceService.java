package com.kodlamaio.invoiceservice.business.abstracts;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.invoiceservice.business.requests.CreateInvoiceRequest;
import com.kodlamaio.invoiceservice.business.responses.CreateInvoiceResponse;
import com.kodlamaio.invoiceservice.business.responses.GetAllInvoiceResponse;
import com.kodlamaio.invoiceservice.business.responses.GetInvoiceResponse;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

public interface InvoiceService {


    DataResult<CreateInvoiceResponse> add(CreateInvoiceRequest createInvoiceRequest);
    DataResult<List<GetAllInvoiceResponse>> getAll();
    DataResult<GetInvoiceResponse> getById(String id);
    Result delete(String id);

    void createInvoice(LocalDate startDate,int totalRentalDay,double priceOfDays,double rentalCarTotalPrice,String rentalCarId);


}
