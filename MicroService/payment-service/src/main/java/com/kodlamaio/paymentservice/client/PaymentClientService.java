package com.kodlamaio.paymentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "paymentClient", url = "http://localhost:9010/rental/api/rentals/")
public interface PaymentClientService {
    @RequestMapping(method= RequestMethod.GET ,value = "totalpricebyid/{rentalId}")

    double getTotalPrice(@PathVariable String rentalId);
}
