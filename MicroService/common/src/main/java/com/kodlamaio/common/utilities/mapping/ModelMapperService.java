package com.kodlamaio.common.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forDto();

    ModelMapper forRequest();
}
