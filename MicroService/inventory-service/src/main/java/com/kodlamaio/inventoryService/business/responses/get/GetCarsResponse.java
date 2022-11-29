package com.kodlamaio.inventoryService.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarsResponse {

    private String id;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private String brandName;
    private String modelName;
}
