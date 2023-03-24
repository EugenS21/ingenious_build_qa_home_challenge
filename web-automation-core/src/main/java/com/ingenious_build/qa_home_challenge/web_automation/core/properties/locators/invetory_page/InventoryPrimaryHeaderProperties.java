package com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.AbstractDetails;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class InventoryPrimaryHeaderProperties extends AbstractDetails {

    By menu;
    @NestedConfigurationProperty
    ShoppingCartProperties cart;

}