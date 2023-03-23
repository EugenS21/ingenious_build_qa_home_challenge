package com.ingenious_build.qa_home_challenge.web_automation.steps.actions;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import io.cucumber.java.en.Given;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomePageSteps {

    @Autowired
    PagesProperties pagesProperties;

    @Autowired
    WebDriver webDriver;

    @Given("I say hi")
    public void iSayHi() {
        System.out.println();
    }


}
