package com.kodlamaio.inventoryService.business.requests.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
    @NotBlank
    @NotNull
    private String id;
    @NotBlank
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
}
