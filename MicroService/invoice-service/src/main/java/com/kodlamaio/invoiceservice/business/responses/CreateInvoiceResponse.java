package com.kodlamaio.invoiceservice.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceResponse {

    private String id;
    private String invoiceNo;
    private Date creationDate;
    private LocalDate startDate;
    private LocalDate finishDate;
    private short totalRentalDay;
    private double priceOfDays;
    private double rentalCarTotalPrice;
    private int rentalCarId;
    private int paymentId;
}
