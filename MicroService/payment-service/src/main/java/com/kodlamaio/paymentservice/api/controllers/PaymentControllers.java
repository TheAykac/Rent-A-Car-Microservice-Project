package com.kodlamaio.paymentservice.api.controllers;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.paymentservice.api.controllers.models.MakePayment;
import com.kodlamaio.paymentservice.business.abstracts.PaymentService;
import com.kodlamaio.paymentservice.business.responses.create.CreatePaymentResponse;
import com.kodlamaio.paymentservice.business.responses.get.GetPaymentResponse;
import com.kodlamaio.paymentservice.business.responses.getAll.GetAllPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentControllers {

    private PaymentService paymentService;

    @PostMapping("/makePayment")
    public DataResult<CreatePaymentResponse> makePayment(@RequestBody MakePayment makePayment) {
        return this.paymentService.makePayment(makePayment);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllPaymentResponse>> getAll() {
        return this.paymentService.getAll();
    }

    @GetMapping("/getById/{id}")
    public DataResult<GetPaymentResponse> getById(String id) {
        return this.paymentService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id) {
        return this.paymentService.delete(id);
    }
}
