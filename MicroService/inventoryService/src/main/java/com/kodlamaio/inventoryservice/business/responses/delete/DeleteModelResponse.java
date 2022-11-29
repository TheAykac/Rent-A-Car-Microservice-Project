package com.kodlamaio.inventoryservice.business.responses.delete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteModelResponse {
    private String id;
    private String name;
}
