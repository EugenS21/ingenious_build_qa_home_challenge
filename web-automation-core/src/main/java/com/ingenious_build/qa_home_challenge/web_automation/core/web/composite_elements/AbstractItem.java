package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.item.Item;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Anchor;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.TextBlock;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.function.Supplier;

@SuperBuilder(toBuilder = true)
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
public abstract class AbstractItem<T extends Item> {

    Supplier<Anchor> name;
    Supplier<TextBlock> description;
    Supplier<TextBlock> price;

    public abstract T getData();

}
