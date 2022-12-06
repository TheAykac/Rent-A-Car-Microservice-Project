package com.kodlamaio.common.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class InvoiceCreatedEvent {

    private LocalDate startDate;

    private int totalRentalDay;

    private double priceOfDays;

    private double rentalCarTotalPrice;

    private String rentalCarId;
    private String message;


}
