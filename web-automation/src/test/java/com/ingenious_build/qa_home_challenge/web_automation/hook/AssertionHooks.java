package com.ingenious_build.qa_home_challenge.web_automation.hook;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.WebAutomationProperties;
import com.ingenious_build.qa_home_challenge.web_automation.storage.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AssertionHooks {

    SoftAssertions softAssertions;

    @After(order = 9)
    public void doSoftAssert() {
        softAssertions.assertAll();
    }

}