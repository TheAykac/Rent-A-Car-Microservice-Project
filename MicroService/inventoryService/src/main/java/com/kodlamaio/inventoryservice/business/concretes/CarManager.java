package com.kodlamaio.inventoryservice.business.concretes;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.inventoryservice.business.abstracts.CarService;
import com.kodlamaio.inventoryservice.business.abstracts.ModelService;
import com.kodlamaio.inventoryservice.business.contants.BusinessMessage;
import com.kodlamaio.inventoryservice.business.requests.create.CreateCarRequest;
import com.kodlamaio.inventoryservice.business.requests.update.UpdateCarRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateCarResponse;
import com.kodlamaio.inventoryservice.business.responses.delete.DeleteCarResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllCarResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetCarResponse;
import com.kodlamaio.inventoryservice.business.responses.update.UpdateCarResponse;
import com.kodlamaio.inventoryservice.dataAccess.CarRepository;
import com.kodlamaio.inventoryservice.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private ModelMapperService modelMapperService;
    private CarRepository carRepository;
    private ModelService modelService;
    @Override
    public List<GetAllCarResponse> getAll() {
        List<Car> cars=this.carRepository.findAll();
        List<GetAllCarResponse> getAllCarResponses=cars.stream().map(car -> this.modelMapperService.forResponse().map(car,GetAllCarResponse.class)).collect(Collectors.toList());
        return getAllCarResponses;
    }

    @Override
    public GetCarResponse getById(String id) {
        checkIfExistsByCarId(id);
        Car car = this.carRepository.findById(id).get();
        GetCarResponse getCarResponse=this.modelMapperService.forResponse().map(car,GetCarResponse.class);
        return getCarResponse;
    }

    @Override
    public UpdateCarResponse update(UpdateCarRequest updateCarRequest) {
        checkIfExistsByCarId(updateCarRequest.getId());
        this.modelService.checkIfExistByModelId(updateCarRequest.getModelId());
        Car car = this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
        UpdateCarResponse updateCarResponse=this.modelMapperService.forResponse().map(car,UpdateCarResponse.class);
        return updateCarResponse;
    }

    @Override
    public DeleteCarResponse delete(String id) {
        checkIfExistsByCarId(id);
        Car car = this.carRepository.findById(id).get();
        this.carRepository.delete(car);
        DeleteCarResponse deleteCarResponse = this.modelMapperService.forResponse().map(car,DeleteCarResponse.class);
        return deleteCarResponse;
    }

    @Override
    public CreateCarResponse add(CreateCarRequest createCarRequest) {
        this.modelService.checkIfExistByModelId(createCarRequest.getModelId());
        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);
        car.setId(UUID.randomUUID().toString());
        this.carRepository.save(car);
        CreateCarResponse createCarResponse =this.modelMapperService.forResponse().map(car,CreateCarResponse.class);
        return createCarResponse;
    }

    private  void checkIfExistsByCarId(String id){
        if (!this.carRepository.existsById(id)){
            throw new BusinessException(BusinessMessage.CarMessages.CarIdNotFound+id);
        }
    }
}
