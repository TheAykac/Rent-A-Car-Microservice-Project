package com.kodlamaio.paymentservice.api.controllers;

import com.kodlamaio.paymentservice.business.abstracts.PaymentService;
import com.kodlamaio.paymentservice.business.requests.create.CreatePaymentRequest;
import com.kodlamaio.paymentservice.business.responses.create.CreatePaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestBody;
=======
>>>>>>> e4bd1ba4ef4add7550e75eb3942277d857dffebe
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
<<<<<<< HEAD
@RequestMapping("/api/payments")
=======
@RequestMapping("/api/cars")
>>>>>>> e4bd1ba4ef4add7550e75eb3942277d857dffebe
@AllArgsConstructor
public class PaymentControllers {

    private PaymentService paymentService;

    @PostMapping("/add")
<<<<<<< HEAD
    public CreatePaymentResponse add(@RequestBody CreatePaymentRequest createPaymentRequest) {
=======
    public CreatePaymentResponse add(CreatePaymentRequest createPaymentRequest) {
>>>>>>> e4bd1ba4ef4add7550e75eb3942277d857dffebe
        return this.paymentService.add(createPaymentRequest);
    }
}
