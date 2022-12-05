package com.kodlamaio.invoiceservice;

import com.kodlamaio.common.utilities.mapping.ModelMapperManager;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InvoiceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceServiceApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ModelMapperService getModelMapperService(ModelMapper  modelMapper) {
		return new ModelMapperManager(modelMapper);
	}

}
