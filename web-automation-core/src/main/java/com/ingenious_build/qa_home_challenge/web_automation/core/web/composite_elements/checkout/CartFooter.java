package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutCartFooterProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CartFooter {

    Supplier<Button> continueShopping;
    Supplier<Button> checkOut;

    public CartFooter(CheckOutCartFooterProperties properties, WebDriver webDriver) {
        continueShopping = () -> new Button(webDriver.findElement(properties.getContinueShopping()));
        checkOut = () -> new Button(webDriver.findElement(properties.getCheckout()));
    }

    public void checkout() {
        checkOut.get().click();
    }

    public void continueShopping() {
        continueShopping.get().click();
    }

}
