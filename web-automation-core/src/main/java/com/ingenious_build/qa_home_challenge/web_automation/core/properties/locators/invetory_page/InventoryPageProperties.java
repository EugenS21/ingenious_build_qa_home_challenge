package com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.AbstractPageProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class InventoryPageProperties extends AbstractPageProperties {

    @NestedConfigurationProperty
    InventoryHeaderProperties header;
    @NestedConfigurationProperty
    InventoryBodyProperties body;

}
