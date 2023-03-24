package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page.InventoryPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.Header;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.InventoriesGrid;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckoutPage extends AbstractPage{

    public CheckoutPage(PagesProperties properties, WebDriver webDriver) {
        super(properties, webDriver);
        InventoryPageProperties inventoryProperties = properties.getInventory();
    }

}
