package com.kodlamaio.filterservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Filter {

    @Id
    @Field(name = "id")
    private String id;
    // brand
    @Field(name = "brandId")
    private String brandId;

    @Field(name = "brandName")
    private String brandName;
    // car
    @Field(name = "dailyPrice")
    private double dailyPrice;

    @Field(name = "modelYear")
    private int modelYear;

    @Field(name = "plate")
    private String plate;

    @Field(name = "state")
    private int state;

    //model
    @Field(name = "modelId")
    private String modelId;

    @Field(name = "modelName")
    private String modelname;
}
