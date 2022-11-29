package com.kodlamaio.common.utilities.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelMapperManager implements ModelMapperService{
    private final ModelMapper modelMapper;

    @Autowired
    public ModelMapperManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public ModelMapper forDto() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }

    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }

}
