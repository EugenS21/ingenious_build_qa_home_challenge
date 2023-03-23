package com.ingenious_build.qa_home_challenge.api_automation.steps;

import io.cucumber.java.en.Given;

public class ApiSteps {
    @Given("say hi api")
    public void sayHiApi() {
        System.out.println("Say hi from api");
    }
}
