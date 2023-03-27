package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout.overview;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckoutOverviewFooterProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckOutOverviewFooter {

    Supplier<Button> finish;
    Supplier<Button> cancel;

    public CheckOutOverviewFooter(CheckoutOverviewFooterProperties properties, WebDriver webDriver) {
        finish = () -> new Button(webDriver.findElement(properties.getFinish()));
        cancel = () -> new Button(webDriver.findElement(properties.getCancel()));
    }

    public void finish() {
        finish.get().click();
    }

    public void cancel() {
        cancel.get().click();
    }

}
