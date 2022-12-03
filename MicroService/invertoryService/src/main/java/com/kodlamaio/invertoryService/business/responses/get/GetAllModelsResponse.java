package com.kodlamaio.invertoryService.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {

	private String id;
	private String name;
	private String brandName;
}
