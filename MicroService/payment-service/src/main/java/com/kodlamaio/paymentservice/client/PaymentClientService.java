package com.kodlamaio.paymentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "paymentclient", url = "http://localhost:9011/rental/api/rentals/")
public interface PaymentClientService {

    @RequestMapping(method = RequestMethod.GET,value = "getTotalPrice/{rentalId}")
    double getTotalPrice(@PathVariable String rentalId);

}
