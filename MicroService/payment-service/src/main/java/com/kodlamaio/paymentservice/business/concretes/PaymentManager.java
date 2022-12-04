package com.kodlamaio.paymentservice.business.concretes;

import com.kodlamaio.common.events.PaymentCreatedEvent;
import com.kodlamaio.common.events.RentalCreatedEvent;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.paymentservice.business.abstracts.PaymentService;
import com.kodlamaio.paymentservice.business.requests.create.CreatePaymentRequest;
import com.kodlamaio.paymentservice.business.responses.create.CreatePaymentResponse;
import com.kodlamaio.paymentservice.dataAccess.PaymentRepository;
import com.kodlamaio.paymentservice.entities.Payment;
import com.kodlamaio.paymentservice.kafka.PaymentProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {

    private PaymentRepository paymentRepository;
    private ModelMapperService modelMapperService;
    private PaymentProducer paymentProducer;


    @Override
    public CreatePaymentResponse add(CreatePaymentRequest createPaymentRequest) {
        Payment payment = this.modelMapperService.forRequest().map(createPaymentRequest,Payment.class);
        payment.setId(UUID.randomUUID().toString());

        Payment paymentCreated= paymentRepository.save(payment);





        CreatePaymentResponse createPaymentResponse= this.modelMapperService.forResponse().map(payment,CreatePaymentResponse.class);
        return createPaymentResponse;
    }
}
