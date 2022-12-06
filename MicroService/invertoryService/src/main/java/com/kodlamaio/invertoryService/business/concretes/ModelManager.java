package com.kodlamaio.invertoryService.business.concretes;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.common.utilities.messages.BusinessMessage;
import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.common.utilities.result.SuccessDataResult;
import com.kodlamaio.common.utilities.result.SuccessResult;
import com.kodlamaio.invertoryService.business.abstracts.ModelService;
import com.kodlamaio.invertoryService.business.requests.create.CreateModelRequest;
import com.kodlamaio.invertoryService.business.requests.delete.DeleteModelRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateModelRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateModelResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetModelResponse;
import com.kodlamaio.invertoryService.business.responses.getAll.GetAllModelsResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateModelResponse;
import com.kodlamaio.invertoryService.dataAccess.ModelRepository;
import com.kodlamaio.invertoryService.entities.Model;
import com.kodlamaio.invertoryService.kafka.FilterProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

	
	@Override
	public DataResult<List<GetAllModelsResponse>> getAll() {
		List<Model> models = modelRepository.findAll();
		List<GetAllModelsResponse> responses = models.stream()
				.map(model->modelMapperService.forResponse().map(model,GetAllModelsResponse.class)).toList();
		return new SuccessDataResult<>(responses, BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public DataResult<CreateModelResponse> add(CreateModelRequest createModelRequest) {
		Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
		model.setId(UUID.randomUUID().toString());
		modelRepository.save(model);
		CreateModelResponse response = modelMapperService.forResponse().map(model, CreateModelResponse.class);
		return new SuccessDataResult<>(response,BusinessMessage.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
	}

	@Override
	public DataResult<UpdateModelResponse> update(UpdateModelRequest updateModelRequest) {
		checkIfExistsById(updateModelRequest.getId());
		Model model = modelMapperService.forRequest().map(updateModelRequest, Model.class);
		modelRepository.save(model);
		
		UpdateModelResponse response = modelMapperService.forResponse().map(model, UpdateModelResponse.class);
		return new SuccessDataResult<>(response,BusinessMessage.GlobalMessages.DATA_UPDATED_SUCCESSFULLY);
	}

	@Override
	public Result delete(DeleteModelRequest deleteModelRequest) {
		checkIfExistsById(deleteModelRequest.getId());
		Model model = modelMapperService.forRequest().map(deleteModelRequest, Model.class);
		modelRepository.delete(model);
		return new SuccessResult(BusinessMessage.GlobalMessages.DATA_DELETED_SUCCESSFULLY);
		
	}

	@Override
	public DataResult<GetModelResponse> getById(String id) {
		checkIfExistsById(id);
		Model model = this.modelRepository.findById(id).get();
		GetModelResponse getModelResponse= this.modelMapperService.forResponse().map(model,GetModelResponse.class);
		return new SuccessDataResult<>(getModelResponse,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	private void checkIfExistsById(String id){
		if (!this.modelRepository.existsById(id)){
			throw new BusinessException(BusinessMessage.GlobalMessages.ID_NOT_FOUND+id);
		}
	}
}
