package com.ingenious_build.qa_home_challenge.api_automation.steps.assertions;

import io.cucumber.java.en.Given;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RegistrationSteps {

    WebClient webClient;

    @Autowired
    public RegistrationSteps(WebClient webClient) {
        this.webClient = webClient;
    }


}
