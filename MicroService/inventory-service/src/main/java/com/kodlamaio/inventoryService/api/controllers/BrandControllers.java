package com.kodlamaio.inventoryService.api.controllers;

import com.kodlamaio.inventoryService.business.abstracts.BrandService;
import com.kodlamaio.inventoryService.business.requests.create.CreateBrandRequest;
import com.kodlamaio.inventoryService.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.inventoryService.business.responses.create.CreateBrandResponse;
import com.kodlamaio.inventoryService.business.responses.get.GetBrandsResponse;
import com.kodlamaio.inventoryService.business.responses.getAll.GetAllBrandsResponse;
import com.kodlamaio.inventoryService.business.responses.update.UpdateBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
@AllArgsConstructor
public class BrandControllers {
    private BrandService brandService;


    @GetMapping("/getAll")
    public List<GetAllBrandsResponse> getAll(){
        return this.brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandsResponse getById(@PathVariable String id){
        return this.brandService.getById(id);
    }
    @PutMapping("/update")
    public UpdateBrandResponse add(@RequestBody @Valid UpdateBrandRequest updateBrandRequest){
        return this.brandService.update(updateBrandRequest);
    }
    @PostMapping("/add")
    public CreateBrandResponse add(@RequestBody @Valid CreateBrandRequest createBrandRequest){
        return this.brandService.add(createBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable String id){
    this.brandService.delete(id);
    }

}
