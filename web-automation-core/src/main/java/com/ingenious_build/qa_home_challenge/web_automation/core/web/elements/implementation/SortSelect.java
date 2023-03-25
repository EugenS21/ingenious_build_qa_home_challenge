package com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation;

import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.ISelect;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SortSelect implements ISelect {

    Select select;

    public SortSelect(WebElement select) {
        this.select = new Select(select);
    }

    @Override
    public List<String> getOptions() {
        return select.getOptions().stream()
                .map(WebElement::getText)
                .toList();
    }

    @Override
    public void selectOption(String option) {
        select.selectByVisibleText(option);
    }

}
