package com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation;

import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.Block;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBlock extends AbstractElement implements Block {

    public TextBlock(WebElement webElement) {
        super(webElement);
    }

    @Override
    public String getContent() {
        return webElement.getText();
    }
}
