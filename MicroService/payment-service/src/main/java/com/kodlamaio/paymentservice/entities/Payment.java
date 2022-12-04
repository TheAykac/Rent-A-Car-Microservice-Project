package com.kodlamaio.paymentservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "totalPrice")
    private String totalPrice;

    @Column(name = "rentalId")
    private String rentalId;
}
