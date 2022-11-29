package com.kodlamaio.inventoryservice.dataAccess;

import com.kodlamaio.inventoryservice.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, String> {
}
