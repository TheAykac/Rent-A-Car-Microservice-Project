package com.kodlamaio.filterservice.api.controllers;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
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
    public Result addForBrand(CreateBrandRequest createBrandRequest) {
        return this.filterService.addForBrand(createBrandRequest);
    }

    @GetMapping("/addForCar")
    public Result addForCar(CreateCarRequest createCarRequest) {
        return this.filterService.addForCar(createCarRequest);
    }

    @GetMapping("/addForModel")
    public Result addForModel(CreateModelRequest createModelRequest) {
        return this.filterService.addForModel(createModelRequest);
    }

    @GetMapping("/updateForBrand")
    public Result updateForBrand(UpdateBrandRequest updateBrandRequest) {
        return this.filterService.updateForBrand(updateBrandRequest);
    }

    @GetMapping("/updateForCar")
    public Result updateForCar(UpdateCarRequest updateCarRequest) {
        return this.filterService.updateForCar(updateCarRequest);
    }

    @GetMapping("/updateForModel")
    public Result updateForModel(UpdateModelRequest updateModelRequest) {
        return this.filterService.updateForModel(updateModelRequest);
    }


    @GetMapping("/getByBrandId")
    public DataResult<GetBrandResponse> getByBrandId(String brandId) {
        return this.filterService.getByBrandId(brandId);
    }

    @GetMapping("/getByModelId")
    public DataResult<GetModelResponse> getByModelId(String modelId) {
        return this.filterService.getByModelId(modelId);
    }

    @GetMapping("/getByCarId")
    public DataResult<GetCarResponse> getByCarId(String carId) {
        return this.filterService.getByCarId(carId);
    }

    @GetMapping("/getAllBrand")
    public DataResult<List<GetAllBrandResponse>> getAllBrand() {
        return this.filterService.getAllBrand();
    }

    @GetMapping("/getAllCar")
    public DataResult<List<GetAllCarResponse>> getAllCar() {
        return this.filterService.getAllCar();
    }

    @GetMapping("/getAllModel")
    public DataResult<List<GetAllModelResponse>> getAllModel() {
        return this.filterService.getAllModel();
    }

    @GetMapping("/getFilterByBrandName")
    public DataResult<List<GetAllFilterResponse>> getFilterByBrandName(String name) {
        return this.filterService.getFilterByBrandName(name);
    }

    @GetMapping("/getFilterByDailyPrice")
    public DataResult<List<GetAllFilterResponse>> getFilterByDailyPrice(double dailyPrice) {
        return this.filterService.getFilterByDailyPrice(dailyPrice);
    }

    @GetMapping("/getFilterByModelname")
    public DataResult<List<GetAllFilterResponse>> getFilterByModelname(String modelName) {
        return this.filterService.getFilterByModelname(modelName);
    }

    @GetMapping("/getFilterByDailyPriceGreaterThanEqual")
    public DataResult<List<GetAllFilterResponse>> getFilterByDailyPriceGreaterThanEqual(double dailyPrice) {
        return this.filterService.getFilterByDailyPriceGreaterThanEqual(dailyPrice);
    }

    @GetMapping("/getFilterByDailyPriceLessThanEqual")
    public DataResult<List<GetAllFilterResponse>> getFilterByDailyPriceLessThanEqual(double dailyPrice) {
        return this.filterService.getFilterByDailyPriceLessThanEqual(dailyPrice);
    }

    @GetMapping("/getFiltersByBrandNameOrModelname")
    public DataResult<List<GetAllFilterResponse>> getFiltersByBrandNameOrModelname(String brandName, String modelName) {
        return this.filterService.getFiltersByBrandNameOrModelname(brandName, modelName);
    }
}
