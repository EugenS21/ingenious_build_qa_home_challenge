package com.ingenious_build.qa_home_challenge.web_automation.core.model.item;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public abstract class Item {

    String name;
    String description;
    String price;

}
