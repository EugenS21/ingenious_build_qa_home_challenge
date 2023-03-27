package com.ingenious_build.qa_home_challenge.web_automation.configuration;

import com.ingenious_build.qa_home_challenge.testing_components.core.storage.ScenarioContext;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.enums.UiStorageKey;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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
    ScenarioContext<UiStorageKey> scenarioContext;
    WebDriver webDriver;

}
