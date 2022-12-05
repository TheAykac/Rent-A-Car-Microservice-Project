package com.kodlamaio.paymentservice.business.abstracts;

import com.kodlamaio.paymentservice.api.controllers.models.MakePayment;
import com.kodlamaio.paymentservice.business.concretes.CreditCardManager;
import com.kodlamaio.paymentservice.business.requests.create.CreatePaymentRequest;
import com.kodlamaio.paymentservice.business.responses.create.CreatePaymentResponse;

public interface PaymentService {

    CreatePaymentResponse makePayment(MakePayment makePayment) ;
}
