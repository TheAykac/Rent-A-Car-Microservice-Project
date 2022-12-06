package com.kodlamaio.filterservice.business.concretes;

import com.kodlamaio.common.events.FilterCreatedEvent;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
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
    public void addForBrand(CreateBrandRequest createBrandRequest) {
        Filter filter = this.modelMapperService.forRequest().map(createBrandRequest, Filter.class);
        this.filterRepository.save(filter);
    }

    @Override
    public void addForCar(CreateCarRequest createCarRequest) {
        Filter filter = this.modelMapperService.forRequest().map(createCarRequest, Filter.class);
        this.filterRepository.save(filter);

    }

    @Override
    public void addForModel(CreateModelRequest createModelRequest) {
        Filter filter = this.modelMapperService.forRequest().map(createModelRequest, Filter.class);
        this.filterRepository.save(filter);
    }

    @Override
    public void updateForBrand(UpdateBrandRequest updateBrandRequest) {
        Filter filter = this.modelMapperService.forRequest().map(updateBrandRequest, Filter.class);
        this.filterRepository.save(filter);
    }

    @Override
    public void updateForCar(UpdateCarRequest updateCarRequest) {
        Filter filter = this.modelMapperService.forRequest().map(updateCarRequest, Filter.class);
        this.filterRepository.save(filter);

    }

    @Override
    public void updateForModel(UpdateModelRequest updateModelRequest) {
        Filter filter = this.modelMapperService.forRequest().map(updateModelRequest, Filter.class);
        this.filterRepository.save(filter);

    }

    @Override
    public GetBrandResponse getByBrandId(String brandId) {
        Filter filter = this.filterRepository.findById(brandId).get();
        GetBrandResponse getBrandResponse = this.modelMapperService.forResponse().map(filter, GetBrandResponse.class);
        return getBrandResponse;
    }

    @Override
    public GetModelResponse getByModelId(String modelId) {
        Filter filter = this.filterRepository.findById(modelId).get();
        GetModelResponse getModelResponse = this.modelMapperService.forResponse().map(filter, GetModelResponse.class);
        return getModelResponse;
    }

    @Override
    public GetCarResponse getByCarId(String carId) {
        Filter filter = this.filterRepository.findById(carId).get();
        GetCarResponse getCarResponse = this.modelMapperService.forResponse().map(filter, GetCarResponse.class);
        return getCarResponse;
    }

    @Override
    public List<GetAllBrandResponse> getAllBrand() {
        List<Filter> filters = this.filterRepository.findAll();
        List<GetAllBrandResponse> getAllBrandResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllBrandResponse.class)).collect(Collectors.toList());
        return getAllBrandResponses;
    }

    @Override
    public List<GetAllCarResponse> getAllCar() {
        List<Filter> filters = this.filterRepository.findAll();
        List<GetAllCarResponse> getAllCarResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filters, GetAllCarResponse.class)).collect(Collectors.toList());
        return getAllCarResponses;
    }

    @Override
    public List<GetAllModelResponse> getAllModel() {
        List<Filter> filters = this.filterRepository.findAll();
        List<GetAllModelResponse> getAllModelResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllModelResponse.class)).collect(Collectors.toList());
        return getAllModelResponses;
    }

    @Override
    public List<GetAllFilterResponse> getFilterByBrandName(String name) {
        List<Filter> filters = this.filterRepository.getFilterByBrandName(name);
        List<GetAllFilterResponse> getAllFilterResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());
        return getAllFilterResponses;

    }

    @Override
    public List<GetAllFilterResponse> getFilterByDailyPrice(double dailyPrice) {
        List<Filter> filters = this.filterRepository.getFilterByDailyPrice(dailyPrice);
        List<GetAllFilterResponse> getAllFilterResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());
        return getAllFilterResponses;
    }

    @Override
    public List<GetAllFilterResponse> getFilterByModelname(String modelName) {
        List<Filter> filters = this.filterRepository.getFilterByModelname(modelName);
        List<GetAllFilterResponse> getAllFilterResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());
        return getAllFilterResponses;
    }

    @Override
    public List<GetAllFilterResponse> getFilterByDailyPriceGreaterThanEqual(double dailyPrice) {
        List<Filter> filters = this.filterRepository.getFilterByDailyPriceGreaterThanEqual(dailyPrice);
        List<GetAllFilterResponse> getAllFilterResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());
        return getAllFilterResponses;
    }

    @Override
    public List<GetAllFilterResponse> getFilterByDailyPriceLessThanEqual(double dailyPrice) {
        List<Filter> filters = this.filterRepository.getFilterByDailyPriceLessThanEqual(dailyPrice);
        List<GetAllFilterResponse> getAllFilterResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());
        return getAllFilterResponses;
    }

    @Override
    public List<GetAllFilterResponse> getFiltersByBrandNameOrModelname(String brandName, String modelName) {
        List<Filter> filters = this.filterRepository.getFiltersByBrandNameOrModelname(brandName, modelName);
        List<GetAllFilterResponse> getAllFilterResponses = filters.stream().map(filter -> this.modelMapperService.forResponse().map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());
        return getAllFilterResponses;
    }

    @Override
    public void filter(FilterCreatedEvent event) {
        Filter filter = this.modelMapperService.forRequest().map(event, Filter.class);
        this.filterRepository.save(filter);
    }
}
