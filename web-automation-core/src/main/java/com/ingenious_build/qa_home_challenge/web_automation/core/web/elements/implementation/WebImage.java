package com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation;

import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.Image;
import org.openqa.selenium.WebElement;

public class WebImage extends AbstractElement implements Image {

    public WebImage(WebElement webElement) {
        super(webElement);
    }

    @Override
    public String getSrc() {
        return webElement.getAttribute("src");
    }

}

