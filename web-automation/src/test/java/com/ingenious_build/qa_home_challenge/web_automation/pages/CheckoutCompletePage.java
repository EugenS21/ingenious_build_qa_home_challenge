package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout.complete.CheckOutCompleteContainer;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckoutCompletePage extends AbstractPage {

    CheckOutCompleteContainer checkOutCompleteContainer;

    public CheckoutCompletePage(ModelMapper modelMapper, PagesProperties properties, WebDriver webDriver) {
        super(modelMapper, properties, webDriver);
        this.checkOutCompleteContainer = new CheckOutCompleteContainer(properties.getCheckOutComplete().getContainer(), webDriver);
    }

    public String getHeader() {
        return checkOutCompleteContainer.getHeader();
    }

    public String getText() {
        return checkOutCompleteContainer.getText();
    }

    public void goBackHome() {
        checkOutCompleteContainer.getBackHome();
    }

    @Override
    public String getExpectedUrl() {
        return properties.getCheckOutComplete().getUrl();
    }

}
