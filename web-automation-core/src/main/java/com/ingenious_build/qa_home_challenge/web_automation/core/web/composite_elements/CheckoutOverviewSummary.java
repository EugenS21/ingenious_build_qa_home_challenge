package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckoutOverviewSummaryProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.TextBlock;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckoutOverviewSummary {

    Supplier<TextBlock> paymentInfo;
    Supplier<TextBlock> shippingInfo;
    Supplier<TextBlock> itemTotalPrice;
    Supplier<TextBlock> tax;
    Supplier<TextBlock> total;


    public CheckoutOverviewSummary(CheckoutOverviewSummaryProperties properties, WebDriver webDriver) {
        this.paymentInfo = () -> new TextBlock(webDriver.findElement(properties.getPaymentInfo()));
        this.shippingInfo = () -> new TextBlock(webDriver.findElement(properties.getShippingInfo()));
        this.itemTotalPrice = () -> new TextBlock(webDriver.findElement(properties.getPrice().getItemTotal()));
        this.tax = () -> new TextBlock(webDriver.findElement(properties.getPrice().getTax()));
        this.total = () -> new TextBlock(webDriver.findElement(properties.getPrice().getTotal()));
    }

    public String getPaymentInfo() {
        return paymentInfo.get().getContent();
    }

    public String getShippingInfo() {
        return shippingInfo.get().getContent();
    }

    public String getItemTotalPrice() {
        return itemTotalPrice.get().getContent();
    }

    public String getTax() {
        return tax.get().getContent();
    }

    public String getTotalPrice() {
        return total.get().getContent();
    }

}
