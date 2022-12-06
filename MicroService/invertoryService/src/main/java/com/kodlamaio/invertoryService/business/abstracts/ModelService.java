package com.kodlamaio.invertoryService.business.abstracts;

import java.util.List;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.invertoryService.business.requests.create.CreateModelRequest;
import com.kodlamaio.invertoryService.business.requests.delete.DeleteModelRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateModelRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateModelResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetModelResponse;
import com.kodlamaio.invertoryService.business.responses.getAll.GetAllModelsResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateModelResponse;

import javax.xml.crypto.Data;

public interface ModelService {

	DataResult<List<GetAllModelsResponse>> getAll();
	DataResult<CreateModelResponse> add(CreateModelRequest createModelRequest);
	DataResult<UpdateModelResponse> update(UpdateModelRequest updateModelRequest);
	Result delete(DeleteModelRequest deleteModelRequest);
	DataResult<GetModelResponse> getById(String id);
}
