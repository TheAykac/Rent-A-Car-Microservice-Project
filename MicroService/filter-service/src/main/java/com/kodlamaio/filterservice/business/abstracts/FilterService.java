package com.kodlamaio.filterservice.business.abstracts;

import com.kodlamaio.common.events.FilterCreatedEvent;
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

import java.util.List;

public interface FilterService {

    void filter(FilterCreatedEvent event);

    //Create Operations
    void addForBrand(CreateBrandRequest createBrandRequest);

    void addForCar(CreateCarRequest createCarRequest);

    void addForModel(CreateModelRequest createModelRequest);

    // Update Operations
    void updateForBrand(UpdateBrandRequest updateBrandRequest);

    void updateForCar(UpdateCarRequest updateCarRequest);

    void updateForModel(UpdateModelRequest updateModelRequest);


    GetBrandResponse getByBrandId(String brandId);

    GetModelResponse getByModelId(String modelId);

    GetCarResponse getByCarId(String carId);

    List<GetAllBrandResponse> getAllBrand();

    List<GetAllCarResponse> getAllCar();

    List<GetAllModelResponse> getAllModel();

    List<GetAllFilterResponse> getFilterByBrandName(String name);

    List<GetAllFilterResponse> getFilterByDailyPrice(double dailyPrice);

    List<GetAllFilterResponse> getFilterByModelname(String modelName);

    List<GetAllFilterResponse> getFilterByDailyPriceGreaterThanEqual(double dailyPrice);

    List<GetAllFilterResponse> getFilterByDailyPriceLessThanEqual(double dailyPrice);

    List<GetAllFilterResponse> getFiltersByBrandNameOrModelname(String brandName, String modelName);
}
