package com.ingenious_build.qa_home_challenge.web_automation.parameter_type;

import com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingStrategy;
import io.cucumber.java.ParameterType;

public class SortingStrategyParameterType {

    @ParameterType("asc|desc")
    public SortingStrategy sortingStrategy(String value) {
        return SortingStrategy.valueOf(value.toUpperCase());
    }

}
