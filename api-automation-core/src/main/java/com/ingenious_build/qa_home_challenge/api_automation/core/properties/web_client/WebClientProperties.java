package com.ingenious_build.qa_home_challenge.api_automation.core.properties.web_client;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class WebClientProperties {

    Integer timeout;
    String baseUrl;
    Integer maxInMemorySize;

}
