package com.kodlamaio.inventoryService.business.concretes;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.inventoryService.business.abstracts.CarService;
import com.kodlamaio.inventoryService.business.constants.Messages;
import com.kodlamaio.inventoryService.business.requests.create.CreateCarRequest;
import com.kodlamaio.inventoryService.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.inventoryService.business.responses.create.CreateCarResponse;
import com.kodlamaio.inventoryService.business.responses.get.GetCarsResponse;
import com.kodlamaio.inventoryService.business.responses.getAll.GetAllCarsResponse;
import com.kodlamaio.inventoryService.business.responses.update.UpdateBrandResponse;
import com.kodlamaio.inventoryService.dataAccess.CarRepository;
import com.kodlamaio.inventoryService.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllCarsResponse> getAll() {

        List<Car> cars = this.carRepository.findAll();
        List<GetAllCarsResponse> getAllCarsResponses = cars.stream().map(car -> this.modelMapperService.forResponse().map(cars,GetAllCarsResponse.class)).collect(Collectors.toList());
        return getAllCarsResponses;
    }

    @Override
    public GetCarsResponse getById(String id) {
        checkIfExistsByCarId(id);
        Car car = this.carRepository.getById(id);
        GetCarsResponse getCarsResponse = this.modelMapperService.forResponse().map(car,GetCarsResponse.class);
        return getCarsResponse;
    }

    @Override
    public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        Car car = this.modelMapperService.forRequest().map(updateBrandRequest,Car.class);
        this.carRepository.save(car);

        UpdateBrandResponse updateBrandResponse = this.modelMapperService.forResponse().map(car,UpdateBrandResponse.class);
        return updateBrandResponse;
    }

    @Override
    public void delete(String id) {
        this.carRepository.deleteById(id);
    }

    @Override
    public CreateCarResponse add(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);
        this.carRepository.save(car);

        CreateCarResponse createCarResponse = this.modelMapperService.forResponse().map(car,CreateCarResponse.class);

        return createCarResponse;
    }

    private void checkIfExistsByCarId(String id){
        if (!this.carRepository.existsById(id)){
            throw new BusinessException(Messages.Car.CarIdNotFound+id);
        }
    }

}
