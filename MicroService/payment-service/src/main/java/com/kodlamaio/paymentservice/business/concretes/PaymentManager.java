package com.kodlamaio.paymentservice.business.concretes;

<<<<<<< HEAD
import com.kodlamaio.common.events.PaymentCreatedEvent;
import com.kodlamaio.common.events.RentalCreatedEvent;
=======
>>>>>>> e4bd1ba4ef4add7550e75eb3942277d857dffebe
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.paymentservice.business.abstracts.PaymentService;
import com.kodlamaio.paymentservice.business.requests.create.CreatePaymentRequest;
import com.kodlamaio.paymentservice.business.responses.create.CreatePaymentResponse;
import com.kodlamaio.paymentservice.dataAccess.PaymentRepository;
import com.kodlamaio.paymentservice.entities.Payment;
<<<<<<< HEAD
import com.kodlamaio.paymentservice.kafka.PaymentProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

=======
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

>>>>>>> e4bd1ba4ef4add7550e75eb3942277d857dffebe
@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {

    private PaymentRepository paymentRepository;
    private ModelMapperService modelMapperService;
<<<<<<< HEAD
    private PaymentProducer paymentProducer;
=======
>>>>>>> e4bd1ba4ef4add7550e75eb3942277d857dffebe


    @Override
    public CreatePaymentResponse add(CreatePaymentRequest createPaymentRequest) {
        Payment payment = this.modelMapperService.forRequest().map(createPaymentRequest,Payment.class);
<<<<<<< HEAD
        payment.setId(UUID.randomUUID().toString());

        Payment paymentCreated= paymentRepository.save(payment);




=======
        this.paymentRepository.save(payment);
>>>>>>> e4bd1ba4ef4add7550e75eb3942277d857dffebe

        CreatePaymentResponse createPaymentResponse= this.modelMapperService.forResponse().map(payment,CreatePaymentResponse.class);
        return createPaymentResponse;
    }
}
