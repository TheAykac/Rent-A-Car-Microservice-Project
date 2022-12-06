package com.kodlamaio.filterservice.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private int state;

}
