package com.kodlamaio.inventoryservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "daily_price")
    private String dailyPrice;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "plate")
    private String plate;

    @Column(name = "state")// 1- Available 2- Under Maintanence 3- Rented
    private int state;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

}
