package com.ingenious_build.qa_home_challenge.web_automation.core.model.item;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InventoryItemDetails extends Item {

    String imageSrc;

}
