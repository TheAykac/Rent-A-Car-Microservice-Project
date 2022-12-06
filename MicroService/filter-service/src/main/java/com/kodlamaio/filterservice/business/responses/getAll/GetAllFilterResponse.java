package com.kodlamaio.filterservice.business.responses.getAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllFilterResponse {
    private String brandName;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private int state;
    private String modelname;
}
