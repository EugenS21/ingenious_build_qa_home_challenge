package com.ingenious_build.qa_home_challenge.web_automation.steps.assertions;

import com.ingenious_build.qa_home_challenge.web_automation.enums.StorageKey;
import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import com.ingenious_build.qa_home_challenge.web_automation.model.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.pages.AbstractPage;
import com.ingenious_build.qa_home_challenge.web_automation.pages.CheckoutInformationPage;
import com.ingenious_build.qa_home_challenge.web_automation.pages.CheckoutOverviewPage;
import com.ingenious_build.qa_home_challenge.web_automation.pages.CheckoutPage;
import com.ingenious_build.qa_home_challenge.web_automation.steps.AbstractAssertionsStepClass;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckoutPageSteps extends AbstractAssertionsStepClass {

    CheckoutPage checkoutPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;

    @Autowired
    public CheckoutPageSteps(CheckoutPage checkoutPage, CheckoutInformationPage checkoutInformationPage, CheckoutOverviewPage checkoutOverviewPage, StepClassesDependencies dependencies, SoftAssertions softAssertions) {
        super(dependencies, softAssertions);
        this.checkoutPage = checkoutPage;
        this.checkoutInformationPage = checkoutInformationPage;
        this.checkoutOverviewPage = checkoutOverviewPage;
    }

    @Then("I should see the items I added earlier")
    public void iShouldSeeTheItemsIAddedEarlier() {
        List<String> expectedProducts = scenarioContext.getListValue(StorageKey.PRODUCTS_ADDED_TO_CART, String.class);
        List<ProductDetails> actualProducts = checkoutPage.getCheckoutItems();
        softAssertions.assertThat(actualProducts)
                .filteredOn(product->expectedProducts.contains(product.getName()))
                .describedAs("Expecting to see only $s on checkout page", expectedProducts)
                .hasSameSizeAs(expectedProducts);
    }

    @Then("I should validate that the items have been removed")
    public void iShouldValidateThatTheItemsHaveBeenRemoved() {
        List<ProductDetails> actualItems = checkoutPage.getCheckoutItems();
        List<String> removedItems = scenarioContext.getListValue(StorageKey.PRODUCTS_REMOVED_FROM_CART, String.class);
        softAssertions.assertThat(actualItems)
                .extracting(ProductDetails::getName)
                .doesNotContainAnyElementsOf(removedItems);
    }

    @Then("I should see the order confirmation")
    public void iShouldSeeTheOrderConfirmation() {

    }

    @Then("I should be redirected to checkout page")
    public void iShouldBeRedirectedToCheckoutPage() {
        softAssertions.assertThat(checkoutPage)
                .extracting(AbstractPage::getUrl)
                .describedAs("Expecting to be redirected on checkout page")
                .matches(el -> el.equals(checkoutPage.getUrl()));
    }

    @Then("I should be redirected to overview page")
    public void iShouldBeRedirectedToOverviewPage() {
        softAssertions.assertThat(checkoutInformationPage)
                .extracting(AbstractPage::getUrl)
                .describedAs("Expecting to be redirected on checkout page")
                .matches(el -> el.equals(checkoutPage.getUrl()));
    }

    @Then("I should see the summary of items I ordered")
    public void iShouldSeeTheSummaryOfItemsIOrdered() {

    }
}
