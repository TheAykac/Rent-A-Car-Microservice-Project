package com.kodlamaio.rentalService.api.controller;

import com.kodlamaio.rentalService.business.requests.update.UpdateRentalRequest;
import com.kodlamaio.rentalService.business.responses.create.CreateRentalResponse;
import com.kodlamaio.rentalService.business.responses.update.UpdateRentalResponse;
import org.springframework.web.bind.annotation.*;

import com.kodlamaio.rentalService.business.abstracts.RentalService;
import com.kodlamaio.rentalService.business.requests.create.CreateRentalRequest;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalsController {

	private RentalService rentalService;

	@PostMapping("/add")
	public CreateRentalResponse add(@RequestBody CreateRentalRequest createRentalRequest) {
		return rentalService.add(createRentalRequest);
	}
	@PutMapping("/update")
	public UpdateRentalResponse update(@RequestBody UpdateRentalRequest updateRentalRequest){
		return this.rentalService.update(updateRentalRequest);
	}
}
