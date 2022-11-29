package com.kodlamaio.inventoryservice.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelResponse {
    private String id;
    private String name;
}
