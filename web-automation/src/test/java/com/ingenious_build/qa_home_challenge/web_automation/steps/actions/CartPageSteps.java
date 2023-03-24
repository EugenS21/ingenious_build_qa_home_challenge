package com.ingenious_build.qa_home_challenge.web_automation.steps.actions;

import com.ingenious_build.qa_home_challenge.web_automation.model.StepClassesDependencies;
import com.ingenious_build.qa_home_challenge.web_automation.steps.AbstractStepClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CartPageSteps extends AbstractStepClass {

    @Autowired
    public CartPageSteps(StepClassesDependencies dependencies) {
        super(dependencies);
    }

    @When("I remove the following items from the cart:")
    public void iRemoveTheFollowingItemsFromTheCart(DataTable dataTable) {

    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {

    }
}
