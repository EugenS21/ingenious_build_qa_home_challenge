package com.ingenious_build.qa_home_challenge.web_automation.core.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public abstract class AbstractPageProperties {

    String url;

}
