package com.kodlamaio.invoiceservice.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private double priceOfDiffCity;

    private double priceOfAdditionals;

    private double rentalCarTotalPrice;

    private int rentalCarId;

    private int customerId;

    private int paymentId;
}
