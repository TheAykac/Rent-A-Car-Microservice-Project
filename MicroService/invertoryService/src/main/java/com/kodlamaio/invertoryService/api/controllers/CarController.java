package com.kodlamaio.invertoryService.api.controllers;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.invertoryService.business.abstracts.CarService;
import com.kodlamaio.invertoryService.business.requests.create.CreateCarRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateCarResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetCarResponse;
import com.kodlamaio.invertoryService.business.responses.getAll.GetAllCarsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {

    private CarService carService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllCarsResponse>> getAll() {
        return carService.getAll();
    }

    @PostMapping("/add")
    public DataResult<CreateCarResponse> add(@RequestBody @Valid CreateCarRequest createCarRequest) {
        return carService.add(createCarRequest);
    }
    @GetMapping("/checkIfCarAvailable/{carId}")
    public void checkIfAvailableCar(@PathVariable String carId) {
        this.carService.checkIfCarAvailable(carId);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(String id) {
        return this.carService.delete(id);
    }

    @GetMapping("/getById/{id}")
    public DataResult<GetCarResponse> getById(@PathVariable String id){
        return this.carService.getById(id);
    }


}
