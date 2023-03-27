package com.ingenious_build.qa_home_challenge.web_automation.core.driver.factory.type;

import com.ingenious_build.qa_home_challenge.web_automation.core.driver.factory.ConfigurableWebDriver;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.driver.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Edge implements ConfigurableWebDriver {

    @Getter
    WebDriverManager webDriverManager;
    @Getter
    EdgeOptions edgeOptions;

    @Autowired
    public Edge(WebDriverProperties properties) {
        this.edgeOptions = new EdgeOptions().addArguments(properties.getCapabilities());
        this.webDriverManager = WebDriverManager.chromedriver();
    }

    @Override
    public WebDriver get() {
        webDriverManager.setup();
        return new EdgeDriver(edgeOptions);
    }

}