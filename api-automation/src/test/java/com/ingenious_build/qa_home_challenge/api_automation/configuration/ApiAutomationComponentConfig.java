package com.ingenious_build.qa_home_challenge.api_automation.configuration;

import com.ingenious_build.qa_home_challenge.api_automation.ApiAutomationApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = ApiAutomationApplication.class)
public class ApiAutomationComponentConfig {}
