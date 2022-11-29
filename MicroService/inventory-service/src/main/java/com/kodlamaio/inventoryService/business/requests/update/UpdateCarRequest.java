package com.kodlamaio.inventoryService.business.requests.update;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    @NotBlank
    @NotNull
    private String id;
    @Min(0)
    private double dailyPrice;
    @Min(2015)
    private int modelYear;
    @NotBlank
    @NotNull
    private String plate;
    @Min(1)
    @Max(3)
    private int state;
    @NotBlank
    @NotNull
    private String modelId;
}
