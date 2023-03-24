package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Anchor;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.TextBlock;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.WebImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Data
public class InventoryItem {

    Supplier<WebImage> webImage;
    Supplier<Anchor> name;
    Supplier<TextBlock> description;
    Supplier<TextBlock> price;
    Supplier<Button> addToCart;

    public void addToCart() {
        addToCart.get().click();
    }

    public InventoryItemDetails convert() {
        return InventoryItemDetails.builder()
                .imageSrc(webImage.get().getSrc())
                .name(name.get().getText())
                .description(description.get().getContent())
                .price(price.get().getText())
                .build();
    }

}
