package com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.AbstractDetails;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CheckoutInformationFormProperties extends AbstractDetails {

    By firstName;
    By lastName;
    By zipCode;
    By error;
    By doContinue;
    By cancel;

}
