package com.ingenious_build.qa_home_challenge.api_automation.configuration;

import com.ingenious_build.qa_home_challenge.api_automation.core.ApiAutomationApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.assertj.core.api.SoftAssertions;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {ApiAutomationApplication.class, SoftAssertions.class})
public class ApiAutomationComponentConfig {}
