package com.ingenious_build.qa_home_challenge.web_automation.steps;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.model.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.storage.ScenarioContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;

@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class AbstractAssertionsStepClass extends AbstractStepClass {

    SoftAssertions softAssertions;

    public AbstractAssertionsStepClass(StepClassesDependencies dependencies, SoftAssertions softAssertions) {
        super(dependencies);
        this.softAssertions = softAssertions;
    }

}
