package com.ingenious_build.qa_home_challenge.api_automation.core.properties;

import com.ingenious_build.qa_home_challenge.api_automation.core.properties.web_client.WebClientProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
@ConfigurationProperties(prefix = "application")
public class ApiApplicationProperties {

    @NestedConfigurationProperty
    WebClientProperties webClient;

}
