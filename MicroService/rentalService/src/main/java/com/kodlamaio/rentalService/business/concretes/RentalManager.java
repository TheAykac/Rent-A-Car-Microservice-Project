package com.kodlamaio.rentalService.business.concretes;

import com.kodlamaio.common.events.InvoiceCreatedEvent;
import com.kodlamaio.common.events.RentalCreatedEvent;
import com.kodlamaio.common.events.RentalUpdateEvent;
import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.common.utilities.messages.BusinessMessage;
import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.common.utilities.result.SuccessDataResult;
import com.kodlamaio.common.utilities.result.SuccessResult;
import com.kodlamaio.rentalService.business.abstracts.RentalService;
import com.kodlamaio.rentalService.business.requests.create.CreateRentalRequest;
import com.kodlamaio.rentalService.business.requests.update.UpdateRentalRequest;
import com.kodlamaio.rentalService.business.responses.create.CreateRentalResponse;
import com.kodlamaio.rentalService.business.responses.get.GetRentalResponse;
import com.kodlamaio.rentalService.business.responses.getAll.GetAllRentalResponse;
import com.kodlamaio.rentalService.business.responses.update.UpdateRentalResponse;
import com.kodlamaio.rentalService.client.CarClientService;
import com.kodlamaio.rentalService.dataAccess.abstracts.RentalRepository;
import com.kodlamaio.rentalService.entities.Rental;
import com.kodlamaio.rentalService.kafka.InvoiceProducer;
import com.kodlamaio.rentalService.kafka.RentalProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
	
	private RentalRepository rentalRepository;
	private ModelMapperService modelMapperService;
	private RentalProducer rentalProducer;
	private CarClientService carClientService;
	private InvoiceProducer invoiceProducer;


	@Override
	public DataResult<CreateRentalResponse> add(CreateRentalRequest createRentalRequest) {
		carClientService.checkIfCarAvailable(createRentalRequest.getCarId());
		Rental rental = modelMapperService.forRequest().map(createRentalRequest,Rental.class);
		rental.setId(UUID.randomUUID().toString());
		rental.setTotalPrice(createRentalRequest.getDailyPrice()*createRentalRequest.getRentedForDays());
		Rental rentalCreated = rentalRepository.save(rental);
		RentalCreatedEvent rentalCreatedEvent = new RentalCreatedEvent();
		rentalCreatedEvent.setCarId(rentalCreated.getCarId());
		rentalCreatedEvent.setMessage("Rental Created");
		InvoiceCreatedEvent invoiceCreatedEvent = new InvoiceCreatedEvent();
		invoiceCreatedEvent.setRentalCarId(rentalCreated.getCarId());
		invoiceCreatedEvent.setStartDate(rentalCreated.getDateStarted());
		invoiceCreatedEvent.setRentalCarTotalPrice(rentalCreated.getTotalPrice());
		invoiceCreatedEvent.setPriceOfDays(rentalCreated.getDailyPrice());
		invoiceCreatedEvent.setTotalRentalDay(rentalCreated.getRentedForDays());
		invoiceCreatedEvent.setMessage("InvoiceCreated");

		this.invoiceProducer.sendMessage(invoiceCreatedEvent);
		this.rentalProducer.sendMessage(rentalCreatedEvent);

		CreateRentalResponse response = modelMapperService.forResponse().map(rental,CreateRentalResponse.class);
		return new SuccessDataResult<>(response, BusinessMessage.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
	}

	@Override
	public DataResult<UpdateRentalResponse> update(UpdateRentalRequest updateRentalRequest) {
		checkIfExistsById(updateRentalRequest.getId());
		Rental rental = this.rentalRepository.findById(updateRentalRequest.getId()).get();
		RentalUpdateEvent rentalUpdateEvent=new RentalUpdateEvent();
		rentalUpdateEvent.setOldCarId(rental.getCarId());
		Rental rentalSave = this.modelMapperService.forRequest().map(updateRentalRequest,Rental.class);
		Rental rentalUpdated=this.rentalRepository.save(rentalSave);
		rentalUpdateEvent.setNewCarId(rentalSave.getCarId());
		rentalUpdateEvent.setMessage("Rental Updated");
		UpdateRentalResponse updateRentalResponse = this.modelMapperService.forResponse().map(rental,UpdateRentalResponse.class);
		return new SuccessDataResult<>(updateRentalResponse,BusinessMessage.GlobalMessages.DATA_UPDATED_SUCCESSFULLY);
	}
	@Override
	public double getTotalPrice(String rentalId) {
		double totalPrice;
		Rental rental = this.rentalRepository.findById(rentalId).get();
		totalPrice= rental.getTotalPrice();
		return totalPrice;

	}


	@Override
	public void createForInvoice(String rentalId) {
		Rental rental = this.rentalRepository.findById(rentalId).get();
		InvoiceCreatedEvent invoiceCreatedEvent = new InvoiceCreatedEvent();
		invoiceCreatedEvent.setRentalCarId(rental.getId());
		invoiceCreatedEvent.setPriceOfDays(rental.getDailyPrice());
		invoiceCreatedEvent.setStartDate(rental.getDateStarted());
		invoiceCreatedEvent.setRentalCarTotalPrice(rental.getTotalPrice());


	}

	@Override
	public DataResult<List<GetAllRentalResponse>> getAll() {
		List<Rental> rentals = this.rentalRepository.findAll();
		List<GetAllRentalResponse> getAllRentalResponses=rentals.stream().map(rental -> this.modelMapperService.forResponse().map(rental, GetAllRentalResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(getAllRentalResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public DataResult<GetRentalResponse> getById(String id) {
		checkIfExistsById(id);
		Rental rental= this.rentalRepository.findById(id).get();
		GetRentalResponse getRentalResponse = this.modelMapperService.forResponse().map(rental,GetRentalResponse.class);
		return new SuccessDataResult<>(getRentalResponse,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public Result delete(String id) {
		Rental rental = this.rentalRepository.findById(id).get();
		this.rentalRepository.delete(rental);
		return new SuccessResult(BusinessMessage.GlobalMessages.DATA_DELETED_SUCCESSFULLY);
	}

	private void checkIfExistsById(String id){
		if (!this.rentalRepository.existsById(id)){
			throw new BusinessException(BusinessMessage.GlobalMessages.ID_NOT_FOUND+id);
		}
	}


}
