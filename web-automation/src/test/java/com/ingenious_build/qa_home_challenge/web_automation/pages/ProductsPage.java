package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page.InventoryPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.Header;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.InventoriesGrid;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.InventoryItem;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ScenarioScope
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductsPage extends AbstractPage{

    Header header;
    InventoriesGrid productsGrid;

    public ProductsPage(PagesProperties properties, WebDriver webDriver) {
        super(properties, webDriver);
        InventoryPageProperties inventoryProperties = properties.getInventory();
        this.header = new Header(inventoryProperties.getHeader(), webDriver);
        this.productsGrid = new InventoriesGrid(inventoryProperties.getBody().getInventoryList(), webDriver);
    }

    public List<InventoryItem> getProductsFromGrid() {
        return productsGrid.getItems();
    }

    public void addItemsToCart(InventoryItemSearchCriteria searchCriteria) {
        productsGrid.searchForItem(searchCriteria).forEach(InventoryItem::addToCart);
    }

    public void goToCart(){
        header.goToCart();
    }

    public Integer getNumberOfProductsAddedToCard() {
        return header.getProductsAddedToCart();
    }

}