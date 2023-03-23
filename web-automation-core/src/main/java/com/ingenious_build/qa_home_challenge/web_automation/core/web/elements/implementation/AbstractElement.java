package com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class AbstractElement {

    WebElement webElement;

    public AbstractElement(WebElement webElement) {
        this.webElement = webElement;
    }

}
