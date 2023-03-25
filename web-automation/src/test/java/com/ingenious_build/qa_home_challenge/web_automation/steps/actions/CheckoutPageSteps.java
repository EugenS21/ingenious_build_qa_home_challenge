package com.ingenious_build.qa_home_challenge.web_automation.steps.actions;

import com.github.javafaker.Faker;
import com.ingenious_build.qa_home_challenge.web_automation.core.model.ItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.model.CheckoutInformation;
import com.ingenious_build.qa_home_challenge.web_automation.model.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.pages.CheckoutInformationPage;
import com.ingenious_build.qa_home_challenge.web_automation.pages.CheckoutOverviewPage;
import com.ingenious_build.qa_home_challenge.web_automation.pages.CheckoutPage;
import com.ingenious_build.qa_home_challenge.web_automation.steps.AbstractStepClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.ingenious_build.qa_home_challenge.web_automation.enums.StorageKey.PRODUCTS_REMOVED_FROM_CART;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckoutPageSteps extends AbstractStepClass {

    CheckoutPage checkoutPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    Faker faker;

    @Autowired
    public CheckoutPageSteps(CheckoutPage checkoutPage, CheckoutInformationPage checkoutInformationPage, CheckoutOverviewPage checkoutOverviewPage, Faker faker, StepClassesDependencies dependencies) {
        super(dependencies);
        this.checkoutPage = checkoutPage;
        this.checkoutInformationPage = checkoutInformationPage;
        this.checkoutOverviewPage = checkoutOverviewPage;
        this.faker = faker;

    }

    @When("I remove the following items from the cart:")
    public void iRemoveTheFollowingItemsFromTheCart(List<String> itemsToRemove) {
        scenarioContext.addValue(PRODUCTS_REMOVED_FROM_CART, itemsToRemove);
        itemsToRemove.forEach(name -> checkoutPage.removeItemFromCart(ItemSearchCriteria.builder().name(name).build()));
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        checkoutPage.checkout();
    }

    @When("I fill in my checkout information")
    public void iFillInMyCheckoutInformation() {
        CheckoutInformation checkoutInformation = CheckoutInformation.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .zipCode(faker.address().zipCode())
                .build();
        checkoutInformationPage.fillInformationForm(checkoutInformation);
    }

    @When("I continue checkout process")
    public void iContinueCheckoutProcess() {
        checkoutInformationPage.doContinue();
    }

    @When("I review my orders details")
    public void iReviewMyOrdersDetails() {

    }

    @When("I finish the checkout process")
    public void iFinishTheCheckoutProcess() {
        checkoutOverviewPage.finish();
    }

}