package com.kodlamaio.paymentservice.business.concretes;

import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.paymentservice.business.abstracts.CreditCardService;
import com.kodlamaio.paymentservice.business.requests.create.CreateCreditCardRequest;
import com.kodlamaio.paymentservice.business.responses.create.CreateCreditCardResponse;
import com.kodlamaio.paymentservice.dataAccess.CreditCardRepository;
import com.kodlamaio.paymentservice.entities.CreditCard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreditCardManager implements CreditCardService {

    private CreditCardRepository creditCardRepository;
    private ModelMapperService modelMapperService;


    @Override
    public CreateCreditCardResponse add(CreateCreditCardRequest createCreditCardRequest) {
        CreditCard creditCard = this.modelMapperService.forRequest().map(createCreditCardRequest,CreditCard.class);
        this.creditCardRepository.save(creditCard);
        CreateCreditCardResponse createCreditCardResponse = this.modelMapperService.forResponse().map(creditCard,CreateCreditCardResponse.class);
        return createCreditCardResponse;
    }
}
