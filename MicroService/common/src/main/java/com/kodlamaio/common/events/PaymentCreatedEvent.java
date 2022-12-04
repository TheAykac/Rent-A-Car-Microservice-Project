package com.kodlamaio.common.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCreatedEvent {


    private String rentalId;
    private int rentedForDays;
    private double dailyPrice;
    private String message;
}
