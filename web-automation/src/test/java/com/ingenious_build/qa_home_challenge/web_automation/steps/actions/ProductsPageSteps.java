package com.ingenious_build.qa_home_challenge.web_automation.steps.actions;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.ItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.model.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.pages.ProductsPage;
import com.ingenious_build.qa_home_challenge.web_automation.steps.AbstractStepClass;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static com.ingenious_build.qa_home_challenge.web_automation.enums.StorageKey.PRODUCTS_ADDED_TO_CART;

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
        itemsToAdd.forEach(name -> productsPage.addItemsToCart(ItemSearchCriteria.builder().name(name).build()));
    }

    @When("I go to the cart")
    public void iGoToTheCart() {
        productsPage.goToCart();
    }

}
