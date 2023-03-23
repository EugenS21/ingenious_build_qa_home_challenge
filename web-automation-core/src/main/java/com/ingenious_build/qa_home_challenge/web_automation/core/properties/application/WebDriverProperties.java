package com.ingenious_build.qa_home_challenge.web_automation.core.properties.application;

import com.ingenious_build.qa_home_challenge.web_automation.core.enums.DriverType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class WebDriverProperties {

    DriverType type;
    List<String> capabilities;

}
