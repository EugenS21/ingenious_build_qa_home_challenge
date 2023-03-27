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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Firefox implements ConfigurableWebDriver {

    @Getter
    WebDriverManager webDriverManager;
    @Getter
    FirefoxOptions firefoxOptions;

    @Autowired
    public Firefox(WebDriverProperties properties) {
        this.firefoxOptions = new FirefoxOptions().addArguments(properties.getCapabilities());
        this.webDriverManager = WebDriverManager.chromedriver();
    }

    @Override
    public WebDriver get() {
        webDriverManager.setup();
        return new FirefoxDriver(firefoxOptions);
    }

}
