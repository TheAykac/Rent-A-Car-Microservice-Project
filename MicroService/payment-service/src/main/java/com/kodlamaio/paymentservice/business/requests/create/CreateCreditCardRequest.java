package com.kodlamaio.paymentservice.business.requests.create;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditCardRequest {


    @NotNull
    @NotBlank
    @Pattern(regexp = "^[0-9]{16}")
    private String cardNumber;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[abcçdefgğhıijklmnoöprsştuüvwqyzABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVWQYZ ]{5,50}")
    private String cardOwner;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[0-9]{3}")
    private String cardCvv;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 5)
    private String cardExpirationDate;


}
