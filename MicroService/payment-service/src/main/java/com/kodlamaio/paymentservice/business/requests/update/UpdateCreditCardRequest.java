package com.kodlamaio.paymentservice.business.requests.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCreditCardRequest {
    private String id;
    private String cardNumber;
    private String cardOwner;
    private String cardCvv;
    private String cardExpirationDate;
}
