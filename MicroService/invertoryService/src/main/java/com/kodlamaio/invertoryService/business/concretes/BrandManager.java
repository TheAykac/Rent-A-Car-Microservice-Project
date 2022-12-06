package com.kodlamaio.invertoryService.business.concretes;

import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.invertoryService.business.abstracts.BrandService;
import com.kodlamaio.invertoryService.business.requests.create.CreateBrandRequest;
import com.kodlamaio.invertoryService.business.requests.delete.DeleteBrandRequest;
import com.kodlamaio.invertoryService.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.invertoryService.business.responses.create.CreateBrandResponse;
import com.kodlamaio.invertoryService.business.responses.get.GetAllBrandsResponse;
import com.kodlamaio.invertoryService.business.responses.update.UpdateBrandResponse;
import com.kodlamaio.invertoryService.dataAccess.BrandRepository;
import com.kodlamaio.invertoryService.entities.Brand;
import com.kodlamaio.invertoryService.kafka.FilterProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    private FilterProducer filterProducer;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> responses = brands.stream()
                .map(brand -> modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).toList();
        return responses;
    }

    @Override
	public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {
	
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		brand.setId(UUID.randomUUID().toString());
		brandRepository.save(brand);
		CreateBrandResponse createBrandResponse = modelMapperService.forResponse().map(brand, CreateBrandResponse.class);
		return createBrandResponse;
	}

	@Override
	public List<GetAllBrandsResponse> getByName(String name) {
		List<Brand> brands = brandRepository.getByName(name);
		List<GetAllBrandsResponse> responses = brands.stream()
				.map(brand->modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class)).toList();
		return responses;
	}

	@Override
	public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		brandRepository.save(brand);
		
		UpdateBrandResponse response = modelMapperService.forResponse().map(brand, UpdateBrandResponse.class);
		return response;
	}

	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);
		brandRepository.delete(brand);
	}

}
