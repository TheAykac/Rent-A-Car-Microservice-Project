package com.kodlamaio.paymentservice.api.controllers;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.paymentservice.business.abstracts.CreditCardService;
import com.kodlamaio.paymentservice.business.responses.get.GetCreditCardResponse;
import com.kodlamaio.paymentservice.business.responses.getAll.GetAllCreditCardResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/creditCard")
@AllArgsConstructor
public class CreditCardControllers {
    private CreditCardService creditCardService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllCreditCardResponse>> getAll() {
        return this.creditCardService.getAll();
    }

    @GetMapping("/getById/{id}")
    public DataResult<GetCreditCardResponse> getById(@PathVariable String id) {
        return this.creditCardService.getById(id);
    }
}
