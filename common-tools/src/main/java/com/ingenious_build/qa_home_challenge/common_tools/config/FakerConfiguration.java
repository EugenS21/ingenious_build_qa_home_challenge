package com.ingenious_build.qa_home_challenge.common_tools.config;

import com.github.javafaker.Faker;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class FakerConfiguration {

    @Getter(onMethod = @__(@Bean))
    Faker faker;

    public FakerConfiguration() {
        faker = new Faker(Locale.ENGLISH);
    }

}
