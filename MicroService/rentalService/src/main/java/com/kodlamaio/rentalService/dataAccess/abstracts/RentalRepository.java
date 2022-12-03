package com.kodlamaio.rentalService.dataAccess.abstracts;

import com.kodlamaio.rentalService.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,String>{

}
