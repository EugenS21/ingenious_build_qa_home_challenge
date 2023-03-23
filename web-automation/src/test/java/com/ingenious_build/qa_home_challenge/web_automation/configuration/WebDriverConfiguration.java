package com.ingenious_build.qa_home_challenge.web_automation.configuration;

import com.ingenious_build.qa_home_challenge.web_automation.core.driver.factory.WebDriversFactory;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfiguration {

    @Bean
    @ScenarioScope
    public WebDriver webDriver(WebDriversFactory webDriversFactory){
        return webDriversFactory.create().get();
    }

}
