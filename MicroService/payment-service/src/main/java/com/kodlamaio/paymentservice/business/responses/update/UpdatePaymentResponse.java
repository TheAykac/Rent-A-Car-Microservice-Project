package com.kodlamaio.paymentservice.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentResponse {


    private String id;
    private String totalPrice;
}
