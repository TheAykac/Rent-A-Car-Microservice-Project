package com.kodlamaio.filterservice.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetModelResponse {
    private String modelId;
    private String modelname;
}
