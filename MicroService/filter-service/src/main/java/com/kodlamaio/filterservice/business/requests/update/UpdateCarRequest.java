package com.kodlamaio.filterservice.business.requests.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    private double dailyPrice;
    private int modelYear;
    private String plate;
    private int state;
}
