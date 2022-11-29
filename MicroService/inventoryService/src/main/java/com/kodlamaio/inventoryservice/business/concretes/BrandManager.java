package com.kodlamaio.inventoryservice.business.concretes;

import com.kodlamaio.inventoryservice.business.abstracts.BrandService;
import com.kodlamaio.inventoryservice.business.requests.create.CreateBrandRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllBranResponse;
import com.kodlamaio.inventoryservice.dataAccess.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;

    @Override
    public List<GetAllBranResponse> getAll() {
        return null;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {
        return null;
    }
}
