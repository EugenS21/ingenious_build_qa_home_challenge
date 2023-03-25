package com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CheckOutOverviewPageProperties {

    String url;
    @NestedConfigurationProperty
    CheckoutOverviewItemsProperties items;
    @NestedConfigurationProperty
    CheckoutOverviewSummaryProperties summaryInfo;
    @NestedConfigurationProperty
    CheckoutOverviewFooterProperties footer;

}
