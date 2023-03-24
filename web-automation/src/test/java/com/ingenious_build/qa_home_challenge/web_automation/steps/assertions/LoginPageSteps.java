package com.ingenious_build.qa_home_challenge.web_automation.steps.assertions;

import com.ingenious_build.qa_home_challenge.web_automation.model.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.pages.LoginPage;
import com.ingenious_build.qa_home_challenge.web_automation.steps.AbstractAssertionsStepClass;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LoginPageSteps extends AbstractAssertionsStepClass {

    LoginPage loginPage;

    public LoginPageSteps(LoginPage loginPage, StepClassesDependencies dependencies, SoftAssertions softAssertions) {
        super(dependencies, softAssertions);
        this.loginPage = loginPage;
    }

    @Then("I should be redirected to products page")
    public void iShouldBeRedirectedToProductsPage() {
        softAssertions.assertThat(loginPage.getUrl())
                .describedAs("Expecting to be redirected to inventory page")
                .contains("inventory");
    }

    @Then("I should see '{}' error")
    public void iShouldSeeALoginError(String expectedError) {
        softAssertions.assertThat(loginPage.isExpectedError(expectedError))
                .describedAs("Expecting to see {} error while login", expectedError)
                .isTrue();
    }
}
