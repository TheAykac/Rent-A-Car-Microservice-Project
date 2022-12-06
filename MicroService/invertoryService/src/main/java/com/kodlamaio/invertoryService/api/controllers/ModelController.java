package com.kodlamaio.invertoryService.api.controllers;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.invertoryService.business.abstracts.ModelService;
import com.kodlamaio.invertoryService.business.requests.create.CreateModelRequest;
import com.kodlamaio.invertoryService.business.requests.delete.DeleteModelRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateModelRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateModelResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetModelResponse;
import com.kodlamaio.invertoryService.business.responses.getAll.GetAllModelsResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelController {

	private ModelService modelService;

	@GetMapping("/getall")
	public DataResult<List<GetAllModelsResponse>> getAll() {
		return modelService.getAll();
	}

	@PostMapping("/add")
	public DataResult<CreateModelResponse> add(@RequestBody @Valid CreateModelRequest createModelRequest) {
		return modelService.add(createModelRequest);
	}

	@PutMapping("/update")
	public DataResult<UpdateModelResponse> update(@RequestBody @Valid UpdateModelRequest updateModelRequest) {
		return modelService.update(updateModelRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(DeleteModelRequest deleteModelRequest) {
		return modelService.delete(deleteModelRequest);
	}


	@GetMapping("/getById/{id}")
	public DataResult<GetModelResponse> getById(@PathVariable String id) {
		return this.modelService.getById(id);
	}
}
