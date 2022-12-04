package com.kodlamaio.paymentservice.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentResponse {


    private String id;

    private String rentalId;

    private String cardNo;

    private String cardHolder;

    private int cvv;

    private LocalDate cardDate;

    private double balance;

    private int status;
}
