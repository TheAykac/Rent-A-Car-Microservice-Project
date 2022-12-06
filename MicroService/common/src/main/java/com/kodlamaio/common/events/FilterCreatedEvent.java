package com.kodlamaio.common.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterCreatedEvent {

    private String brandId;
    private String brandName;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private int state;
    private String modelId;
    private String modelname;
}
