package com.kodlamaio.invertoryService.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.invertoryService.business.abstracts.ModelService;
import com.kodlamaio.invertoryService.business.requests.create.CreateModelRequest;
import com.kodlamaio.invertoryService.business.requests.delete.DeleteModelRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateModelRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateModelResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetAllModelsResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateModelResponse;
import com.kodlamaio.invertoryService.dataAccess.ModelRepository;
import com.kodlamaio.invertoryService.entities.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		List<GetAllModelsResponse> responses = models.stream()
				.map(model->modelMapperService.forResponse().map(model,GetAllModelsResponse.class)).toList();
		return responses;
	}

	@Override
	public CreateModelResponse add(CreateModelRequest createModelRequest) {
		Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
		model.setId(UUID.randomUUID().toString());
		modelRepository.save(model);
		
		CreateModelResponse response = modelMapperService.forResponse().map(model, CreateModelResponse.class);
		return response;
	}

	@Override
	public UpdateModelResponse update(UpdateModelRequest updateModelRequest) {
		Model model = modelMapperService.forRequest().map(updateModelRequest, Model.class);
		modelRepository.save(model);
		
		UpdateModelResponse response = modelMapperService.forResponse().map(model, UpdateModelResponse.class);
		return response;
	}

	@Override
	public void delete(DeleteModelRequest deleteModelRequest) {
		Model model = modelMapperService.forRequest().map(deleteModelRequest, Model.class);
		modelRepository.delete(model);
		
	}

}
