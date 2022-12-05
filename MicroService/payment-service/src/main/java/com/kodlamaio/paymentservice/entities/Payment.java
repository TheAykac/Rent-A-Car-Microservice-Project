package com.kodlamaio.paymentservice.entities;

import com.kodlamaio.paymentservice.business.concretes.CreditCardManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @Column(name = "payment_id")
    private String id;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "rental_id")
    private String rentalId;


}
