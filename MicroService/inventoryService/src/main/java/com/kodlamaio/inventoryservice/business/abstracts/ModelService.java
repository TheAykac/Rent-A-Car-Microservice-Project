package com.kodlamaio.inventoryservice.business.abstracts;

import com.kodlamaio.inventoryservice.business.requests.create.CreateModelRequest;
import com.kodlamaio.inventoryservice.business.requests.update.UpdateCarRequest;
import com.kodlamaio.inventoryservice.business.requests.update.UpdateModelRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateModelResponse;
import com.kodlamaio.inventoryservice.business.responses.delete.DeleteModelResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllModelResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetModelResponse;
import com.kodlamaio.inventoryservice.business.responses.update.UpdateModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();

    CreateModelResponse add(CreateModelRequest createModelRequest);

    GetModelResponse getById(String id);

    DeleteModelResponse delete(String id);
    UpdateModelResponse update (UpdateModelRequest updateModelRequest);

    void checkIfExistByModelId(String id);
}
