package com.kodlamaio.paymentservice.business.responses.getAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPaymentResponse {



    private String id;

    private String rentalId;

    private String cardNo;

    private String cardHolder;

    private int cvv;

    private LocalDate cardDate;

    private double balance;

    private int status;
}
