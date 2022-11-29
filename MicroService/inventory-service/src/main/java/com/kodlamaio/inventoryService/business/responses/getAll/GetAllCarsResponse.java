package com.kodlamaio.inventoryService.business.responses.getAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {

    private String id;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private String brandName;
    private String modelName;
}
