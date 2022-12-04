package com.kodlamaio.paymentservice.business.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {


    private String rentalId;

    private String cardNo;

    private String cardHolder;

    private int cvv;

    private LocalDate cardDate;

    private double balance;

    private int status;
}
