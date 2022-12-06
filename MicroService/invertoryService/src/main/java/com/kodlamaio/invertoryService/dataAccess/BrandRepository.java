package com.kodlamaio.invertoryService.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.invertoryService.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, String> {

	List<Brand> getByName(String name);
	boolean existsByName(String name);
}
