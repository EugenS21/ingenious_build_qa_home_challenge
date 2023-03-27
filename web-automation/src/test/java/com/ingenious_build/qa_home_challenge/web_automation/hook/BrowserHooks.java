package com.ingenious_build.qa_home_challenge.web_automation.hook;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.WebAutomationProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class BrowserHooks {

    WebDriver webDriver;
    WebAutomationProperties applicationProperties;

    @Before(order = 1)
    public void navigateToDefaultUrl(){
        webDriver.get(applicationProperties.getUrl());
    }


    @After(order = 10)
    public void closeBrowser() {
        webDriver.close();
    }

}
