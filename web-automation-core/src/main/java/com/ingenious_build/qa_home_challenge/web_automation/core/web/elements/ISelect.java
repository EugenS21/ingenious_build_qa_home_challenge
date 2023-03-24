package com.ingenious_build.qa_home_challenge.web_automation.core.web.elements;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface ISelect {

    List<String> getOptions();
    void selectOption(String option);

}
