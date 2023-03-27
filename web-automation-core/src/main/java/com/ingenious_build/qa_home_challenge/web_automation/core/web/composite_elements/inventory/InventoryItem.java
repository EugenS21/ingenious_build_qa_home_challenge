package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.inventory;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.item.InventoryItemDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.AbstractItem;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.WebImage;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.function.Supplier;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class InventoryItem extends AbstractItem<InventoryItemDetails> {

    Supplier<WebImage> webImage;
    Supplier<Button> addToCart;

    public void addToCart() {
        addToCart.get().click();
    }

    @Override
    public InventoryItemDetails getData() {
        return InventoryItemDetails.builder()
                .imageSrc(webImage.get().getSrc())
                .name(name.get().getText())
                .description(description.get().getContent())
                .price(price.get().getText())
                .build();
    }

}
