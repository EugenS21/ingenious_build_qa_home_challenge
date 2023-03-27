package com.ingenious_build.qa_home_challenge.web_automation.steps;

import com.ingenious_build.qa_home_challenge.testing_components.core.storage.ScenarioContext;
import com.ingenious_build.qa_home_challenge.web_automation.configuration.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.enums.UiStorageKey;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;

import static lombok.AccessLevel.PROTECTED;

@FieldDefaults(makeFinal = true, level = PROTECTED)
public abstract class AbstractStepClass {

    ModelMapper modelMapper;
    PagesProperties pageLocators;
    ScenarioContext<UiStorageKey> scenarioContext;
    WebDriver webDriver;

    protected AbstractStepClass (StepClassesDependencies dependencies) {
        this.modelMapper = dependencies.getModelMapper();
        this.pageLocators = dependencies.getPageLocators();
        this.scenarioContext = dependencies.getScenarioContext();
        this.webDriver = dependencies.getWebDriver();
    }

}
