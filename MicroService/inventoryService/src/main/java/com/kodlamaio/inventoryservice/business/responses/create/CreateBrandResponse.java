package com.kodlamaio.inventoryservice.business.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandResponse {
    private String id;
    private String name;
}
