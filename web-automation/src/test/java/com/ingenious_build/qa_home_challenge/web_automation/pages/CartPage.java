package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutBodyProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutItemsProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout.CartItem;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout.CartItemsGrid;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout.CartFooter;
import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import com.ingenious_build.qa_home_challenge.web_automation.utils.TestUtils;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ScenarioScope
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CartPage extends AbstractPage {

    CartItemsGrid cartItemsGrid;
    CartFooter cartFooter;

    public CartPage(ModelMapper modelMapper, PagesProperties properties, WebDriver webDriver) {
        super(modelMapper, properties, webDriver);
        CheckOutBodyProperties checkOutBodyProperties = properties.getCheckOut().getBody();
        CheckOutItemsProperties checkOutItemsProperties = checkOutBodyProperties.getCartItems();
        cartItemsGrid = new CartItemsGrid(checkOutItemsProperties, webDriver);
        cartFooter = new CartFooter(checkOutBodyProperties.getCartFooter(), webDriver);
    }

    @Override
    public String getExpectedUrl() {
        return properties.getCheckOut().getUrl();
    }

    public List<ProductDetails> getCheckoutProducts() {
        return cartItemsGrid.getItems().stream()
                .map(CartItem::getData)
                .map(checkOutItem -> modelMapper.map(checkOutItem, ProductDetails.class).toBuilder()
                        .price(TestUtils.getMonetaryAmountFromString.apply(checkOutItem.getPrice()))
                        .build())
                .toList();
    }

    public void removeProductFromCart(InventoryItemSearchCriteria searchCriteria) {
        cartItemsGrid.searchForItem(searchCriteria).forEach(CartItem::removeFromCart);
    }

    public void checkout() {
        cartFooter.checkout();
    }

    public void continueShopping() {
        cartFooter.continueShopping();
    }

}
