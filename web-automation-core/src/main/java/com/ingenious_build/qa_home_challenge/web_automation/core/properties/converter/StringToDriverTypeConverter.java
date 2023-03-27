package com.ingenious_build.qa_home_challenge.web_automation.core.properties.converter;

import com.ingenious_build.qa_home_challenge.common_tools.exceptions.InvalidPropertyException;
import com.ingenious_build.qa_home_challenge.web_automation.core.enums.DriverType;
import io.vavr.control.Option;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class StringToDriverTypeConverter implements Converter<String, DriverType> {

    @Override
    public DriverType convert(String source) {
        return Option.of(source)
                .map(String::trim)
                .map(String::toUpperCase)
                .toTry()
                .map(DriverType::valueOf)
                .getOrElseThrow(() -> new InvalidPropertyException("Property [%s] can't be compiled to a pattern", source));
    }

}
