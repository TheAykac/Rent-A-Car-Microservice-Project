package com.kodlamaio.inventoryservice.business.abstracts;

import com.kodlamaio.inventoryservice.business.requests.create.CreateBrandRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllBranResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBranResponse> getAll();

    CreateBrandResponse add(CreateBrandRequest createBrandRequest);
}
