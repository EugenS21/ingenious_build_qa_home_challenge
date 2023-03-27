package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingField;
import com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingStrategy;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page.InventoryHeaderProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Anchor;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.SortSelect;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Span;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

import static com.ingenious_build.qa_home_challenge.web_automation.core.web.service.SortingStrategySolverService.of;


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

    public Integer getProductsAddedToCart() {
        return cart.get().numberOfProductsAddedToCart();
    }

    public void sort(SortingField sortingField, SortingStrategy sortingStrategy) {
        sortContainer.get().selectOption(of(sortingField, sortingStrategy).getStrategy());
    }

    public void backToInventory() {
        backToProducts.get().click();
    }

}
