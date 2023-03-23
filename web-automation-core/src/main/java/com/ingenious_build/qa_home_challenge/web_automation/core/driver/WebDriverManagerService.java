package com.ingenious_build.qa_home_challenge.web_automation.core.driver;

import com.ingenious_build.qa_home_challenge.web_automation.core.enums.DriverType;
import com.ingenious_build.qa_home_challenge.web_automation.core.exception.UnknownDriverException;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.WebAutomationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.vavr.control.Option;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ingenious_build.qa_home_challenge.web_automation.core.enums.DriverType.*;
import static io.vavr.API.*;
import static java.lang.String.format;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
@Slf4j
public class WebDriverManagerService {



    WebDriverManager manager;
    List<String> capabilitiesToAdd;
    @Getter (onMethod = @__(@Autowired))
    @NonFinal WebDriver webDriver;

    private WebDriverManager getManagerFromProperties(DriverType driver) {
        return Option.of(driver)
                .map(type -> Match(type).of(
                        Case($(FIREFOX), WebDriverManager::firefoxdriver),
                        Case($(EDGE), WebDriverManager::edgedriver),
                        Case($(CHROMIUM), WebDriverManager::chromiumdriver),
                        Case($(OPERA), WebDriverManager::operadriver),
                        Case($(SAFARI), WebDriverManager::safaridriver),
                        Case($(CHROME), WebDriverManager::chromedriver)
                ))
                .getOrElseThrow(() -> new UnknownDriverException(format("Unknown driver type [%s]", driver)));
    }

    private void addCapabilitiesToManager(List<String> capabilities) {

    }

    @Autowired
    public WebDriverManagerService(WebAutomationProperties automationProperties) {
        manager = getManagerFromProperties(automationProperties.getDriver().getType());
        capabilitiesToAdd = automationProperties.getDriver().getCapabilities();
    }

    @PostConstruct
    private void initializeWebDriver() {
        log.info("Initializing browser manager");
        manager.setup();
        addCapabilitiesToManager(capabilitiesToAdd);
    }

    public void openBrowser() {
        log.info("Opening browser");
        webDriver = manager.create();
    }

    public void closeBrowser() {
        Option.of(webDriver)
                .peek(manager -> log.info("CLosing browser {}", manager))
                .peek(WebDriver::quit)
                .onEmpty(() -> log.info("No need to close browser"));
    }

    @PreDestroy
    private void closeDriver() {
        Option.of(manager)
                .peek(manager -> log.info("CLosing browser manager {}", manager))
                .peek(WebDriverManager::quit)
                .onEmpty(() -> log.info("No need to close browser manager"));
    }

}
