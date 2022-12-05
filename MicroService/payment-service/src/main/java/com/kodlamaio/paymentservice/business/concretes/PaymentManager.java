package com.kodlamaio.paymentservice.business.concretes;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.paymentservice.api.controllers.models.MakePayment;
import com.kodlamaio.paymentservice.business.abstracts.CreditCardService;
import com.kodlamaio.paymentservice.business.abstracts.PaymentService;
import com.kodlamaio.paymentservice.business.posAdapters.PosService;
import com.kodlamaio.paymentservice.business.responses.create.CreatePaymentResponse;
import com.kodlamaio.paymentservice.client.PaymentClientService;
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
    private CreditCardService creditCardService;
    private PaymentClientService paymentClientService;

    private PosService posService;


    @Override
    public CreatePaymentResponse makePayment(MakePayment makePayment) {
        double totalPrice = paymentClientService.getTotalPrice(makePayment.getRentalId());
        checkIfExistsByRentalId(makePayment.getRentalId());
        this.posService.payment(makePayment.getCreateCreditCardRequest().getCardNumber(),
                makePayment.getCreateCreditCardRequest().getCardOwner(),
                makePayment.getCreateCreditCardRequest().getCardCvv(),
                makePayment.getCreateCreditCardRequest().getCardExpirationDate(),
                totalPrice);
        Payment payment =new Payment();
        payment.setRentalId(makePayment.getRentalId());
        payment.setTotalPrice(totalPrice);
        payment.setId(UUID.randomUUID().toString());
        this.paymentRepository.save(payment);
        if (makePayment.getCardSaveInformation().equals(CreditCardManager.CardSaveInformation.SAVE)){
            creditCardService.add(makePayment.getCreateCreditCardRequest());
        }
        CreatePaymentResponse createPaymentResponse = this.modelMapperService.forResponse().map(payment, CreatePaymentResponse.class);
        return createPaymentResponse;

    }

    private void checkIfExistsByRentalId(String rentalId)  {
        if (this.paymentRepository.existsByRentalId(rentalId)) {
            throw new BusinessException("PAYMEYNT_ALREADY_DONE");
        }
    }


}
