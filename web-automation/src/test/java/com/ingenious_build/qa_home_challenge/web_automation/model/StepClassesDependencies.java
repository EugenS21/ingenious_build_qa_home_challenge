package com.ingenious_build.qa_home_challenge.web_automation.model;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.storage.ScenarioContext;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;


@Component
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class StepClassesDependencies {

    ModelMapper modelMapper;
    PagesProperties pageLocators;
    ScenarioContext scenarioContext;
    WebDriver webDriver;

}
