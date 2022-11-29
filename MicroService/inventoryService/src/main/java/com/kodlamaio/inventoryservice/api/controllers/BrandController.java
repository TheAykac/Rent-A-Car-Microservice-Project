package com.kodlamaio.inventoryservice.api.controllers;

import com.kodlamaio.inventoryservice.business.abstracts.BrandService;
import com.kodlamaio.inventoryservice.business.requests.create.CreateBrandRequest;
import com.kodlamaio.inventoryservice.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.inventoryservice.business.responses.create.CreateBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.delete.DeleteBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetAllBranResponse;
import com.kodlamaio.inventoryservice.business.responses.get.GetBranResponse;
import com.kodlamaio.inventoryservice.business.responses.update.UpdateBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/brand")
@AllArgsConstructor
public class BrandController {
    private BrandService brandService;

    @GetMapping
    public List<GetAllBranResponse> getAll() {
        return this.brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetBranResponse getById(@PathVariable String id) {
        return this.brandService.getById(id);
    }

    @PostMapping("/add")
    public CreateBrandResponse add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
        return this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public UpdateBrandResponse update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) {
        return this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public DeleteBrandResponse delete(@PathVariable String id) {
        return this.brandService.delete(id);
    }
}
