package com.kodlamaio.invertoryService.business.concretes;


import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.invertoryService.business.abstracts.CarService;
import com.kodlamaio.invertoryService.business.requests.create.CreateCarRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateCarRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateCarResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetAllCarsResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateCarResponse;
import com.kodlamaio.invertoryService.dataAccess.CarRespository;
import com.kodlamaio.invertoryService.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	private final CarRespository repository;
	private final ModelMapperService mapper;

	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = repository.findAll();
		List<GetAllCarsResponse> response = cars
				.stream()
				.map(car -> mapper.forResponse().map(car, GetAllCarsResponse.class))
				.toList();

		return response;
	}



	@Override
	public CreateCarResponse add(CreateCarRequest request) {

		Car car = mapper.forRequest().map(request, Car.class);
		car.setId(UUID.randomUUID().toString());
		car.setState(1); // state 1 Available, satate 2 NotAvailable
		repository.save(car);
		CreateCarResponse response = mapper.forResponse().map(car, CreateCarResponse.class);

		return response;
	}

	@Override
	public UpdateCarResponse update(UpdateCarRequest request, String id) {
		checkIfCarExistsById(id);
		Car car = mapper.forRequest().map(request, Car.class);
		car.setId(id);
		repository.save(car);
		UpdateCarResponse response = mapper.forResponse().map(car, UpdateCarResponse.class);

		return response;
	}

	@Override
	public void delete(String id) {
		checkIfCarExistsById(id);
		repository.deleteById(id);
	}

	private void checkIfCarExistsById(String id) {
		if (!repository.existsById(id)) {
			throw new BusinessException("CAR.NOT_EXISTS");
		}
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
		if (car.getState()==3){
			throw new BusinessException("This Car Not Available");
		}
	}
}

//openfeign