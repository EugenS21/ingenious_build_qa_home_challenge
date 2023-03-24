package com.ingenious_build.qa_home_challenge.common_tools.config;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Getter(onMethod = @__(@Bean))
    ModelMapper modelMapper;



    public ModelMapperConfiguration() {
        var mapper = new ModelMapper();
        var configuration = mapper.getConfiguration();
        configuration.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        configuration.setMethodAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        configuration.setFieldMatchingEnabled(true);
        configuration.setAmbiguityIgnored(true);
        configuration.setSkipNullEnabled(true);
        this.modelMapper = mapper;
    }
}
