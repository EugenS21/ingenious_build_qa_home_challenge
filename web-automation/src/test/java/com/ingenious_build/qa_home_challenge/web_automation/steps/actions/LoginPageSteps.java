package com.ingenious_build.qa_home_challenge.web_automation.steps.actions;

import com.ingenious_build.qa_home_challenge.web_automation.configuration.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.core.model.LoginFormDetails;
import com.ingenious_build.qa_home_challenge.web_automation.model.LoginDetails;
import com.ingenious_build.qa_home_challenge.web_automation.pages.LoginPage;
import com.ingenious_build.qa_home_challenge.web_automation.steps.AbstractStepClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LoginPageSteps extends AbstractStepClass {

    LoginPage loginPage;

    @Autowired
    public LoginPageSteps(LoginPage loginPage, StepClassesDependencies dependencies) {
        super(dependencies);
        this.loginPage = loginPage;
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.get();
    }

    @When("I enter the following login credentials:")
    public void iEnterTheFollowingLoginCredentials(LoginDetails loginDetails) {
        LoginFormDetails loginFormDetails = modelMapper.map(loginDetails, LoginFormDetails.class);
        loginPage.fillFormWithLoginDetails(loginFormDetails);
    }

    @When("I login with the following credentials:")
    public void iLoginWithTheFollowingLoginCredentials(LoginDetails loginDetails) {
        LoginFormDetails loginFormDetails = modelMapper.map(loginDetails, LoginFormDetails.class);
        loginPage.login(loginFormDetails);
    }

    @When("click on login button")
    public void clickOnLoginButton() {
        loginPage.login();
    }

}
