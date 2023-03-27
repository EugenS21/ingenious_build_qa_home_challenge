package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Anchor;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Span;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ShoppingCart {

    Supplier<Anchor> anchor;
    Supplier<Span> badge;

    public void openCart() {
        anchor.get().click();
    }

    public Integer numberOfProductsAddedToCart() {
        return Integer.valueOf(badge.get().getText());
    }

}
