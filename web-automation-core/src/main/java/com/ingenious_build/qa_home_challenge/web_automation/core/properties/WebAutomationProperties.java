package com.ingenious_build.qa_home_challenge.web_automation.core.properties;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.application.WebDriverProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.regex.Pattern;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
@ConfigurationProperties(prefix = "application")
public class WebAutomationProperties {

    String url;
    @NestedConfigurationProperty
    WebDriverProperties driver;

}
