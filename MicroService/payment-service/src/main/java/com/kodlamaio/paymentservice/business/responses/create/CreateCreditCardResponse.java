package com.kodlamaio.paymentservice.business.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditCardResponse {

    private String id;
    private String cardNumber;
    private String cardOwner;
    private String cardCvv;
    private String cardExpirationDate;
}
