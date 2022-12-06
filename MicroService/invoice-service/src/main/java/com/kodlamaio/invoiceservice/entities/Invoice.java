package com.kodlamaio.invoiceservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "invoices")
public class Invoice {
    @Id
    @Column(name = "invoiceId")
    private String id;

    @Column(name = "invoiceNo")
    private String invoiceNo;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "totalRentalDay")
    private int totalRentalDay;

    @Column(name = "priceOfDays")
    private double priceOfDays;

    @Column(name = "rentalCarTotalPrice")
    private double rentalCarTotalPrice;

    @JoinColumn(name = "rentalId")
    private String  rentalId;


}
