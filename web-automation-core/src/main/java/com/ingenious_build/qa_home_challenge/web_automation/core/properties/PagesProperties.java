package com.ingenious_build.qa_home_challenge.web_automation.core.properties;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutCompletePageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutInformationPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutOverviewPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page.InventoryPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.login_page.LoginPageProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@ConfigurationProperties(prefix = "pages")
public class PagesProperties {

    @NestedConfigurationProperty
    LoginPageProperties login;
    @NestedConfigurationProperty
    InventoryPageProperties inventory;
    @NestedConfigurationProperty
    CheckOutPageProperties checkOut;
    @NestedConfigurationProperty
    CheckOutInformationPageProperties checkOutInformation;
    @NestedConfigurationProperty
    CheckOutOverviewPageProperties checkOutOverview;
    @NestedConfigurationProperty
    CheckOutCompletePageProperties checkOutComplete;

}
