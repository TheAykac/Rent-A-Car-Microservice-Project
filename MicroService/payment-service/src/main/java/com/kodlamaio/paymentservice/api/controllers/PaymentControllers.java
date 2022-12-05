package com.kodlamaio.paymentservice.api.controllers;

import com.kodlamaio.paymentservice.api.controllers.models.MakePayment;
import com.kodlamaio.paymentservice.business.abstracts.PaymentService;
import com.kodlamaio.paymentservice.business.concretes.CreditCardManager;
import com.kodlamaio.paymentservice.business.responses.create.CreatePaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentControllers {

    private PaymentService paymentService;

    @PostMapping("/makePayment")
    public CreatePaymentResponse makePayment(@RequestBody MakePayment makePayment) {
        return this.paymentService.makePayment(makePayment);
    }
}
