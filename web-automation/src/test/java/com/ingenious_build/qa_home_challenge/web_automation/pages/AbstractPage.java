package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;

@FieldDefaults(makeFinal = true, level = AccessLevel.PACKAGE)
@RequiredArgsConstructor
public abstract class AbstractPage {

    PagesProperties properties;
    WebDriver webDriver;

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

}
