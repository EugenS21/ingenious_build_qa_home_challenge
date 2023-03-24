package com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public abstract class AbstractDetails {

    String self;
    By bySelf;

}
