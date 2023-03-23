package com.ingenious_build.qa_home_challenge.web_automation.core.driver.factory;

import com.ingenious_build.qa_home_challenge.web_automation.core.driver.factory.type.Chrome;
import com.ingenious_build.qa_home_challenge.web_automation.core.enums.DriverType;
import com.ingenious_build.qa_home_challenge.web_automation.core.exception.UnknownDriverException;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.application.WebDriverProperties;
import io.vavr.control.Option;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import static com.ingenious_build.qa_home_challenge.web_automation.core.enums.DriverType.CHROME;
import static io.vavr.API.*;
import static java.lang.String.format;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WebDriversFactory {

    WebDriverProperties driverProperties;

    public ConfigurableWebDriver create() {
        DriverType type = driverProperties.getType();
        return Option.of(type)
                .map(typeEnum -> Match(typeEnum).of(
//                        Case($(FIREFOX), WebDriverManager::firefoxdriver),
//                        Case($(EDGE), WebDriverManager::edgedriver),
//                        Case($(CHROMIUM), WebDriverManager::chromiumdriver),
//                        Case($(OPERA), WebDriverManager::operadriver),
//                        Case($(SAFARI), WebDriverManager::safaridriver),
                        Case($(CHROME), new Chrome(driverProperties))
                ))
                .getOrElseThrow(() -> new UnknownDriverException(format("Unknown driver type [%s]", type)));
    }

}
