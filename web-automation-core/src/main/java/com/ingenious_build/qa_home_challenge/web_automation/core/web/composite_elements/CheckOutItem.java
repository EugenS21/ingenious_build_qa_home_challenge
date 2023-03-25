package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.CheckOutItemDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Anchor;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.TextBlock;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.WebImage;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.function.Supplier;

@Getter
@SuperBuilder
public class CheckOutItem extends AbstractItem {

    Supplier<Button> removeFromCart;

    public void removeFromCart() {
        removeFromCart.get().click();
    }

    public CheckOutItemDetails convert() {
        return CheckOutItemDetails.builder()
                .name(name.get().getText())
                .description(description.get().getContent())
                .price(price.get().getText())
                .build();
    }

}
