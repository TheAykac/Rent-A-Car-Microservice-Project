package com.kodlamaio.inventoryService.dataAccess;

import com.kodlamaio.inventoryService.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, String> {

}