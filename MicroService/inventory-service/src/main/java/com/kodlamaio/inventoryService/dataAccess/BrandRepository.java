package com.kodlamaio.inventoryService.dataAccess;

import com.kodlamaio.inventoryService.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, String> {
    Brand findByName(String name);

}
