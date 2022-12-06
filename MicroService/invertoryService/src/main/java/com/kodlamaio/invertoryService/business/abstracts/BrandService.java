package com.kodlamaio.invertoryService.business.abstracts;

import java.util.List;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.invertoryService.business.requests.create.CreateBrandRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateBrandResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetBrandResponse;
import com.kodlamaio.invertoryService.business.responses.getAll.GetAllBrandResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateBrandResponse;

public interface BrandService {

	DataResult<List<GetAllBrandResponse>> getAll();
	DataResult<List<GetBrandResponse>> getByName(String name);
	DataResult<CreateBrandResponse> add(CreateBrandRequest createBrandRequest);
	DataResult<UpdateBrandResponse> update(UpdateBrandRequest updateBrandRequest);
	Result delete(String id);

	DataResult<GetBrandResponse> getById(String id);
}
