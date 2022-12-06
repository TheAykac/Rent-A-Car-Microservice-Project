package com.kodlamaio.invertoryService.business.concretes;


import com.kodlamaio.common.events.FilterCreatedEvent;
import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.common.utilities.messages.BusinessMessage;
import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.common.utilities.result.SuccessDataResult;
import com.kodlamaio.common.utilities.result.SuccessResult;
import com.kodlamaio.invertoryService.business.abstracts.CarService;
import com.kodlamaio.invertoryService.business.requests.create.CreateCarRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateCarRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateCarResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetCarResponse;
import com.kodlamaio.invertoryService.business.responses.getAll.GetAllCarsResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateCarResponse;
import com.kodlamaio.invertoryService.dataAccess.CarRespository;
import com.kodlamaio.invertoryService.entities.Car;
import com.kodlamaio.invertoryService.kafka.FilterProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	private final CarRespository repository;
	private final ModelMapperService mapper;
	private FilterProducer filterProducer;

	@Override
	public DataResult<List<GetAllCarsResponse>> getAll() {
		List<Car> cars = repository.findAll();
		List<GetAllCarsResponse> response = cars
				.stream()
				.map(car -> mapper.forResponse().map(car, GetAllCarsResponse.class))
				.toList();

		return new SuccessDataResult<>(response, BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public DataResult<GetCarResponse> getById(String id) {
		checkIfExistsById(id);
		Car car = this.repository.findById(id).get();
		GetCarResponse getBrandResponse = this.mapper.forResponse().map(car, GetCarResponse.class);
		return new SuccessDataResult<>(getBrandResponse, BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public DataResult<CreateCarResponse> add(CreateCarRequest request) {

		Car car = mapper.forRequest().map(request, Car.class);
		car.setId(UUID.randomUUID().toString());
		car.setState(1); // state 1 Available, satate 2 NotAvailable
		repository.save(car);
		CreateCarResponse response = mapper.forResponse().map(car, CreateCarResponse.class);

		FilterCreatedEvent filterCreatedEvent = new FilterCreatedEvent();
		filterCreatedEvent.setPlate(car.getPlate());
		filterCreatedEvent.setDailyPrice(car.getDailyPrice());
		filterCreatedEvent.setState(car.getState());
		filterCreatedEvent.setModelYear(car.getModelYear());
		filterCreatedEvent.setModelname(car.getModel().getName());
		filterCreatedEvent.setBrandName(car.getModel().getBrand().getName());
		filterCreatedEvent.setBrandId(car.getModel().getBrand().getId());
		filterCreatedEvent.setState(car.getState());

		filterProducer.sendMessage(filterCreatedEvent);
		return new SuccessDataResult<>(response, BusinessMessage.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
	}

	@Override
	public DataResult<UpdateCarResponse> update(UpdateCarRequest request, String id) {
		checkIfExistsById(id);
		Car car = mapper.forRequest().map(request, Car.class);
		car.setId(id);
		repository.save(car);
		UpdateCarResponse response = mapper.forResponse().map(car, UpdateCarResponse.class);

		return new SuccessDataResult<>(response, BusinessMessage.GlobalMessages.DATA_UPDATED_SUCCESSFULLY);
	}

	@Override
	public Result delete(String id) {
		checkIfExistsById(id);
		repository.deleteById(id);
		return new SuccessResult(BusinessMessage.GlobalMessages.DATA_DELETED_SUCCESSFULLY);
	}


	@Override
	public UpdateCarResponse updateCarStateForRental(String carId,int state) {
		Car car = this.repository.findById(carId).get();
		car.setState(state);
		this.repository.save(car);
		UpdateCarResponse updateCarResponse = this.mapper.forResponse().map(car,UpdateCarResponse.class);
		return updateCarResponse;
	}


	@Override
	public void checkIfCarAvailable(String carId) {
		Car car = this.repository.findById(carId).get();
		if (car.getState() == 3) {
			throw new BusinessException("This Car Not Available");
		}
	}

	private void checkIfExistsById(String id) {
		if (!this.repository.existsById(id)) {
			throw new BusinessException(BusinessMessage.GlobalMessages.ID_NOT_FOUND + id);
		}
	}
}

//openfeign