package com.kodlamaio.inventoryService.business.concretes;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.inventoryService.business.abstracts.BrandService;
import com.kodlamaio.inventoryService.business.constants.Messages;
import com.kodlamaio.inventoryService.business.requests.create.CreateBrandRequest;
import com.kodlamaio.inventoryService.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.inventoryService.business.responses.create.CreateBrandResponse;
import com.kodlamaio.inventoryService.business.responses.get.GetBrandsResponse;
import com.kodlamaio.inventoryService.business.responses.getAll.GetAllBrandsResponse;
import com.kodlamaio.inventoryService.business.responses.update.UpdateBrandResponse;
import com.kodlamaio.inventoryService.dataAccess.BrandRepository;
import com.kodlamaio.inventoryService.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = this.brandRepository.findAll() ;
        List<GetAllBrandsResponse> getAllBrandsResponses =
                brands.stream().map(brand -> this.modelMapperService.forResponse()
                        .map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
        return getAllBrandsResponses;
    }

    @Override
    public GetBrandsResponse getById(String id) {
        checkIfExistsByBrandId(id);
        Brand brand = this.brandRepository.findById(id).get();
        GetBrandsResponse getBrandsResponse = this.modelMapperService.forResponse().map(brand,GetBrandsResponse.class);
        return getBrandsResponse;
    }

    @Override
    public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        checkIfExistsByBrandId(updateBrandRequest.getId());
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
        UpdateBrandResponse updateBrandResponse =this.modelMapperService.forResponse().map(brand,UpdateBrandResponse.class);
        return updateBrandResponse;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {
        checkIfBrandExistsByName(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brand.setId(UUID.randomUUID().toString());

        this.brandRepository.save(brand);

        CreateBrandResponse createBrandResponse = this.modelMapperService.forResponse().map(brand,
                CreateBrandResponse.class);
        return createBrandResponse;
    }

    @Override
    public void delete(String id) {
        this.brandRepository.deleteById(id);

    }

    private void checkIfBrandExistsByName(String name) {
        Brand currentBrand = this.brandRepository.findByName(name);
        if (currentBrand != null) {
            throw new BusinessException("BRAND.EXISTS");
        }
    }

    private void checkIfExistsByBrandId(String id){
        if (!this.brandRepository.existsById(id))
        {
            throw new BusinessException(Messages.Brand.BrandIdNotFound+id);
        }


    }

}
