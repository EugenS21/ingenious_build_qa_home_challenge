package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.CheckoutInformationFormDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.CheckOutInformationForm;
import com.ingenious_build.qa_home_challenge.web_automation.model.CheckoutInformation;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckoutInformationPage extends AbstractPage{

    CheckOutInformationForm checkOutInformationForm;

    public CheckoutInformationPage(ModelMapper modelMapper, PagesProperties properties, WebDriver webDriver) {
        super(modelMapper, properties, webDriver);
        checkOutInformationForm = new CheckOutInformationForm(properties.getCheckOutInformation(), webDriver);
    }

    public void doContinue() {
        checkOutInformationForm.doContinue();
    }

    @Override
    public String getExpectedUrl() {
        return properties.getCheckOutInformation().getUrl();
    }

    public void doCancel() {
        checkOutInformationForm.cancel();
    }

    public void fillInformationForm(CheckoutInformation checkoutInformation) {
        CheckoutInformationFormDetails webCheckoutInformation = modelMapper.map(checkoutInformation, CheckoutInformationFormDetails.class);
        checkOutInformationForm.fillIn(webCheckoutInformation);
    }

}
