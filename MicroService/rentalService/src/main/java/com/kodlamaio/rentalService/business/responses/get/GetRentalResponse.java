package com.kodlamaio.rentalService.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalResponse {

    private String id;
    private String carId;
    private int rentedForDays;
    private double dailyPrice;
}
