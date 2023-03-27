package com.ingenious_build.qa_home_challenge.web_automation.core.model.item;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CartItemDetails extends Item {
}
