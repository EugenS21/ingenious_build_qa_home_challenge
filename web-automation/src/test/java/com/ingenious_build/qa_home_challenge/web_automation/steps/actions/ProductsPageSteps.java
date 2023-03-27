package com.ingenious_build.qa_home_challenge.web_automation.steps.actions;

import com.ingenious_build.qa_home_challenge.web_automation.configuration.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingField;
import com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingStrategy;
import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import com.ingenious_build.qa_home_challenge.web_automation.pages.ProductsPage;
import com.ingenious_build.qa_home_challenge.web_automation.steps.AbstractStepClass;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static com.ingenious_build.qa_home_challenge.web_automation.enums.UiStorageKey.PRODUCTS_ADDED_TO_CART;
import static com.ingenious_build.qa_home_challenge.web_automation.enums.UiStorageKey.PRODUCTS_FROM_GRID;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductsPageSteps extends AbstractStepClass {

    ProductsPage productsPage;

    public ProductsPageSteps(ProductsPage productsPage, StepClassesDependencies dependencies) {
        super(dependencies);
        this.productsPage = productsPage;
    }

    @When("I add the following items to the cart:")
    public void iAddTheFollowingItemsToTheCart(List<String> itemsToAdd) {
        scenarioContext.addValue(PRODUCTS_ADDED_TO_CART, itemsToAdd);
        itemsToAdd.forEach(name -> productsPage.addProductsToCart(InventoryItemSearchCriteria.builder().name(name).build()));
    }

    @When("I go to the cart")
    public void iGoToTheCart() {
        productsPage.goToCart();
    }

    @When("I sort the items by {sortingField} {sortingStrategy}")
    public void iSortTheItems(SortingField sortingField, SortingStrategy sortingStrategy) {
        productsPage.sort(sortingField, sortingStrategy);
    }

    @When("I check the products grid")
    public void iCheckTheProductsGrid() {
        List<ProductDetails> productsFromGrid = productsPage.getProductsFromGrid();
        scenarioContext.addValue(PRODUCTS_FROM_GRID, productsFromGrid);
    }
}
