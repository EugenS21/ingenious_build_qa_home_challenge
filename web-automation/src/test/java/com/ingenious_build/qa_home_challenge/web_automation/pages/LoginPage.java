package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.login.LoginFormDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.LoginPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.LoginForm;
import com.ingenious_build.qa_home_challenge.web_automation.model.LoginDetails;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@ScenarioScope
public class LoginPage {

    LoginForm loginForm;
    ModelMapper modelMapper;

    @Autowired
    public LoginPage(LoginPageProperties loginPageProperties, ModelMapper modelMapper, WebDriver webDriver) {
        this.loginForm = new LoginForm(loginPageProperties, webDriver);
        this.modelMapper = modelMapper;
    }

    public void fillFormWithLoginDetails(LoginDetails loginDetails) {
        loginForm.fillForm(modelMapper.map(loginDetails, LoginFormDetails.class));
    }

    public void login() {
        loginForm.login();
    }

}
