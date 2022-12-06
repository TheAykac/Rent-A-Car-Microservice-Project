package com.kodlamaio.filterservice.api.controllers;

import com.kodlamaio.filterservice.business.abstracts.FilterService;
import com.kodlamaio.filterservice.business.requests.create.CreateBrandRequest;
import com.kodlamaio.filterservice.business.requests.create.CreateCarRequest;
import com.kodlamaio.filterservice.business.requests.create.CreateModelRequest;
import com.kodlamaio.filterservice.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.filterservice.business.requests.update.UpdateCarRequest;
import com.kodlamaio.filterservice.business.requests.update.UpdateModelRequest;
import com.kodlamaio.filterservice.business.responses.get.GetBrandResponse;
import com.kodlamaio.filterservice.business.responses.get.GetCarResponse;
import com.kodlamaio.filterservice.business.responses.get.GetModelResponse;
import com.kodlamaio.filterservice.business.responses.getAll.GetAllBrandResponse;
import com.kodlamaio.filterservice.business.responses.getAll.GetAllCarResponse;
import com.kodlamaio.filterservice.business.responses.getAll.GetAllFilterResponse;
import com.kodlamaio.filterservice.business.responses.getAll.GetAllModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/filter")
@AllArgsConstructor
public class FilterControllers {

    private FilterService filterService;

    @GetMapping("/addForBrand")
    public void addForBrand(CreateBrandRequest createBrandRequest) {
        this.filterService.addForBrand(createBrandRequest);
    }

    @GetMapping("/addForCar")
    public void addForCar(CreateCarRequest createCarRequest) {
        this.filterService.addForCar(createCarRequest);
    }

    @GetMapping("/addForModel")
    public void addForModel(CreateModelRequest createModelRequest) {
        this.filterService.addForModel(createModelRequest);
    }

    @GetMapping("/updateForBrand")
    public void updateForBrand(UpdateBrandRequest updateBrandRequest) {
        this.filterService.updateForBrand(updateBrandRequest);
    }

    @GetMapping("/updateForCar")
    public void updateForCar(UpdateCarRequest updateCarRequest) {
        this.filterService.updateForCar(updateCarRequest);
    }

    @GetMapping("/updateForModel")
    public void updateForModel(UpdateModelRequest updateModelRequest) {
        this.filterService.updateForModel(updateModelRequest);
    }


    @GetMapping("/getByBrandId")
    public GetBrandResponse getByBrandId(String brandId) {
        return this.filterService.getByBrandId(brandId);
    }

    @GetMapping("/getByModelId")
    public GetModelResponse getByModelId(String modelId) {
        return this.filterService.getByModelId(modelId);
    }

    @GetMapping("/getByCarId")
    public GetCarResponse getByCarId(String carId) {
        return this.filterService.getByCarId(carId);
    }

    @GetMapping("/getAllBrand")
    public List<GetAllBrandResponse> getAllBrand() {
        return this.filterService.getAllBrand();
    }

    @GetMapping("/getAllCar")
    public List<GetAllCarResponse> getAllCar() {
        return this.filterService.getAllCar();
    }

    @GetMapping("/getAllModel")
    public List<GetAllModelResponse> getAllModel() {
        return this.filterService.getAllModel();
    }

    @GetMapping("/getFilterByBrandName")
    public List<GetAllFilterResponse> getFilterByBrandName(String name) {
        return this.filterService.getFilterByBrandName(name);
    }

    @GetMapping("/getFilterByDailyPrice")
    public List<GetAllFilterResponse> getFilterByDailyPrice(double dailyPrice) {
        return this.filterService.getFilterByDailyPrice(dailyPrice);
    }

    @GetMapping("/getFilterByModelname")
    public List<GetAllFilterResponse> getFilterByModelname(String modelName) {
        return this.filterService.getFilterByModelname(modelName);
    }

    @GetMapping("/getFilterByDailyPriceGreaterThanEqual")
    public List<GetAllFilterResponse> getFilterByDailyPriceGreaterThanEqual(double dailyPrice) {
        return this.filterService.getFilterByDailyPriceGreaterThanEqual(dailyPrice);
    }

    @GetMapping("/getFilterByDailyPriceLessThanEqual")
    public List<GetAllFilterResponse> getFilterByDailyPriceLessThanEqual(double dailyPrice) {
        return this.filterService.getFilterByDailyPriceLessThanEqual(dailyPrice);
    }

    @GetMapping("/getFiltersByBrandNameOrModelname")
    public List<GetAllFilterResponse> getFiltersByBrandNameOrModelname(String brandName, String modelName) {
        return this.filterService.getFiltersByBrandNameOrModelname(brandName, modelName);
    }
}
