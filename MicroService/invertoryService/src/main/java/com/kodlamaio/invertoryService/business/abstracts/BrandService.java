package com.kodlamaio.invertoryService.business.abstracts;

import java.util.List;

import com.kodlamaio.invertoryService.business.requests.create.CreateBrandRequest;
import com.kodlamaio.invertoryService.business.requests.delete.DeleteBrandRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateBrandResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetAllBrandsResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateBrandResponse;

public interface BrandService {

	List<GetAllBrandsResponse> getAll();
	List<GetAllBrandsResponse> getByName(String name);
	CreateBrandResponse add(CreateBrandRequest createBrandRequest);
	UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest);
	void delete(DeleteBrandRequest deleteBrandRequest);
}
