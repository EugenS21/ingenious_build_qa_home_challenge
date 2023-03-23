package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.login.LoginFormDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.LoginFormProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.LoginPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.input.PasswordInput;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.TextBlock;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.input.TextInput;
import org.openqa.selenium.WebDriver;

public class LoginForm {

    TextInput userName;
    PasswordInput password;
    TextBlock errorContainer;
    Button loginButton;

    public LoginForm(LoginPageProperties properties, WebDriver webDriver) {
        LoginFormProperties form = properties.getForm();
        this.userName = new TextInput(webDriver.findElement(form.getUsername()));
        this.password = new PasswordInput(webDriver.findElement(form.getPassword()));
        this.errorContainer = new TextBlock(webDriver.findElement(form.getUsername()));
        this.loginButton = new Button(webDriver.findElement(form.getUsername()));
    }


    public LoginFormDetails getContent() {
        return LoginFormDetails.builder()
                .username(userName.getContent())
                .errorMessage(errorContainer.getContent())
                .build();
    }

    public boolean validateFormContent(LoginFormDetails loginFormDetails) {
        return getContent().equals(loginFormDetails);
    }

    public boolean validateFormErrorMessage(String expectedMessage) {
        return errorContainer.getContent().equals(expectedMessage);
    }

    public void fillForm(LoginFormDetails loginDetails) {
        userName.setValue(loginDetails.getUsername());
        password.setValue(loginDetails.getPassword());
    }

    public void login() {
        loginButton.click();
    }

    public void login(LoginFormDetails loginFormDetails) {
        fillForm(loginFormDetails);
        login();
    }

}
