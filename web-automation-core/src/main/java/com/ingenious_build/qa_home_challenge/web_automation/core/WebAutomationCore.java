package com.ingenious_build.qa_home_challenge.web_automation.core;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.application.WebDriverProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.processor.CustomYamlProcessor;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.LoginPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.WebAutomationProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@ComponentScan(basePackages = {
        "com.ingenious_build.qa_home_challenge.web_automation",
        "com.ingenious_build.qa_home_challenge.common_tools.config"
})
@Configuration
@EnableConfigurationProperties({WebAutomationProperties.class, PagesProperties.class})
@PropertySources({
        @PropertySource(value = "classpath:application.yml", factory = CustomYamlProcessor.class),
        @PropertySource(value = "classpath:locators.yml", factory = CustomYamlProcessor.class)
})
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WebAutomationCore {

    PagesProperties pagesProperties;
    WebAutomationProperties webAutomationProperties;

    @Bean
    public LoginPageProperties homePageProperties() {
        return pagesProperties.getLogin();
    }

    @Bean
    public WebDriverProperties webDriverProperties() {
        return webAutomationProperties.getDriver();
    }

}