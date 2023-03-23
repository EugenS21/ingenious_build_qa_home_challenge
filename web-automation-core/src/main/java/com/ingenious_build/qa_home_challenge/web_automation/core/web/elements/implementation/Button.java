package com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation;

import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.IButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button extends AbstractElement implements IButton {

    public Button(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        webElement.click();
    }
}
