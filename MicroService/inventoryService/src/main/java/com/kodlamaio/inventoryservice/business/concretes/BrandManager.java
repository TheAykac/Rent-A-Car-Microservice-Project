package com.kodlamaio.inventoryservice.business.concretes;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.inventoryservice.business.abstracts.BrandService;
import com.kodlamaio.inventoryservice.business.contants.BusinessMessage;
import com.kodlamaio.inventoryservice.business.requests.create.CreateBrandRequest;
import com.kodlamaio.inventoryservice.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.delete.DeleteBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllBranResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetBranResponse;
import com.kodlamaio.inventoryservice.business.responses.update.UpdateBrandResponse;
import com.kodlamaio.inventoryservice.dataAccess.BrandRepository;
import com.kodlamaio.inventoryservice.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBranResponse> getAll() {
        List<Brand> brands = this.brandRepository.findAll();
        List<GetAllBranResponse> getAllBranResponses = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBranResponse.class)).collect(Collectors.toList());
        return getAllBranResponses;
    }

    @Override
    public GetBranResponse getById(String id) {
        checkIfExistsByBrandId(id);
        Brand brand = this.brandRepository.findById(id).get();
        GetBranResponse getBranResponse = this.modelMapperService.forResponse().map(brand, GetBranResponse.class);
        return getBranResponse;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brand.setId(UUID.randomUUID().toString());
        this.brandRepository.save(brand);
        CreateBrandResponse createBrandResponse = this.modelMapperService.forResponse().map(brand, CreateBrandResponse.class);
        return createBrandResponse;

    }

    @Override
    public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);

        UpdateBrandResponse updateBrandResponse = this.modelMapperService.forResponse().map(brand, UpdateBrandResponse.class);
        checkIfExistsByBrandId(updateBrandRequest.getId());
        return updateBrandResponse;
    }

    @Override
    public DeleteBrandResponse delete(String id) {
        checkIfExistsByBrandId(id);
        Brand brand = this.brandRepository.findById(id).get();
        this.brandRepository.delete(brand);
        DeleteBrandResponse deleteBrandResponse = this.modelMapperService.forResponse().map(brand, DeleteBrandResponse.class);
        return deleteBrandResponse;
    }

    private void checkIfExistsByBrandId(String id) {
        if (!this.brandRepository.existsById(id)) {
            throw new BusinessException(BusinessMessage.BrandMessages.BrandIdNotFound + id);
        }
    }
}
