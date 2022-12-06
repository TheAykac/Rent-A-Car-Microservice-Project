package com.kodlamaio.invertoryService.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.invertoryService.business.responses.get.GetBrandResponse;
import org.springframework.web.bind.annotation.*;

import com.kodlamaio.invertoryService.business.abstracts.BrandService;
import com.kodlamaio.invertoryService.business.requests.create.CreateBrandRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateBrandResponse;
import com.kodlamaio.invertoryService.business.responses.getAll.GetAllBrandResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateBrandResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController {

	private BrandService brandService;
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllBrandResponse>> getAll(){
		return brandService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<CreateBrandResponse> add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
		return brandService.add(createBrandRequest);
	}
	
	@PutMapping("/update")
	public DataResult<UpdateBrandResponse> update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) {
		return brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable String id) {
		return brandService.delete( id);
	}

	@GetMapping("/getById/{id}")
	public DataResult<GetBrandResponse> getById(@PathVariable String id){
		return this.brandService.getById(id);
	}

	@GetMapping("/getByName")
	public DataResult<List<GetBrandResponse>> getByName(String name){
		return this.brandService.getByName(name);
	}
	
}
