package com.ingenious_build.qa_home_challenge.web_automation.steps.actions;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.enums.StorageKey;
import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import com.ingenious_build.qa_home_challenge.web_automation.model.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.pages.CheckoutPage;
import com.ingenious_build.qa_home_challenge.web_automation.pages.ProductsPage;
import com.ingenious_build.qa_home_challenge.web_automation.steps.AbstractStepClass;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.ApplicationContext;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductsPageSteps extends AbstractStepClass {

    ProductsPage productsPage;

    public ProductsPageSteps(StepClassesDependencies dependencies) {
        super(dependencies);
        productsPage = new ProductsPage(pageLocators, webDriver);
    }


    @When("I add the following items to the cart:")
    public void iAddTheFollowingItemsToTheCart(List<String> itemsToAdd) {
        itemsToAdd.forEach(name -> productsPage.addItemsToCart(InventoryItemSearchCriteria.builder().name(name).build()));
    }

    @When("I go to the cart")
    public void iGoToTheCart() {
        productsPage.goToCart();
    }

}
