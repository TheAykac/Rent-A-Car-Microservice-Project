package com.kodlamaio.inventoryservice.business.concretes;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.inventoryservice.business.abstracts.ModelService;
import com.kodlamaio.inventoryservice.business.contants.BusinessMessage;
import com.kodlamaio.inventoryservice.business.requests.create.CreateModelRequest;
import com.kodlamaio.inventoryservice.business.requests.update.UpdateCarRequest;
import com.kodlamaio.inventoryservice.business.requests.update.UpdateModelRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateModelResponse;
import com.kodlamaio.inventoryservice.business.responses.delete.DeleteBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.delete.DeleteModelResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllModelResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetModelResponse;
import com.kodlamaio.inventoryservice.business.responses.update.UpdateBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.update.UpdateModelResponse;
import com.kodlamaio.inventoryservice.dataAccess.ModelRepository;
import com.kodlamaio.inventoryservice.entities.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelMapperService modelMapperService;
    private ModelRepository modelRepository;
    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = this.modelRepository.findAll();
        List<GetAllModelResponse> getAllModelResponses= models.stream().map(model -> this.modelMapperService.forResponse().map(model,GetAllModelResponse.class)).collect(Collectors.toList());
        return getAllModelResponses;
    }

    @Override
    public CreateModelResponse add(CreateModelRequest createModelRequest) {

        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        model.setId(UUID.randomUUID().toString());
        this.modelRepository.save(model);

        CreateModelResponse createModelResponse = this.modelMapperService.forResponse().map(model,CreateModelResponse.class);
        return createModelResponse;
    }

    @Override
    public GetModelResponse getById(String id) {
        checkIfExistByModelId(id);
        Model model = this.modelRepository.findById(id).get();
        GetModelResponse getModelResponse= this.modelMapperService.forResponse().map(model,GetModelResponse.class);
        return getModelResponse;
    }

    @Override
    public DeleteModelResponse delete(String id) {
        checkIfExistByModelId(id);
        Model model = this.modelRepository.findById(id).get();
        this.modelRepository.delete(model);
        DeleteModelResponse deleteModelResponse = this.modelMapperService.forResponse().map(model,DeleteModelResponse.class);
        return deleteModelResponse;
    }

    @Override
    public UpdateModelResponse update(UpdateModelRequest updateModelRequest) {
        checkIfExistByModelId(updateModelRequest.getId());
        Model model = this.modelMapperService.forRequest().map(updateModelRequest,Model.class);
        this.modelRepository.save(model);
       UpdateModelResponse updateModelResponse = this.modelMapperService.forResponse().map(model,UpdateModelResponse.class);
        return updateModelResponse;
    }
    @Override
    public void checkIfExistByModelId(String id){
        if (!this.modelRepository.existsById(id)){
            throw new BusinessException(BusinessMessage.ModelMessages.ModelIdNotFound+id);
        }
    }


}
