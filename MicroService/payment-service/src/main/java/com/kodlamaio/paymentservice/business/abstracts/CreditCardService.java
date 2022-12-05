package com.kodlamaio.paymentservice.business.abstracts;

import com.kodlamaio.paymentservice.business.requests.create.CreateCreditCardRequest;
import com.kodlamaio.paymentservice.business.responses.create.CreateCreditCardResponse;

public interface CreditCardService {
    CreateCreditCardResponse add(CreateCreditCardRequest createCreditCardRequest);
}
