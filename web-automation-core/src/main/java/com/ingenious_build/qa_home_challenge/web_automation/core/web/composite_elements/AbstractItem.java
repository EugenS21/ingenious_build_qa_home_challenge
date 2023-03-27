package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Anchor;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.TextBlock;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.function.Supplier;

@SuperBuilder(toBuilder = true)
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public class AbstractItem {

    Supplier<Anchor> name;
    Supplier<TextBlock> description;
    Supplier<TextBlock> price;

}
