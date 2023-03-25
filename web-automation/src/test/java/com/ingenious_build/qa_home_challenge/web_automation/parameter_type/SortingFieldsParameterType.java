package com.ingenious_build.qa_home_challenge.web_automation.parameter_type;

import com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingField;
import io.cucumber.java.ParameterType;

public class SortingFieldsParameterType {

    @ParameterType("(price|name)")
    public SortingField sortingField(String value) {
        return SortingField.valueOf(value.toUpperCase());
    }

}
