package com.kodlamaio.inventoryservice.business.abstracts;

import com.kodlamaio.inventoryservice.business.requests.create.CreateCarRequest;
import com.kodlamaio.inventoryservice.business.requests.update.UpdateCarRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateCarResponse;
import com.kodlamaio.inventoryservice.business.responses.delete.DeleteCarResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllCarResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetCarResponse;
import com.kodlamaio.inventoryservice.business.responses.update.UpdateCarResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarResponse> getAll();

    GetCarResponse getById(String id);

    UpdateCarResponse update(UpdateCarRequest updateCarRequest);

    DeleteCarResponse delete(String id);


    CreateCarResponse add(CreateCarRequest createCarRequest);
}
