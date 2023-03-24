package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page.InventoryHeaderProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page.InventoryItemProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page.InventoryListProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.Grid;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.*;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.service.InventoryItemSearchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.function.Supplier;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Header {

    Supplier<ShoppingCart> cart;
    Supplier<Button> backToProducts;
    Supplier<SortSelect> sortContainer;

    public Header(InventoryHeaderProperties headerProperties, WebDriver webDriver) {
        this.cart = () -> new ShoppingCart(new Anchor(webDriver.findElement(headerProperties.getPrimary().getCart().getBySelf())),
                new Span(webDriver.findElement(headerProperties.getPrimary().getCart().getBadge())));
        this.backToProducts = () -> new Button(webDriver.findElement(headerProperties.getSecondary().getBackToProducts()));
        this.sortContainer = () -> new SortSelect(webDriver.findElement(headerProperties.getSecondary().getSortContainer()));
    }

    public void goToCart() {
        cart.get().openCart();
    }

    public Integer getProductsAddedToCart(){
        return cart.get().numberOfProductsAddedToCart();
    }

    public void sort(String sortingStrategy) {
        sortContainer.get().selectOption(sortingStrategy);
    }

    public void backToInventory() {
        backToProducts.get().click();
    }

}
