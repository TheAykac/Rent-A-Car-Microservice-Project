package com.kodlamaio.inventoryService.business.abstracts;

import com.kodlamaio.inventoryService.business.requests.create.CreateBrandRequest;
import com.kodlamaio.inventoryService.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.inventoryService.business.responses.create.CreateBrandResponse;
import com.kodlamaio.inventoryService.business.responses.get.GetBrandsResponse;
import com.kodlamaio.inventoryService.business.responses.getAll.GetAllBrandsResponse;
import com.kodlamaio.inventoryService.business.responses.update.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetBrandsResponse getById(String id);

    UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest);

    CreateBrandResponse add(CreateBrandRequest createBrandRequest);

    void delete (String id);


}
