package com.ingenious_build.qa_home_challenge.web_automation.steps.assertions;

import com.ingenious_build.qa_home_challenge.web_automation.enums.StorageKey;
import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import com.ingenious_build.qa_home_challenge.web_automation.model.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.pages.AbstractPage;
import com.ingenious_build.qa_home_challenge.web_automation.pages.CheckoutPage;
import com.ingenious_build.qa_home_challenge.web_automation.steps.AbstractAssertionsStepClass;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CartPageSteps extends AbstractAssertionsStepClass {

    CheckoutPage checkoutPage;

    @Autowired
    public CartPageSteps(CheckoutPage checkoutPage, StepClassesDependencies dependencies, SoftAssertions softAssertions) {
        super(dependencies, softAssertions);
        this.checkoutPage = checkoutPage;
    }

    @Then("I should see the items I added earlier")
    public void iShouldSeeTheItemsIAddedEarlier() {
        List<ProductDetails> allTheProductsFromGrid = scenarioContext.getListValue(StorageKey.PRODUCTS_FROM_GRID, ProductDetails.class);

    }

    @Then("I should validate that the items have been removed")
    public void iShouldValidateThatTheItemsHaveBeenRemoved() {

    }

    @Then("I should see the order confirmation")
    public void iShouldSeeTheOrderConfirmation() {

    }

    @Then("I should be redirected to checkout page")
    public void iShouldBeRedirectedToCheckoutPage() {
        softAssertions.assertThat(checkoutPage)
                .extracting(AbstractPage::getUrl)
                .describedAs("Expecting to be redirected on checkout page")
                .matches(el -> el.contains("cart"));
    }

}
