package com.kodlamaio.common.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

	ModelMapper forRequest();
	ModelMapper forResponse();
}
