package com.kodlamaio.filterservice.business.responses.getAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarResponse {
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private int state;

}
