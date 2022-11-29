package com.kodlamaio.inventoryservice.api.controllers;

import com.kodlamaio.inventoryservice.business.abstracts.ModelService;
import com.kodlamaio.inventoryservice.business.requests.create.CreateModelRequest;
import com.kodlamaio.inventoryservice.business.requests.update.UpdateModelRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateModelResponse;
import com.kodlamaio.inventoryservice.business.responses.delete.DeleteModelResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllModelResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetModelResponse;
import com.kodlamaio.inventoryservice.business.responses.update.UpdateModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/model")
@AllArgsConstructor
public class ModelController {

    private ModelService modelService;


    @GetMapping
    public List<GetAllModelResponse> getAll(){
        return this.modelService.getAll();
    }

    @PostMapping
    public CreateModelResponse add(@RequestBody @Valid CreateModelRequest createModelRequest){
        return this.modelService.add(createModelRequest);
    }

    @GetMapping("/{id}")
    public GetModelResponse getById(@PathVariable String id){
        return this.modelService.getById(id);
    }
    @DeleteMapping("/{id}")
    public DeleteModelResponse delete(@PathVariable String id){
        return this.modelService.delete(id);
    }
    @PutMapping
    public UpdateModelResponse update (@RequestBody @Valid UpdateModelRequest updateModelRequest){
        return this.modelService.update(updateModelRequest);
    }
}
