package com.kodlamaio.paymentservice.business.responses.create;

import com.kodlamaio.paymentservice.business.concretes.CreditCardManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentResponse {

    private double totalPrice;
    private String rentalId;


}
