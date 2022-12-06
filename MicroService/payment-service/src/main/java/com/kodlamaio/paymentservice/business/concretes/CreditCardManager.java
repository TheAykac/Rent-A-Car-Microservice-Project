package com.kodlamaio.paymentservice.business.concretes;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.common.utilities.messages.BusinessMessage;
import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.SuccessDataResult;
import com.kodlamaio.paymentservice.business.abstracts.CreditCardService;
import com.kodlamaio.paymentservice.business.requests.create.CreateCreditCardRequest;
import com.kodlamaio.paymentservice.business.responses.create.CreateCreditCardResponse;
import com.kodlamaio.paymentservice.business.responses.get.GetCreditCardResponse;
import com.kodlamaio.paymentservice.business.responses.getAll.GetAllCreditCardResponse;
import com.kodlamaio.paymentservice.dataAccess.CreditCardRepository;
import com.kodlamaio.paymentservice.entities.CreditCard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CreditCardManager implements CreditCardService {
    private CreditCardRepository creditCardRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<CreateCreditCardResponse> add(CreateCreditCardRequest createCreditCardRequest) {
        CreditCard creditCard = this.modelMapperService.forRequest().map(createCreditCardRequest,CreditCard.class);
        creditCard.setCreditCardId(UUID.randomUUID().toString());
        this.creditCardRepository.save(creditCard);
        CreateCreditCardResponse createCreditCardResponse = this.modelMapperService.forResponse().map(creditCard,CreateCreditCardResponse.class);
        return new SuccessDataResult<>(createCreditCardResponse, BusinessMessage.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
    }

    @Override
    public DataResult<List<GetAllCreditCardResponse>> getAll() {
        List<CreditCard> creditCards = this.creditCardRepository.findAll();
        List<GetAllCreditCardResponse> getAllCreditCardResponses = creditCards.stream().map(creditCard -> this.modelMapperService.forResponse().map(creditCard, GetAllCreditCardResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllCreditCardResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<GetCreditCardResponse> getById(String id) {
        checkIfExitsById(id);
        CreditCard creditCard = this.creditCardRepository.findById(id).get();
        GetCreditCardResponse getCreditCardResponse = this.modelMapperService.forResponse().map(creditCard, GetCreditCardResponse.class);
        return new SuccessDataResult<>(getCreditCardResponse,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);

    }

    public enum CardSaveInformation {
        SAVE, DONT_SAVE
    }
    private void checkIfExitsById(String id){
        if (!this.creditCardRepository.existsById(id)){
            throw new BusinessException(BusinessMessage.GlobalMessages.ID_NOT_FOUND+id);
        }
    }
}
