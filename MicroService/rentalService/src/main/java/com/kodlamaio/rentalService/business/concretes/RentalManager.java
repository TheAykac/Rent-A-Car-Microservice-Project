package com.kodlamaio.rentalService.business.concretes;

import java.util.UUID;

import com.kodlamaio.common.events.RentalUpdateEvent;
import com.kodlamaio.invertoryService.entities.Car;
import com.kodlamaio.rentalService.business.abstracts.RentalService;
import com.kodlamaio.rentalService.business.requests.update.UpdateRentalRequest;
import com.kodlamaio.rentalService.business.responses.create.CreateRentalResponse;
import com.kodlamaio.rentalService.business.responses.update.UpdateRentalResponse;
import com.kodlamaio.rentalService.dataAccess.abstracts.RentalRepository;
import com.kodlamaio.rentalService.entities.Rental;
import com.kodlamaio.rentalService.kafka.RentalProducer;
import com.kodlamaio.rentalService.client.CarClientService;
import org.springframework.stereotype.Service;

import com.kodlamaio.common.events.RentalCreatedEvent;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentalService.business.requests.create.CreateRentalRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
	
	private RentalRepository rentalRepository;
	private ModelMapperService modelMapperService;
	private RentalProducer rentalProducer;
	private CarClientService carClientService;

	@Override
	public CreateRentalResponse add(CreateRentalRequest createRentalRequest) {
		carClientService.checkIfCarAvailable(createRentalRequest.getCarId());
		Rental rental = modelMapperService.forRequest().map(createRentalRequest,Rental.class);
		rental.setId(UUID.randomUUID().toString());

		Rental rentalCreated = rentalRepository.save(rental);
		RentalCreatedEvent rentalCreatedEvent = new RentalCreatedEvent();
		rentalCreatedEvent.setCarId(rentalCreated.getCarId());
		rentalCreatedEvent.setMessage("Rental Created");

		this.rentalProducer.sendMessage(rentalCreatedEvent);
		CreateRentalResponse response = modelMapperService.forResponse().map(rental,CreateRentalResponse.class);
		return response;
	}

	@Override
	public UpdateRentalResponse update(UpdateRentalRequest updateRentalRequest) {
		Rental rental = this.modelMapperService.forRequest().map(updateRentalRequest,Rental.class);

		UpdateRentalResponse updateRentalResponse = this.modelMapperService.forResponse().map(rental,UpdateRentalResponse.class);
		return updateRentalResponse;
	}
}
