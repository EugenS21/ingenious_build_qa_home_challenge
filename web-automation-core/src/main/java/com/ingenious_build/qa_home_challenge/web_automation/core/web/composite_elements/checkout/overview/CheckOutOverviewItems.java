package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout.overview;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckoutOverviewItemProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckoutOverviewItemsProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Anchor;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.TextBlock;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;

import java.util.List;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CheckOutOverviewItems {

    CheckoutOverviewItemsProperties itemsProperties;
    WebDriver webDriver;

    public List<CheckOutOverviewItem> getCheckOutOverviewItems() {
        return webDriver.findElements(itemsProperties.getBySelf()).stream()
                .map(webElement -> {
                    CheckoutOverviewItemProperties item = itemsProperties.getItem();
                    return CheckOutOverviewItem.builder()
                            .name(() -> new Anchor(webElement.findElement(item.getName())))
                            .price(() -> new TextBlock(webElement.findElement(item.getPrice())))
                            .description(() -> new TextBlock(webElement.findElement(item.getDescription())))
                            .build();
                })
                .map(object -> ((CheckOutOverviewItem) object))
                .toList();
    }


}
