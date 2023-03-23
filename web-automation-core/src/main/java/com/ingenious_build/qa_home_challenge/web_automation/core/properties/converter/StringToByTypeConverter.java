package com.ingenious_build.qa_home_challenge.web_automation.core.properties.converter;

import com.ingenious_build.qa_home_challenge.common_tools.exceptions.UnknownPropertyException;
import com.ingenious_build.qa_home_challenge.web_automation.core.enums.DriverType;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.WebAutomationProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.service.LocatorsResolverService;
import io.vavr.control.Option;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@ConfigurationPropertiesBinding
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StringToByTypeConverter implements Converter<String, By> {

    LocatorsResolverService locatorsResolverService;

    public StringToByTypeConverter() {
        this.locatorsResolverService = new LocatorsResolverService();
    }

    @Override
    public By convert(String source) {
        return locatorsResolverService.resolve(source);
    }

}
