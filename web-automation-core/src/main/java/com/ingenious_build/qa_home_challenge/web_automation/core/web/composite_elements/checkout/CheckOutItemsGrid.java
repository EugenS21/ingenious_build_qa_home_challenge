package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutItemProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutItemsProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout.CheckOutItem;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.Grid;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Anchor;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.TextBlock;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.service.InventoryItemSearchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;

import java.util.List;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CheckOutItemsGrid implements Grid<CheckOutItem> {

    CheckOutItemsProperties checkOutItemsProperties;
    WebDriver webDriver;

    @Override
    public List<CheckOutItem> searchForItem(InventoryItemSearchCriteria searchCriteria) {
        return InventoryItemSearchService.doWith(searchCriteria).and(getItems()).getFoundItems();
    }

    @Override
    public List<CheckOutItem> getItems() {
        CheckOutItemProperties cartItem = checkOutItemsProperties.getCartItem();
        return webDriver.findElements(cartItem.getBySelf()).stream()
                .map(webElement -> CheckOutItem.builder()
                        .name(() -> new Anchor(webElement.findElement(cartItem.getName())))
                        .description(() -> new TextBlock(webElement.findElement(cartItem.getDescription())))
                        .price(() -> new TextBlock(webElement.findElement(cartItem.getPrice())))
                        .removeFromCart(() -> new Button(webElement.findElement(cartItem.getRemoveFromCart())))
                        .build())
                .map(item -> ((CheckOutItem) item))
                .toList();
    }

}
