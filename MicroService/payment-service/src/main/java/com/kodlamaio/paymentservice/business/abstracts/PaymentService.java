package com.kodlamaio.paymentservice.business.abstracts;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.paymentservice.api.controllers.models.MakePayment;
import com.kodlamaio.paymentservice.business.concretes.CreditCardManager;
import com.kodlamaio.paymentservice.business.requests.create.CreatePaymentRequest;
import com.kodlamaio.paymentservice.business.responses.create.CreatePaymentResponse;
import com.kodlamaio.paymentservice.business.responses.get.GetPaymentResponse;
import com.kodlamaio.paymentservice.business.responses.getAll.GetAllPaymentResponse;

import javax.xml.crypto.Data;
import java.util.List;

public interface PaymentService {

    DataResult<CreatePaymentResponse> makePayment(MakePayment makePayment) ;
    DataResult<List<GetAllPaymentResponse>> getAll();
    DataResult<GetPaymentResponse> getById(String id);

    Result delete(String id);


}
