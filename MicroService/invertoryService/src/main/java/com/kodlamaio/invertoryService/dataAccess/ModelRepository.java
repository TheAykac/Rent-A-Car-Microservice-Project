package com.kodlamaio.invertoryService.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.invertoryService.entities.Model;

public interface ModelRepository extends JpaRepository<Model,String> {

}
