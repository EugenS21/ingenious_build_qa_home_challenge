package com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.check_out_page.CheckOutCompleteContainerProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.Button;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.elements.implementation.TextBlock;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckOutCompleteContainer {

    Supplier<TextBlock> header;
    Supplier<TextBlock> text;
    Supplier<Button> backHome;

    public CheckOutCompleteContainer(CheckOutCompleteContainerProperties properties, WebDriver webDriver) {
        this.header = () -> new TextBlock(webDriver.findElement(properties.getHeader()));
        this.text = () -> new TextBlock(webDriver.findElement(properties.getText()));
        this.backHome = () -> new Button(webDriver.findElement(properties.getBackHome()));
    }

    public String getHeader() {
        return header.get().getContent();
    }

    public String getText() {
        return text.get().getContent();
    }

    public void getBackHome() {
        backHome.get().click();
    }

}
