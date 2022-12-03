package com.kodlamaio.invertoryService.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.invertoryService.entities.Car;

public interface CarRespository extends JpaRepository<Car,String>{

}
