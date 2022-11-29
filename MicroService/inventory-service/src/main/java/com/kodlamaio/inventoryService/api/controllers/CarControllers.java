package com.kodlamaio.inventoryService.api.controllers;

import com.kodlamaio.inventoryService.business.abstracts.CarService;
import com.kodlamaio.inventoryService.business.requests.create.CreateCarRequest;
import com.kodlamaio.inventoryService.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.inventoryService.business.responses.create.CreateCarResponse;
import com.kodlamaio.inventoryService.business.responses.get.GetCarsResponse;
import com.kodlamaio.inventoryService.business.responses.getAll.GetAllCarsResponse;
import com.kodlamaio.inventoryService.business.responses.update.UpdateBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@AllArgsConstructor
public class CarControllers {

    private CarService carService;

    @GetMapping()
    public List<GetAllCarsResponse> getAll(){
        return this.carService.getAll();
    }
    @GetMapping("/{id}")
    public GetCarsResponse getById(@PathVariable String id){
        return this.carService.getById(id);
    }
    @PutMapping()
    public UpdateBrandResponse update (@RequestBody @Valid UpdateBrandRequest updateBrandRequest){
        return this.carService.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete (String id){
        this.carService.delete(id);
    }

    @PostMapping
    public CreateCarResponse add(@RequestBody @Valid CreateCarRequest createCarRequest){
        return this.carService.add(createCarRequest);
    }
}
