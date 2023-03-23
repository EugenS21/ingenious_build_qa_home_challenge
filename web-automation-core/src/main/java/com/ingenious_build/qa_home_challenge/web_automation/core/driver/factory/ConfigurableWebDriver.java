package com.ingenious_build.qa_home_challenge.web_automation.core.driver.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;

public interface ConfigurableWebDriver {

    WebDriver get();

}
