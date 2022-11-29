package com.kodlamaio.inventoryService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "dailyPrice")
    private double dailyPrice;
    @Column(name = "modelYear")
    private int modelYear;
    @Column(name = "plate")
    private String plate;

    @Column(name = "state") //1-available 2-under maintenance 3-rented
    private int state;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
