package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.LoginFormDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.login_page.LoginFormProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.login_page.LoginPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.input.PasswordInput;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.TextBlock;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.input.TextInput;
import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

public class LoginForm {

    Supplier<TextInput> userName;
    Supplier<PasswordInput> password;
    Supplier<TextBlock> errorContainer;
    Supplier<Button> loginButton;

    public LoginForm(LoginPageProperties properties, WebDriver webDriver) {
        LoginFormProperties form = properties.getForm();
        this.userName = () -> new TextInput(webDriver.findElement(form.getUsername()));
        this.password = () -> new PasswordInput(webDriver.findElement(form.getPassword()));
        this.errorContainer = () -> new TextBlock(webDriver.findElement(form.getErrorMessageContainer()));
        this.loginButton = () -> new Button(webDriver.findElement(form.getLoginButton()));
    }

    public boolean validateFormErrorMessage(String expectedMessage) {
        return errorContainer.get().getContent().equals(expectedMessage);
    }

    public void fillForm(LoginFormDetails loginDetails) {
        userName.get().setValue(loginDetails.getUsername());
        password.get().setValue(loginDetails.getPassword());
    }

    public void login() {
        loginButton.get().click();
    }

    public void login(LoginFormDetails loginFormDetails) {
        fillForm(loginFormDetails);
        login();
    }

}
