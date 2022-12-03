package com.kodlamaio.rentalService.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalResponse {
    private String id;
    private String carId;
    private int rentedForDays;
    private double dailyPrice;
}
