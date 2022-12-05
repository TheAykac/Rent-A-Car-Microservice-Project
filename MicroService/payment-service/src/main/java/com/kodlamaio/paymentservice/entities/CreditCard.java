package com.kodlamaio.paymentservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "credit_cards")
public class CreditCard {

    @Id

    @Column(name = "credit_card_id")
    private String creditCardId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_owner")
    private String cardOwner;

    @Column(name = "card_cvv")
    private String cardCvv;

    @Column(name = "card_expiration_date")
    private String cardExpirationDate;




}