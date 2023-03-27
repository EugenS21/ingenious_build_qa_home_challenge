package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.item.CartItemDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.AbstractItem;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.function.Supplier;

@Getter
@SuperBuilder
public class CartItem extends AbstractItem<CartItemDetails> {

    Supplier<Button> removeFromCart;

    public void removeFromCart() {
        removeFromCart.get().click();
    }

    @Override
    public CartItemDetails getData() {
        return CartItemDetails.builder()
                .name(name.get().getText())
                .description(description.get().getContent())
                .price(price.get().getText())
                .build();
    }

}
