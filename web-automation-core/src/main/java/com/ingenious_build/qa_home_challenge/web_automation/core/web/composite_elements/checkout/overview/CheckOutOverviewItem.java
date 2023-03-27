package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout.overview;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.item.ItemDetails;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.AbstractItem;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CheckOutOverviewItem extends AbstractItem<ItemDetails> {

    @Override
    public ItemDetails getData() {
        return ItemDetails.builder()
                .name(name.get().getText())
                .description(description.get().getContent())
                .price(price.get().getText())
                .build();
    }

}
