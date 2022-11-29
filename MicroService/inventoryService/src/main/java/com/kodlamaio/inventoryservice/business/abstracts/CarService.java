package com.kodlamaio.inventoryservice.business.abstracts;

import com.kodlamaio.inventoryservice.business.requests.create.CreateCarRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateCarResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllCarResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarResponse> getAll();
    CreateCarResponse add(CreateCarRequest createCarRequest);
}
