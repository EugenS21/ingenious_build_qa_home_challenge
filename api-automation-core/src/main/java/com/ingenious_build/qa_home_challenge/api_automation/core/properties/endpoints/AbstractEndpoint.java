package com.ingenious_build.qa_home_challenge.api_automation.core.properties.endpoints;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public abstract class AbstractEndpoint {

    String path;

}
