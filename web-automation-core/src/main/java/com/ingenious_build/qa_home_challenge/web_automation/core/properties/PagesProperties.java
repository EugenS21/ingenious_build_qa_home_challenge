package com.ingenious_build.qa_home_challenge.web_automation.core.properties;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.LoginPageProperties;
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

}
