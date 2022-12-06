package com.kodlamaio.paymentservice.business.concretes;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.common.utilities.messages.BusinessMessage;
import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.common.utilities.result.SuccessDataResult;
import com.kodlamaio.common.utilities.result.SuccessResult;
import com.kodlamaio.paymentservice.api.controllers.models.MakePayment;
import com.kodlamaio.paymentservice.business.abstracts.CreditCardService;
import com.kodlamaio.paymentservice.business.abstracts.PaymentService;
import com.kodlamaio.paymentservice.business.posAdapters.PosService;
import com.kodlamaio.paymentservice.business.responses.create.CreatePaymentResponse;
import com.kodlamaio.paymentservice.business.responses.get.GetPaymentResponse;
import com.kodlamaio.paymentservice.business.responses.getAll.GetAllPaymentResponse;
import com.kodlamaio.paymentservice.client.PaymentClientService;
import com.kodlamaio.paymentservice.dataAccess.PaymentRepository;
import com.kodlamaio.paymentservice.entities.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {

    private PaymentRepository paymentRepository;
    private ModelMapperService modelMapperService;

    private CreditCardService creditCardService;
    private PaymentClientService paymentClientService;

    private PosService posService;


    @Override
    public DataResult<CreatePaymentResponse> makePayment(MakePayment makePayment) {
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

        if (makePayment.getCardSaveInformation().equals(CreditCardManager.CardSaveInformation.SAVE)){
            creditCardService.add(makePayment.getCreateCreditCardRequest());
        }
        this.paymentRepository.save(payment);
        CreatePaymentResponse createPaymentResponse = this.modelMapperService.forResponse().map(payment, CreatePaymentResponse.class);
        return new SuccessDataResult<>(createPaymentResponse, "Success Payment");

    }

    private void checkIfExistsByRentalId(String rentalId)  {
        if (this.paymentRepository.existsByRentalId(rentalId)) {
            throw new BusinessException("PAYMEYNT_ALREADY_DONE");
        }
    }

    @Override
    public DataResult<List<GetAllPaymentResponse>> getAll() {
        List<Payment> payments= this.paymentRepository.findAll();
        List<GetAllPaymentResponse> getAllPaymentResponses = payments.stream().map(payment -> this.modelMapperService.forResponse().map(payment, GetAllPaymentResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllPaymentResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<GetPaymentResponse> getById(String id) {
        checkIfExistsById(id);
        Payment payment = this.paymentRepository.findById(id).get();
        GetPaymentResponse getPaymentResponse=this.modelMapperService.forResponse().map(payment,GetPaymentResponse.class);
        return new SuccessDataResult<>(getPaymentResponse,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);

    }

    @Override
    public Result delete(String id) {
        checkIfExistsById(id);
        Payment payment = this.paymentRepository.findById(id).get();
        this.paymentRepository.delete(payment);
        return new SuccessResult(BusinessMessage.GlobalMessages.DATA_DELETED_SUCCESSFULLY);
    }
    private void checkIfExistsById(String id){
        if (!this.paymentRepository.existsById(id)){
            throw new BusinessException(BusinessMessage.GlobalMessages.ID_NOT_FOUND+id);
        }
    }

}
