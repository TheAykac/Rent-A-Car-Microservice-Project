package com.kodlamaio.inventoryservice.dataAccess;

import com.kodlamaio.inventoryservice.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,String> {
}
