package com.kodlamaio.paymentservice.business.posAdapters;

public interface PosService {

    boolean payment(String cardNumber, String cardOwner, String cardCvv, String cardExpirationDate, double totalPrice) ;

}
