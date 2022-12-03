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

import com.kodlamaio.invertoryService.business.abstracts.BrandService;
import com.kodlamaio.invertoryService.business.requests.create.CreateBrandRequest;
import com.kodlamaio.invertoryService.business.requests.delete.DeleteBrandRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateBrandResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetAllBrandsResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateBrandResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController {

	private BrandService brandService;
	
	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	@PostMapping("add")
	public CreateBrandResponse add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
		return brandService.add(createBrandRequest);
	}
	
	@PutMapping("update")
	public UpdateBrandResponse update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) {
		return brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("delete")
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		brandService.delete(deleteBrandRequest);
	}
	
	
}
