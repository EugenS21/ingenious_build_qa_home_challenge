package com.ingenious_build.qa_home_challenge.web_automation.hook;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static io.qameta.allure.Allure.getLifecycle;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ScreenshotHooks {

    WebDriver webDriver;

    @After(order = 10, value = "not @test")
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshot = ((TakesScreenshot) webDriver);
            InputStream screenshotStream = new ByteArrayInputStream(screenshot.getScreenshotAs(OutputType.BYTES));
            getLifecycle().addAttachment(scenario.getName(),
                    "image/png",
                    "png",
                    screenshotStream
            );
        }
    }

}
