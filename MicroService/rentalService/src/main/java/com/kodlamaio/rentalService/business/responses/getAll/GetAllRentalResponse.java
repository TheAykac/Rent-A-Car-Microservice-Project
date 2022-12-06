package com.kodlamaio.rentalService.business.responses.getAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRentalResponse {

    private String id;
    private String carId;
    private int rentedForDays;
    private double dailyPrice;
}
