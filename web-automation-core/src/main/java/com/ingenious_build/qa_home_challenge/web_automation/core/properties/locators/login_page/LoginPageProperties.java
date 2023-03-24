package com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.login_page;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults (level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class LoginPageProperties {

    String url;
    @NestedConfigurationProperty
    LoginFormProperties form;

}
