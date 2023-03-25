package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.LoginFormDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.login_page.LoginPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.LoginForm;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LoginPage extends AbstractPage{

    LoginForm loginForm;
    LoginPageProperties loginPageProperties;

    public LoginPage(ModelMapper modelMapper, PagesProperties properties, WebDriver webDriver) {
        super(modelMapper, properties, webDriver);
        this.loginPageProperties = properties.getLogin();
        this.loginForm = new LoginForm(loginPageProperties, webDriver);
    }

    public void get() {
        webDriver.get(loginPageProperties.getUrl());
    }

    public void fillFormWithLoginDetails(LoginFormDetails loginDetails) {
        loginForm.fillForm(loginDetails);
    }

    public void login() {
        loginForm.login();
    }

    public void login(LoginFormDetails loginDetails) {
        loginForm.login(loginDetails);
    }

    public boolean isExpectedError(String expectedError) {
        return loginForm.validateFormErrorMessage(expectedError);
    }

}
