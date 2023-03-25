package com.ingenious_build.qa_home_challenge.web_automation.steps.assertions;

import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import com.ingenious_build.qa_home_challenge.web_automation.model.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.pages.AbstractPage;
import com.ingenious_build.qa_home_challenge.web_automation.pages.ProductsPage;
import com.ingenious_build.qa_home_challenge.web_automation.steps.AbstractAssertionsStepClass;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductsPageSteps extends AbstractAssertionsStepClass {

    ProductsPage productsPage;

    @Autowired
    public ProductsPageSteps(ProductsPage productsPage, StepClassesDependencies dependencies, SoftAssertions softAssertions) {
        super(dependencies, softAssertions);
        this.productsPage = productsPage;
    }

    @Then("I should be redirected to products page")
    public void iShouldBeRedirectedToProductsPage() {
        softAssertions.assertThat(productsPage)
                .extracting(AbstractPage::getActualUrl)
                .describedAs("Expecting to be redirected to inventory page")
                .isEqualTo(productsPage.getExpectedUrl());
    }

    @Then("I should see the following items on the page:")
    public void iShouldSeeTheFollowingItemsOnThePage(List<ProductDetails> expectedProducts) {
        List<ProductDetails> actualProducts = productsPage.getProductsFromGrid();
        softAssertions.assertThat(expectedProducts)
                .describedAs("Expecting the following products <%s> on grid", expectedProducts)
                .containsExactlyElementsOf(actualProducts);
    }


    @Then("I should see '{int}' items added to cart")
    public void iShouldSeeItemsAddedToCart(int expectedProductsNumber) {
        softAssertions.assertThat(productsPage.getNumberOfProductsAddedToCard())
                .describedAs("Expecting <%d> products added in cart", expectedProductsNumber)
                .isEqualTo(expectedProductsNumber);
    }

}
