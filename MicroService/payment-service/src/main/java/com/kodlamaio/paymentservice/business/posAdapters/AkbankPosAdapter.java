package com.kodlamaio.paymentservice.business.posAdapters;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.paymentservice.business.outServices.AkbankPosService;
import org.springframework.stereotype.Service;

@Service
public class AkbankPosAdapter implements PosService {

    @Override
    public boolean payment(String cardNumber, String cardOwner, String cardCvv, String cardExpirationDate, double totalPrice)  {

        AkbankPosService akbankPosService = new AkbankPosService();

        if (!akbankPosService.makePayment(cardOwner, cardNumber, cardCvv, cardExpirationDate, totalPrice)) {
            throw new BusinessException("payment failed, Akbank");
        }
        return true;
    }
}
