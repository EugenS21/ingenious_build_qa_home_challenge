package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.CheckoutInformationFormDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.model.LoginFormDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutInformationPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckoutInformationFormProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.login_page.LoginFormProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.login_page.LoginPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.TextBlock;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.input.PasswordInput;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.input.TextInput;
import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

public class CheckOutInformationForm {

    Supplier<TextInput> firstName;
    Supplier<TextInput> lastName;
    Supplier<TextInput> zipCode;
    Supplier<TextBlock> error;
    Supplier<Button> doContinue;
    Supplier<Button> cancel;

    public CheckOutInformationForm(CheckOutInformationPageProperties properties, WebDriver webDriver) {
        CheckoutInformationFormProperties form = properties.getForm();
        this.firstName = () -> new TextInput(webDriver.findElement(form.getFirstName()));
        this.lastName = () -> new TextInput(webDriver.findElement(form.getLastName()));
        this.zipCode = () -> new TextInput(webDriver.findElement(form.getZipCode()));
        this.error = () -> new TextBlock(webDriver.findElement(form.getError()));
        this.doContinue = () -> new Button(webDriver.findElement(form.getDoContinue()));
        this.cancel = () -> new Button(webDriver.findElement(form.getCancel()));
    }

    public void fillAndContinue(CheckoutInformationFormDetails formDetails) {
        firstName.get().setValue(formDetails.getFirstName());
        lastName.get().setValue(formDetails.getLastName());
        zipCode.get().setValue(formDetails.getZipCode());
        doContinue.get().click();
    }

}
