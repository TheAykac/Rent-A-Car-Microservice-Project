package com.kodlamaio.invertoryService.api.controllers;

import com.kodlamaio.invertoryService.business.abstracts.CarService;
import com.kodlamaio.invertoryService.business.requests.create.CreateCarRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateCarResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetAllCarsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {

    private CarService carService;

    @GetMapping("getall")
    public List<GetAllCarsResponse> getAll() {
        return carService.getAll();
    }

    @PostMapping("add")
    public CreateCarResponse add(@RequestBody @Valid CreateCarRequest createCarRequest) {
        return carService.add(createCarRequest);
    }

    @GetMapping("/checkIfCarAvailable/{carId}")
    public void checkIfAvailableCar(@PathVariable String carId) {
        this.carService.checkIfCarAvailable(carId);
    }


}
