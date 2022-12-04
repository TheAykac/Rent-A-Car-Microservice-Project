package com.kodlamaio.paymentservice.api.controllers;

import com.kodlamaio.paymentservice.business.abstracts.PaymentService;
import com.kodlamaio.paymentservice.business.requests.create.CreatePaymentRequest;
import com.kodlamaio.paymentservice.business.responses.create.CreatePaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class PaymentControllers {

    private PaymentService paymentService;

    @PostMapping("/add")
    public CreatePaymentResponse add(CreatePaymentRequest createPaymentRequest) {
        return this.paymentService.add(createPaymentRequest);
    }
}
