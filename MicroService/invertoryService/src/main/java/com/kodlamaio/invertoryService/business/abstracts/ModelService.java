package com.kodlamaio.invertoryService.business.abstracts;

import java.util.List;

import com.kodlamaio.invertoryService.business.requests.create.CreateModelRequest;
import com.kodlamaio.invertoryService.business.requests.delete.DeleteModelRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateModelRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateModelResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetAllModelsResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateModelResponse;

public interface ModelService {

	List<GetAllModelsResponse> getAll();
	CreateModelResponse add(CreateModelRequest createModelRequest);
	UpdateModelResponse update(UpdateModelRequest updateModelRequest);
	void delete(DeleteModelRequest deleteModelRequest);
}
