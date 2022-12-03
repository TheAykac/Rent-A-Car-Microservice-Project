package com.kodlamaio.rentalService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "carclient", url = "http://localhost:9011/")
public interface CarClientService {

    @RequestMapping(method = RequestMethod.GET, value = "stock/api/cars/checkIfCarAvailable/{id}")
    void checkIfCarAvailable(@PathVariable String id);
}
