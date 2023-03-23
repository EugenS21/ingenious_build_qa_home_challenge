package com.ingenious_build.qa_home_challenge.web_automation.steps.assertions;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.LoginPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.model.LoginDetails;
import com.ingenious_build.qa_home_challenge.web_automation.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LoginPageSteps {

    LoginPage loginPage;
    SoftAssertions softAssertion;
    WebDriver webDriver;
    LoginPageProperties loginPageProperties;

    @Then("I should be redirected to products page")
    public void iShouldBeRedirectedToProductsPage() {
        softAssertion.assertThat(webDriver.getCurrentUrl())
                .describedAs("Expecting to be redirected to inventory page")
                .contains("inventory");
    }

}
