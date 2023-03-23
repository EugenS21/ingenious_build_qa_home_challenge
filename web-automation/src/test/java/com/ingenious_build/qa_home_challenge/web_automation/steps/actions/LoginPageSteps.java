package com.ingenious_build.qa_home_challenge.web_automation.steps.actions;

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

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LoginPageSteps {

    LoginPage loginPage;
    SoftAssertions softAssertion;
    WebDriver webDriver;
    LoginPageProperties loginPageProperties;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        webDriver.get(loginPageProperties.getUrl());
    }

    @When("I enter the following login credentials:")
    public void iEnterTheFollowingLoginCredentials(LoginDetails loginDetails) {
        loginPage.fillFormWithLoginDetails(loginDetails);
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        loginPage.login();
    }

}
