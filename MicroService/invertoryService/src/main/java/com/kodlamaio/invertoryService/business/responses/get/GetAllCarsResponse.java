package com.kodlamaio.invertoryService.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {

	private String id;
	private double dailyPrice;
	private int modelYear;
	private String plate;
	private String modelBrandName;
	private String modelName;
	private int state;
	
}
