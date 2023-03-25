package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.ItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutBodyProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutItemsProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page.InventoryPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.*;
import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.List;

import static com.ingenious_build.qa_home_challenge.web_automation.utils.TestUtils.getMonetaryAmountFromString;

@Component
@ScenarioScope
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckoutPage extends AbstractPage{

    CheckOutItemsGrid checkOutItemsGrid;
    CheckoutPageFooter checkoutPageFooter;

    public CheckoutPage(ModelMapper modelMapper, PagesProperties properties, WebDriver webDriver) {
        super(modelMapper, properties, webDriver);
        CheckOutBodyProperties checkOutBodyProperties = properties.getCheckOut().getBody();
        CheckOutItemsProperties checkOutItemsProperties = checkOutBodyProperties.getCartItems();
        checkOutItemsGrid = new CheckOutItemsGrid(checkOutItemsProperties, webDriver);
        checkoutPageFooter = new CheckoutPageFooter(checkOutBodyProperties.getCartFooter(), webDriver);
    }

    public List<ProductDetails> getCheckoutItems() {
        return checkOutItemsGrid.getItems().stream()
                .map(CheckOutItem::convert)
                .map(checkOutItem -> modelMapper.map(checkOutItem, ProductDetails.class).toBuilder()
                        .price(getMonetaryAmountFromString.apply(checkOutItem.getPrice()))
                        .build())
                .toList();
    }

    public void removeItemFromCart(ItemSearchCriteria searchCriteria) {
        checkOutItemsGrid.searchForItem(searchCriteria).forEach(CheckOutItem::removeFromCart);
    }

    public void checkout() {
        checkoutPageFooter.checkout();
    }

    public void continueShopping() {
        checkoutPageFooter.continueShopping();
    }

}
