package com.ingenious_build.qa_home_challenge.web_automation.steps.assertions;

import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.InventoryItem;
import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import com.ingenious_build.qa_home_challenge.web_automation.model.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.pages.ProductsPage;
import com.ingenious_build.qa_home_challenge.web_automation.steps.AbstractAssertionsStepClass;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.ingenious_build.qa_home_challenge.web_automation.enums.StorageKey.PRODUCTS_FROM_GRID;
import static com.ingenious_build.qa_home_challenge.web_automation.utils.TestUtils.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductsPageSteps extends AbstractAssertionsStepClass {

    ProductsPage productsPage;

    @Autowired
    public ProductsPageSteps(ProductsPage productsPage, StepClassesDependencies dependencies, SoftAssertions softAssertions) {
        super(dependencies, softAssertions);
        this.productsPage = productsPage;
    }

    @Then("I should see the following items on the page:")
    public void iShouldSeeTheFollowingItemsOnThePage(List<ProductDetails> expectedProducts) {
        List<ProductDetails> actualProducts = productsPage.getProductsFromGrid().stream()
                .map(InventoryItem::convert)
                .map(inventoryItemDetails -> modelMapper.map(inventoryItemDetails, ProductDetails.class).toBuilder()
                        .price(getMonetaryAmountFromString.apply(inventoryItemDetails.getPrice()))
                        .build())
                .toList();
        scenarioContext.addValue(PRODUCTS_FROM_GRID, actualProducts);
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
