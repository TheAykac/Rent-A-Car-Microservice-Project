package com.kodlamaio.paymentservice.business.abstracts;

import com.kodlamaio.paymentservice.business.requests.create.CreatePaymentRequest;
import com.kodlamaio.paymentservice.business.responses.create.CreatePaymentResponse;

public interface PaymentService {

    CreatePaymentResponse add(CreatePaymentRequest createPaymentRequest);
}
