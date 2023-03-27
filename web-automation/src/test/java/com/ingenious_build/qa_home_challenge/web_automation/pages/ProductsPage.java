package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingField;
import com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingStrategy;
import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page.InventoryPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.Header;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.inventory.InventoriesGrid;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.inventory.InventoryItem;
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
public class ProductsPage extends AbstractPageWithGrid {

    Header header;
    InventoriesGrid productsGrid;

    public ProductsPage(ModelMapper modelMapper, PagesProperties properties, WebDriver webDriver) {
        super(modelMapper, properties, webDriver);
        InventoryPageProperties inventoryProperties = properties.getInventory();
        this.header = new Header(inventoryProperties.getHeader(), webDriver);
        this.productsGrid = new InventoriesGrid(inventoryProperties.getBody().getInventoryList(), webDriver);
    }

    public List<ProductDetails> getProductsFromGrid() {
        return getProductsFromGrid(productsGrid.getItems());
    }

    public void addProductsToCart(InventoryItemSearchCriteria searchCriteria) {
        productsGrid.searchForItem(searchCriteria).forEach(InventoryItem::addToCart);
    }

    @Override
    public String getExpectedUrl() {
        return properties.getInventory().getUrl();
    }

    public void goToCart() {
        header.goToCart();
    }

    public Integer getNumberOfProductsAddedToCard() {
        return header.getProductsAddedToCart();
    }

    public void sort(SortingField sortingField, SortingStrategy sortingStrategy) {
        header.sort(sortingField, sortingStrategy);
    }

}
