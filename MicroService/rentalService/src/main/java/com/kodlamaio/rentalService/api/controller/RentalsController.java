package com.kodlamaio.rentalService.api.controller;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.rentalService.business.abstracts.RentalService;
import com.kodlamaio.rentalService.business.requests.create.CreateRentalRequest;
import com.kodlamaio.rentalService.business.requests.update.UpdateRentalRequest;
import com.kodlamaio.rentalService.business.responses.create.CreateRentalResponse;
import com.kodlamaio.rentalService.business.responses.get.GetRentalResponse;
import com.kodlamaio.rentalService.business.responses.getAll.GetAllRentalResponse;
import com.kodlamaio.rentalService.business.responses.update.UpdateRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalsController {

	private RentalService rentalService;

	@PostMapping("/add")
	public DataResult<CreateRentalResponse> add(@RequestBody CreateRentalRequest createRentalRequest) {
		return rentalService.add(createRentalRequest);
	}

	@PutMapping("/update")
	public DataResult<UpdateRentalResponse> update(@RequestBody UpdateRentalRequest updateRentalRequest) {
		return this.rentalService.update(updateRentalRequest);
	}


	@GetMapping("/getTotalPrice/{rentalId}")
	public double getTotalPrice(@PathVariable String rentalId) {
		return rentalService.getTotalPrice(rentalId);
	}

	@GetMapping("/getAll")
	public DataResult<List<GetAllRentalResponse>> getAll() {
		return this.rentalService.getAll();
	}

	@GetMapping("/getById/{id}")
	public DataResult<GetRentalResponse> getById(@PathVariable String id) {
		return this.rentalService.getById(id);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable String id){
		return this.rentalService.delete(id);
	}
}
