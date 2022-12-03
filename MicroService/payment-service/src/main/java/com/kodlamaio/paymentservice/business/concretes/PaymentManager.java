package com.kodlamaio.paymentservice.business.concretes;

import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.paymentservice.business.abstracts.PaymentService;
import com.kodlamaio.paymentservice.business.requests.create.CreatePaymentRequest;
import com.kodlamaio.paymentservice.business.responses.create.CreatePaymentResponse;
import com.kodlamaio.paymentservice.dataAccess.PaymentRepository;
import com.kodlamaio.paymentservice.entities.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {

    private PaymentRepository paymentRepository;
    private ModelMapperService modelMapperService;


    @Override
    public CreatePaymentResponse add(CreatePaymentRequest createPaymentRequest) {
        Payment payment = this.modelMapperService.forRequest().map(createPaymentRequest,Payment.class);
        this.paymentRepository.save(payment);

        CreatePaymentResponse createPaymentResponse= this.modelMapperService.forResponse().map(payment,CreatePaymentResponse.class);
        return createPaymentResponse;
    }
}
