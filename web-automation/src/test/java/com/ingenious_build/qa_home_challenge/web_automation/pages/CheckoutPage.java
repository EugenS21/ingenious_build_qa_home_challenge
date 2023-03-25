package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutBodyProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutItemsProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.CheckOutItem;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.CheckOutItemsGrid;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.CheckoutPageFooter;
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

    @Override
    public String getExpectedUrl() {
        return properties.getCheckOut().getUrl();
    }

    public List<ProductDetails> getCheckoutItems() {
        return checkOutItemsGrid.getItems().stream()
                .map(CheckOutItem::convert)
                .map(checkOutItem -> modelMapper.map(checkOutItem, ProductDetails.class).toBuilder()
                        .price(TestUtils.getMonetaryAmountFromString.apply(checkOutItem.getPrice()))
                        .build())
                .toList();
    }

    public void removeItemFromCart(InventoryItemSearchCriteria searchCriteria) {
        checkOutItemsGrid.searchForItem(searchCriteria).forEach(CheckOutItem::removeFromCart);
    }

    public void checkout() {
        checkoutPageFooter.checkout();
    }

    public void continueShopping() {
        checkoutPageFooter.continueShopping();
    }

}
