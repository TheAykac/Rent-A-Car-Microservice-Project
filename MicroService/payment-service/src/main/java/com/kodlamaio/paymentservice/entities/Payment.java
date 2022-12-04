package com.kodlamaio.paymentservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import javax.persistence.*;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
>>>>>>> e4bd1ba4ef4add7550e75eb3942277d857dffebe

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
<<<<<<< HEAD

    @Column(name = "rentalId")
    private String rentalId;
=======
>>>>>>> e4bd1ba4ef4add7550e75eb3942277d857dffebe
}
