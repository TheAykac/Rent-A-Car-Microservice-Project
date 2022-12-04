package com.kodlamaio.rentalService.business.concretes;

import com.kodlamaio.common.events.RentalCreatedEvent;
import com.kodlamaio.common.events.RentalUpdateEvent;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentalService.business.abstracts.RentalService;
import com.kodlamaio.rentalService.business.requests.create.CreateRentalRequest;
import com.kodlamaio.rentalService.business.requests.update.UpdateRentalRequest;
import com.kodlamaio.rentalService.business.responses.create.CreateRentalResponse;
import com.kodlamaio.rentalService.business.responses.update.UpdateRentalResponse;
import com.kodlamaio.rentalService.client.CarClientService;
import com.kodlamaio.rentalService.dataAccess.abstracts.RentalRepository;
import com.kodlamaio.rentalService.entities.Rental;
import com.kodlamaio.rentalService.kafka.RentalProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
		rental.setTotalPrice(createRentalRequest.getDailyPrice()*createRentalRequest.getRentedForDays());
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
		Rental rental = this.rentalRepository.findById(updateRentalRequest.getId()).get();


		RentalUpdateEvent rentalUpdateEvent=new RentalUpdateEvent();
		rentalUpdateEvent.setOldCarId(rental.getCarId());


		Rental rentalSave = this.modelMapperService.forRequest().map(updateRentalRequest,Rental.class);
		Rental rentalUpdated=this.rentalRepository.save(rentalSave);



		rentalUpdateEvent.setNewCarId(rentalSave.getCarId());
		rentalUpdateEvent.setMessage("Rental Updated");

		UpdateRentalResponse updateRentalResponse = this.modelMapperService.forResponse().map(rental,UpdateRentalResponse.class);
		return updateRentalResponse;
	}
	@Override
	public double getTotalPrice(String id) {
		return rentalRepository.findById(id).get().getTotalPrice();
	}
	@Override
	public void setConditionByPayment(String id) {
		Rental rental = this.rentalRepository.findById(id).get();
		if (rental.getCondition()==1) {
			rental.setCondition(2);
		}
		rentalRepository.save(rental);

	}

	@Override
	public void calculateTotalPrice(double dailyPrice, int rentedForDays) {
		double totalPrice=dailyPrice*rentedForDays;
	}
}
