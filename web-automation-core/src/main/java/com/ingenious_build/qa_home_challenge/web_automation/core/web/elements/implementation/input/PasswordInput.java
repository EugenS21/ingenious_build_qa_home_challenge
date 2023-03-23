package com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.input;

import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.HidenInput;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.input.AbstractInput;
import org.openqa.selenium.WebElement;

public class PasswordInput extends AbstractInput implements HidenInput {

    public PasswordInput(WebElement webElement) {
        super(webElement);
    }

}
