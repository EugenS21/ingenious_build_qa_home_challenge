package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutBodyProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutItemsProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.CheckOutItemsGrid;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.CheckoutPageFooter;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckoutOverviewPage extends AbstractPage{

    CheckOutItemsGrid checkOutItemsGrid;
    CheckoutPageFooter checkoutPageFooter;

    public CheckoutOverviewPage(ModelMapper modelMapper, PagesProperties properties, WebDriver webDriver) {
        super(modelMapper, properties, webDriver);
        CheckOutBodyProperties checkOutBodyProperties = properties.getCheckOut().getBody();
        CheckOutItemsProperties checkOutItemsProperties = checkOutBodyProperties.getCartItems();
        checkOutItemsGrid = new CheckOutItemsGrid(checkOutItemsProperties, webDriver);
        checkoutPageFooter = new CheckoutPageFooter(checkOutBodyProperties.getCartFooter(), webDriver);
    }

    public void finish() {

    }

}
