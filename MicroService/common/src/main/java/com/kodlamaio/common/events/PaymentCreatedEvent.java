package com.kodlamaio.common.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCreatedEvent {
<<<<<<< HEAD


    private String rentalId;
    private int rentedForDays;
    private double dailyPrice;
=======
    private double totalPrice;
>>>>>>> e4bd1ba4ef4add7550e75eb3942277d857dffebe
    private String message;
}
