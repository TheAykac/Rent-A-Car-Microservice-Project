package com.kodlamaio.inventoryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brands")
public class Brand {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "brand")
    private List<Model> models;
}
