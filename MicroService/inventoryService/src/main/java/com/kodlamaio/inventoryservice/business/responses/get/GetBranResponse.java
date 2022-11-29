package com.kodlamaio.inventoryservice.business.responses.get;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBranResponse {
    private String id;
    private String name;
}
