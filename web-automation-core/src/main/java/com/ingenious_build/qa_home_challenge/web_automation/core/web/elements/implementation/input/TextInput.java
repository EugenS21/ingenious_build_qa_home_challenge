package com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.input;

import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.ITextInput;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.input.AbstractInput;
import org.openqa.selenium.WebElement;

public class TextInput extends AbstractInput implements ITextInput {

    public TextInput(WebElement webElement) {
        super(webElement);
    }

    @Override
    public String getContent() {
        return webElement.getText();
    }

}
