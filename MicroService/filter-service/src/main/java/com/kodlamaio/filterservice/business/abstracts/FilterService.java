package com.kodlamaio.filterservice.business.abstracts;

import com.kodlamaio.common.events.FilterCreatedEvent;
import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
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
    Result addForBrand(CreateBrandRequest createBrandRequest);

    Result addForCar(CreateCarRequest createCarRequest);

    Result addForModel(CreateModelRequest createModelRequest);

    // Update Operations
    Result updateForBrand(UpdateBrandRequest updateBrandRequest);

    Result updateForCar(UpdateCarRequest updateCarRequest);

    Result updateForModel(UpdateModelRequest updateModelRequest);


    DataResult<GetBrandResponse> getByBrandId(String brandId);

    DataResult<GetModelResponse> getByModelId(String modelId);

    DataResult<GetCarResponse> getByCarId(String carId);

    DataResult<List<GetAllBrandResponse>> getAllBrand();

    DataResult<List<GetAllCarResponse>> getAllCar();

    DataResult<List<GetAllModelResponse>> getAllModel();

    DataResult<List<GetAllFilterResponse>> getFilterByBrandName(String name);

    DataResult<List<GetAllFilterResponse>> getFilterByDailyPrice(double dailyPrice);

    DataResult<List<GetAllFilterResponse>> getFilterByModelname(String modelName);

   DataResult<List<GetAllFilterResponse>> getFilterByDailyPriceGreaterThanEqual(double dailyPrice);

   DataResult<List<GetAllFilterResponse>> getFilterByDailyPriceLessThanEqual(double dailyPrice);

   DataResult<List<GetAllFilterResponse>> getFiltersByBrandNameOrModelname(String brandName, String modelName);
}
