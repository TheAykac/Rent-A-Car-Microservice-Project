package com.kodlamaio.inventoryservice.business.abstracts;

import com.kodlamaio.inventoryservice.business.requests.create.CreateBrandRequest;
import com.kodlamaio.inventoryservice.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.delete.DeleteBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllBranResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetBranResponse;
import com.kodlamaio.inventoryservice.business.responses.update.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBranResponse> getAll();

    GetBranResponse getById(String id);

    CreateBrandResponse add(CreateBrandRequest createBrandRequest);

    UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest);

    DeleteBrandResponse delete(String id);
}
