package com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation;

import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.IAnchor;
import org.openqa.selenium.WebElement;

public class Anchor extends AbstractElement implements IAnchor {

    public Anchor(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        webElement.click();
    }

}
