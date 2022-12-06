package com.kodlamaio.filterservice.business.concretes;

import com.kodlamaio.common.events.FilterCreatedEvent;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.common.utilities.messages.BusinessMessage;
import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.common.utilities.result.SuccessDataResult;
import com.kodlamaio.common.utilities.result.SuccessResult;
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
import com.kodlamaio.filterservice.dataAccess.FilterRepository;
import com.kodlamaio.filterservice.entities.Filter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilterManager implements FilterService {

    private FilterRepository filterRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Result addForBrand(CreateBrandRequest createBrandRequest) {
        Filter filter = this.modelMapperService.forRequest().map(createBrandRequest, Filter.class);
        this.filterRepository.save(filter);
        return new SuccessResult(BusinessMessage.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
    }

    @Override
    public Result addForCar(CreateCarRequest createCarRequest) {
        Filter filter = this.modelMapperService.forRequest().map(createCarRequest, Filter.class);
        this.filterRepository.save(filter);
        return new SuccessResult(BusinessMessage.GlobalMessages.DATA_ADDED_SUCCESSFULLY);

    }

    @Override
    public Result addForModel(CreateModelRequest createModelRequest) {
        Filter filter = this.modelMapperService.forRequest().map(createModelRequest, Filter.class);
        this.filterRepository.save(filter);
        return new SuccessResult(BusinessMessage.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
    }

    @Override
    public Result updateForBrand(UpdateBrandRequest updateBrandRequest) {
        Filter filter = this.modelMapperService.forRequest().map(updateBrandRequest, Filter.class);
        this.filterRepository.save(filter);
        return new SuccessResult(BusinessMessage.GlobalMessages.DATA_UPDATED_SUCCESSFULLY);
    }

    @Override
    public Result updateForCar(UpdateCarRequest updateCarRequest) {
        Filter filter = this.modelMapperService.forRequest().map(updateCarRequest, Filter.class);
        this.filterRepository.save(filter);
        return new SuccessResult(BusinessMessage.GlobalMessages.DATA_UPDATED_SUCCESSFULLY);

    }

    @Override
    public Result updateForModel(UpdateModelRequest updateModelRequest) {
        Filter filter = this.modelMapperService.forRequest().map(updateModelRequest, Filter.class);
        this.filterRepository.save(filter);
        return new SuccessResult(BusinessMessage.GlobalMessages.DATA_UPDATED_SUCCESSFULLY);

    }

    @Override
    public DataResult<GetBrandResponse> getByBrandId(String brandId) {
        Filter filter = this.filterRepository.findById(brandId).get();
        GetBrandResponse getBrandResponse = this.modelMapperService.forResponse().map(filter, GetBrandResponse.class);
        return  new SuccessDataResult(getBrandResponse,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<GetModelResponse> getByModelId(String modelId) {
        Filter filter = this.filterRepository.findById(modelId).get();
        GetModelResponse getModelResponse = this.modelMapperService.forResponse().map(filter, GetModelResponse.class);
        return  new SuccessDataResult(getModelResponse,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<GetCarResponse> getByCarId(String carId) {
        Filter filter = this.filterRepository.findById(carId).get();
        GetCarResponse getCarResponse = this.modelMapperService.forResponse().map(filter, GetCarResponse.class);
        return new SuccessDataResult(getCarResponse,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<List<GetAllBrandResponse>> getAllBrand() {
        List<Filter> filters = this.filterRepository.findAll();
        List<GetAllBrandResponse> getAllBrandResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllBrandResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllBrandResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<List<GetAllCarResponse>> getAllCar() {
        List<Filter> filters = this.filterRepository.findAll();
        List<GetAllCarResponse> getAllCarResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filters, GetAllCarResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllCarResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<List<GetAllModelResponse>> getAllModel() {
        List<Filter> filters = this.filterRepository.findAll();
        List<GetAllModelResponse> getAllModelResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllModelResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllModelResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<List<GetAllFilterResponse>> getFilterByBrandName(String name) {
        List<Filter> filters = this.filterRepository.getFilterByBrandName(name);
        List<GetAllFilterResponse> getAllFilterResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllFilterResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);

    }

    @Override
    public DataResult<List<GetAllFilterResponse>> getFilterByDailyPrice(double dailyPrice) {
        List<Filter> filters = this.filterRepository.getFilterByDailyPrice(dailyPrice);
        List<GetAllFilterResponse> getAllFilterResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllFilterResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<List<GetAllFilterResponse>> getFilterByModelname(String modelName) {
        List<Filter> filters = this.filterRepository.getFilterByModelname(modelName);
        List<GetAllFilterResponse> getAllFilterResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllFilterResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<List<GetAllFilterResponse>> getFilterByDailyPriceGreaterThanEqual(double dailyPrice) {
        List<Filter> filters = this.filterRepository.getFilterByDailyPriceGreaterThanEqual(dailyPrice);
        List<GetAllFilterResponse> getAllFilterResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllFilterResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<List<GetAllFilterResponse>> getFilterByDailyPriceLessThanEqual(double dailyPrice) {
        List<Filter> filters = this.filterRepository.getFilterByDailyPriceLessThanEqual(dailyPrice);
        List<GetAllFilterResponse> getAllFilterResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllFilterResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<List<GetAllFilterResponse>> getFiltersByBrandNameOrModelname(String brandName, String modelName) {
        List<Filter> filters = this.filterRepository.getFiltersByBrandNameOrModelname(brandName, modelName);
        List<GetAllFilterResponse> getAllFilterResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllFilterResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public void filter(FilterCreatedEvent event) {
        Filter filter = this.modelMapperService.forRequest().map(event, Filter.class);
        this.filterRepository.save(filter);
    }
}
