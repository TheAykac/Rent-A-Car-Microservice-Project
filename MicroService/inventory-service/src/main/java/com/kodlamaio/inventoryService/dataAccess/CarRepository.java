package com.kodlamaio.inventoryService.dataAccess;

import com.kodlamaio.inventoryService.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {

}
