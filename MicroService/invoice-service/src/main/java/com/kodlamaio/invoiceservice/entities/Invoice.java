package com.kodlamaio.invoiceservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoices")
public class Invoice {
    @Id
    @Column(name = "invoiceId")
    private String id;

    @Column(name = "invoiceNo")
    private String invoiceNo;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "finish_date")
    private LocalDate finishDate;

    @Column(name = "total_rental_day")
    private short totalRentalDay;

    @Column(name = "price_of_days")
    private double priceOfDays;

    @Column(name = "price_of_diff_city")
    private double priceOfDiffCity;


    @Column(name = "rental_car_total_price")
    private double rentalCarTotalPrice;

    @Column(name = "rentalCarId")
    private String rentalId;



}
