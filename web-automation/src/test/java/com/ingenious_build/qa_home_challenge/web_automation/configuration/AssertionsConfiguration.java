package com.ingenious_build.qa_home_challenge.web_automation.configuration;

import io.cucumber.spring.ScenarioScope;
import lombok.Getter;
import org.assertj.core.api.SoftAssertions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssertionsConfiguration {

    @Getter(onMethod = @__({@Bean,@ScenarioScope}))
    SoftAssertions softAssertions;

    public AssertionsConfiguration() {
        softAssertions = new SoftAssertions();
    }

}
