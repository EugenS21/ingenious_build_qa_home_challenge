package com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CheckOutCompleteContainerProperties {

    By header;
    By text;
    By backHome;

}
