package com.kodlamaio.invertoryService.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.invertoryService.business.abstracts.ModelService;
import com.kodlamaio.invertoryService.business.requests.create.CreateModelRequest;
import com.kodlamaio.invertoryService.business.requests.delete.DeleteModelRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateModelRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateModelResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetAllModelsResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateModelResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelController {

	private ModelService modelService;
	
	@GetMapping("getall")
	public List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
	}
	
	@PostMapping("add")
	public CreateModelResponse add(@RequestBody @Valid CreateModelRequest createModelRequest) {
		return modelService.add(createModelRequest);
	}
	
	@PutMapping("update")
	public UpdateModelResponse update(@RequestBody @Valid UpdateModelRequest updateModelRequest) {
		return modelService.update(updateModelRequest);
	}
	
	@DeleteMapping("delete")
	public void delete(DeleteModelRequest deleteModelRequest) {
		modelService.delete(deleteModelRequest);
	}
}
