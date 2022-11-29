package com.kodlamaio.inventoryService.business.abstracts;

import com.kodlamaio.inventoryService.business.requests.create.CreateCarRequest;
import com.kodlamaio.inventoryService.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.inventoryService.business.responses.create.CreateCarResponse;
import com.kodlamaio.inventoryService.business.responses.get.GetCarsResponse;
import com.kodlamaio.inventoryService.business.responses.getAll.GetAllCarsResponse;
import com.kodlamaio.inventoryService.business.responses.update.UpdateBrandResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    GetCarsResponse getById(String id);
    UpdateBrandResponse update (UpdateBrandRequest updateBrandRequest);
    void delete (String id);

    CreateCarResponse add(CreateCarRequest createCarRequest);
}
