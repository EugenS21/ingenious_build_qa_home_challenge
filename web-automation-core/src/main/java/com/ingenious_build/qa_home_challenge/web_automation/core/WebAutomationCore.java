package com.ingenious_build.qa_home_challenge.web_automation.core;

import com.ingenious_build.qa_home_challenge.common_tools.FrameworkConfig;
import com.ingenious_build.qa_home_challenge.common_tools.properties.processor.CustomYamlProcessor;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.WebAutomationProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.driver.WebDriverProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.invetory_page.InventoryPageProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.locators.login_page.LoginPageProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@Import(FrameworkConfig.class)
@ComponentScan(basePackages = "com.ingenious_build.qa_home_challenge.web_automation")
@Configuration
@EnableConfigurationProperties({WebAutomationProperties.class, PagesProperties.class})
@PropertySources({
        @PropertySource(value = "classpath:driver-configurations.yml", factory = CustomYamlProcessor.class),
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
    public InventoryPageProperties inventoryPageProperties() {
        return pagesProperties.getInventory();
    }

    @Bean
    public WebDriverProperties webDriverProperties() {
        return webAutomationProperties.getDriver();
    }

}