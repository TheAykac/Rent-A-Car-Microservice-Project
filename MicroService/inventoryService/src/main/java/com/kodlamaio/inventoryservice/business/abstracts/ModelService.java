package com.kodlamaio.inventoryservice.business.abstracts;

import com.kodlamaio.inventoryservice.business.requests.create.CreateModelRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateModelResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();
    CreateModelResponse add (CreateModelRequest createModelRequest);
}
