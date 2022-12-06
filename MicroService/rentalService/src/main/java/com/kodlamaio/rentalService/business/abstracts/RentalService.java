package com.kodlamaio.rentalService.business.abstracts;

import com.kodlamaio.common.events.InvoiceCreatedEvent;
import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.rentalService.business.requests.update.UpdateRentalRequest;
import com.kodlamaio.rentalService.business.responses.create.CreateRentalResponse;
import com.kodlamaio.rentalService.business.requests.create.CreateRentalRequest;
import com.kodlamaio.rentalService.business.responses.get.GetRentalResponse;
import com.kodlamaio.rentalService.business.responses.getAll.GetAllRentalResponse;
import com.kodlamaio.rentalService.business.responses.update.UpdateRentalResponse;

import java.util.List;

public interface RentalService {

	DataResult<CreateRentalResponse> add(CreateRentalRequest createRentalRequest);
	DataResult<UpdateRentalResponse> update (UpdateRentalRequest updateRentalRequest);
	double getTotalPrice(String rentalId);

	void createForInvoice(String rentalId);

	DataResult<List<GetAllRentalResponse>> getAll();
	DataResult<GetRentalResponse> getById(String id);
	Result delete (String id);
}
