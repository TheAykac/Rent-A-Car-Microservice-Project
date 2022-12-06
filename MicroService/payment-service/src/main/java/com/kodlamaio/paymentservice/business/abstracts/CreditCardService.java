package com.kodlamaio.paymentservice.business.abstracts;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.paymentservice.business.requests.create.CreateCreditCardRequest;
import com.kodlamaio.paymentservice.business.responses.create.CreateCreditCardResponse;
import com.kodlamaio.paymentservice.business.responses.get.GetCreditCardResponse;
import com.kodlamaio.paymentservice.business.responses.getAll.GetAllCreditCardResponse;

import java.util.List;

public interface CreditCardService {
      DataResult<CreateCreditCardResponse> add(CreateCreditCardRequest createCreditCardRequest);
      DataResult<List<GetAllCreditCardResponse>> getAll();
      DataResult<GetCreditCardResponse>getById(String id);
}
