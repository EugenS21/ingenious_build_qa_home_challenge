package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.ItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page.InventoryItemProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page.InventoryListProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.Grid;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Anchor;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.TextBlock;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.WebImage;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.service.ItemsSearchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;

import java.util.List;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class InventoriesGrid implements Grid<InventoryItem> {

    InventoryListProperties inventoryProperties;
    WebDriver webDriver;

    @Override
    public List<InventoryItem> searchForItem(ItemSearchCriteria searchCriteria) {
        return ItemsSearchService.doWith(searchCriteria).and(getItems()).getFoundItems();
    }

    @Override
    public List<InventoryItem> getItems() {
        InventoryItemProperties inventoryItem = inventoryProperties.getInventoryItem();
        return webDriver.findElements(inventoryItem.getBySelf()).stream()
                .map(webElement -> InventoryItem.builder()
                        .webImage(() -> new WebImage(webElement.findElement(inventoryItem.getImage())))
                        .name(() -> new Anchor(webElement.findElement(inventoryItem.getName())))
                        .description(() -> new TextBlock(webElement.findElement(inventoryItem.getDescription())))
                        .price(() -> new TextBlock(webElement.findElement(inventoryItem.getPrice())))
                        .addToCart(() -> new Button(webElement.findElement(inventoryItem.getAddToCart())))
                        .build())
                .map(item -> ((InventoryItem) item))
                .toList();
    }

}
