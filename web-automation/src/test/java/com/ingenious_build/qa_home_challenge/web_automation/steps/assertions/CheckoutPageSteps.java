package com.ingenious_build.qa_home_challenge.web_automation.steps.assertions;

import com.ingenious_build.qa_home_challenge.web_automation.configuration.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.enums.UiStorageKey;
import com.ingenious_build.qa_home_challenge.web_automation.model.MonetaryAmount;
import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import com.ingenious_build.qa_home_challenge.web_automation.pages.*;
import com.ingenious_build.qa_home_challenge.web_automation.steps.AbstractAssertionsStepClass;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.ingenious_build.qa_home_challenge.web_automation.enums.UiStorageKey.PRODUCTS_ADDED_TO_CART;
import static com.ingenious_build.qa_home_challenge.web_automation.enums.UiStorageKey.PRODUCTS_FROM_OVERVIEW_PAGE;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckoutPageSteps extends AbstractAssertionsStepClass {

    CartPage cartPage;
    CheckoutCompletePage checkoutCompletePage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;

    @Autowired
    public CheckoutPageSteps(CartPage cartPage, CheckoutCompletePage checkoutCompletePage, CheckoutInformationPage checkoutInformationPage, CheckoutOverviewPage checkoutOverviewPage, StepClassesDependencies dependencies, SoftAssertions softAssertions) {
        super(dependencies, softAssertions);
        this.cartPage = cartPage;
        this.checkoutCompletePage = checkoutCompletePage;
        this.checkoutInformationPage = checkoutInformationPage;
        this.checkoutOverviewPage = checkoutOverviewPage;
    }

    @Then("I should see the items I added earlier")
    public void iShouldSeeTheItemsIAddedEarlier() {
        List<String> expectedProducts = scenarioContext.getListValue(UiStorageKey.PRODUCTS_ADDED_TO_CART, String.class);
        List<ProductDetails> actualProducts = cartPage.getCheckoutProducts();
        softAssertions.assertThat(actualProducts)
                .filteredOn(product -> expectedProducts.contains(product.getName()))
                .describedAs("Expecting to see only $s on checkout page", expectedProducts)
                .hasSameSizeAs(expectedProducts);
    }

    @Then("I should validate that the items have been removed")
    public void iShouldValidateThatTheItemsHaveBeenRemoved() {
        List<ProductDetails> actualItems = cartPage.getCheckoutProducts();
        List<String> removedItems = scenarioContext.getListValue(UiStorageKey.PRODUCTS_REMOVED_FROM_CART, String.class);
        softAssertions.assertThat(actualItems)
                .extracting(ProductDetails::getName)
                .doesNotContainAnyElementsOf(removedItems);
        scenarioContext.addValue(UiStorageKey.PRODUCTS_ADDED_TO_CART, actualItems);
    }

    @Then("I should see the order confirmation as follows:")
    public void iShouldSeeTheOrderConfirmation(List<String> actualMessages) {
        softAssertions.assertThat(actualMessages)
                .describedAs("Expecting messages <%s> to be showed", actualMessages)
                .containsExactlyInAnyOrderElementsOf(List.of(checkoutCompletePage.getHeader(), checkoutCompletePage.getText()));
    }

    @Then("I should be redirected to checkout page")
    public void iShouldBeRedirectedToCheckoutPage() {
        softAssertions.assertThat(cartPage)
                .extracting(AbstractPage::getActualUrl)
                .describedAs("Expecting to be redirected on checkout page")
                .matches(el -> el.equals(cartPage.getExpectedUrl()));
    }

    @Then("I should be redirected to overview page")
    public void iShouldBeRedirectedToOverviewPage() {
        softAssertions.assertThat(checkoutOverviewPage)
                .extracting(AbstractPage::getActualUrl)
                .describedAs("Expecting to be redirected on checkout page")
                .matches(el -> el.equals(checkoutOverviewPage.getExpectedUrl()));
    }

    @Then("I should see the summary of items I ordered")
    public void iShouldSeeTheSummaryOfItemsIOrdered() {
        List<ProductDetails> expectedResults = scenarioContext.getListValue(PRODUCTS_ADDED_TO_CART, ProductDetails.class);
        List<ProductDetails> actualResults = scenarioContext.getListValue(PRODUCTS_FROM_OVERVIEW_PAGE, ProductDetails.class);
        softAssertions.assertThat(actualResults)
                .describedAs("Expecting the same list of products I ordered")
                .containsExactlyInAnyOrderElementsOf(expectedResults);
    }

    @Then("I should confirm that my payment information is correct")
    public void iShouldConfirmThatMyPaymentInformationIsCorrect() {
        softAssertions.assertThat(checkoutOverviewPage.getPaymentInfo())
                .describedAs("Expecting valid payment information")
                .matches("SauceCard #\\d+");
    }

    @Then("I should be redirected to checkout information page")
    public void iShouldBeRedirectedToCheckoutInformationPage() {
        softAssertions.assertThat(checkoutInformationPage)
                .extracting(AbstractPage::getActualUrl)
                .describedAs("Expecting to be redirected on checkout page")
                .matches(el -> el.equals(checkoutInformationPage.getExpectedUrl()));
    }

    @Then("I should verify that my shipping information is correct")
    public void iShouldVerifyThatMyShippingInformationIsCorrect() {
        softAssertions.assertThat(checkoutOverviewPage.getShippingInfo())
                .describedAs("Expecting valid shipping information")
                .containsAnyOf("Delivery", "Express");
    }

    @Then("I should confirm that I am charged the correct price for my items")
    public void iShouldConfirmThatIAmChargedTheCorrectPriceForMyItems() {
        AtomicReference<Currency> currency = new AtomicReference<>();
        BigDecimal expectedProductsTotalPrice = scenarioContext.getListValue(PRODUCTS_ADDED_TO_CART, ProductDetails.class).stream()
                .peek(el -> currency.set(el.getPrice().getCurrency()))
                .map(ProductDetails::getPrice)
                .map(MonetaryAmount::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        softAssertions.assertThat(checkoutOverviewPage.getProductTotalPrice())
                .describedAs("Expecting correct amount of money to pay for ordered items")
                .usingComparatorForType(BigDecimal::compareTo, BigDecimal.class)
                .satisfies(totalPrice -> {
                    softAssertions.assertThat(totalPrice.getAmount()).usingComparatorForType(BigDecimal::compareTo, BigDecimal.class).isEqualTo(expectedProductsTotalPrice);
                    softAssertions.assertThat(totalPrice.getCurrency()).isEqualTo(currency.get());
                });
        softAssertions.assertThat(checkoutOverviewPage.getProductTotalPrice())
                .describedAs("Expecting the sum of items price and tax to be equal to total price")
                .extracting(price -> price.sum(checkoutOverviewPage.getTax()))
                .isEqualTo(checkoutOverviewPage.getTotalPrice());
    }

    @Then("I should be redirected to checkout complete page")
    public void iShouldBeRedirectedToCheckoutCompletePage() {
        softAssertions.assertThat(checkoutCompletePage)
                .extracting(AbstractPage::getActualUrl)
                .describedAs("Expecting to be redirected on checkout page")
                .matches(el -> el.equals(checkoutCompletePage.getExpectedUrl()));
    }

}
