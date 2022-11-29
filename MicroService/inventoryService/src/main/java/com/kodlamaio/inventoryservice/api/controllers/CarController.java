package com.kodlamaio.inventoryservice.api.controllers;

import com.kodlamaio.inventoryservice.business.abstracts.CarService;
import com.kodlamaio.inventoryservice.business.requests.create.CreateCarRequest;
import com.kodlamaio.inventoryservice.business.requests.update.UpdateCarRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateCarResponse;
import com.kodlamaio.inventoryservice.business.responses.delete.DeleteCarResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllCarResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetCarResponse;
import com.kodlamaio.inventoryservice.business.responses.update.UpdateCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/car")
@AllArgsConstructor
public class CarController {
    private CarService carService;

    @GetMapping
    public List<GetAllCarResponse> getAll(){
        return this.carService.getAll();
    }

    @GetMapping("/{id}")
    public GetCarResponse getById(@PathVariable String id){
        return this.carService.getById(id);
    }

    @PutMapping
    public UpdateCarResponse update(@RequestBody @Valid UpdateCarRequest updateCarRequest){
        return this.carService.update(updateCarRequest);
    }

    @DeleteMapping("/{id}")
    public DeleteCarResponse delete(@PathVariable String id){
        return this.carService.delete(id);
    }


    @PostMapping
    public CreateCarResponse add(@RequestBody @Valid CreateCarRequest createCarRequest){
        return this.carService.add(createCarRequest);
    }

}
