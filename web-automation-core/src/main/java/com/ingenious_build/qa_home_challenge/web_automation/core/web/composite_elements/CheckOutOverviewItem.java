package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.ItemDetails;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CheckOutOverviewItem extends AbstractItem {

    public ItemDetails convert() {
        return ItemDetails.builder()
                .name(name.get().getText())
                .description(description.get().getContent())
                .price(price.get().getText())
                .build();
    }

}
