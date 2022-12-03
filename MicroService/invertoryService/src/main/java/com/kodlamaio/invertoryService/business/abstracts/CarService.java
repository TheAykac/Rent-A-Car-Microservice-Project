package com.kodlamaio.invertoryService.business.abstracts;

import java.util.List;

import com.kodlamaio.invertoryService.business.requests.create.CreateCarRequest;
import com.kodlamaio.invertoryService.business.requests.delete.DeleteCarRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateCarRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateCarResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetAllCarsResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateCarResponse;
import org.springframework.stereotype.Service;


public interface CarService {

	List<GetAllCarsResponse> getAll();
	UpdateCarResponse updateCarStateForRental(String carId);

	CreateCarResponse add(CreateCarRequest request);
	UpdateCarResponse update(UpdateCarRequest request, String id);
	void delete(String id);
	void checkIfCarAvailable(String carId);
}
