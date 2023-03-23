package com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.input;

import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.Input;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.AbstractElement;
import org.openqa.selenium.WebElement;

public abstract class AbstractInput extends AbstractElement implements Input {

    public AbstractInput(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        webElement.sendKeys(value);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

}
