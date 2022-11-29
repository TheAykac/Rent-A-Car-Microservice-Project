package com.kodlamaio.inventoryservice.business.requests.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    @NotNull
    @NotBlank
    private String id;
    @Min(0)
    private double dailyPrice;
    @NotNull
    @NotBlank
    private String plate;
    @Min(2015)
    private int modelYear;
    @Min(1)
    @Max(3)
    private int state;
    @NotNull
    @NotBlank
    private String modelId;
}
