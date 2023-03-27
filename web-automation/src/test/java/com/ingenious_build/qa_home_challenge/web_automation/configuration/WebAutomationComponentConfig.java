package com.ingenious_build.qa_home_challenge.web_automation.configuration;

import com.ingenious_build.qa_home_challenge.web_automation.core.WebAutomationCore;
import io.cucumber.spring.CucumberContextConfiguration;
import org.assertj.core.api.SoftAssertions;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {WebAutomationCore.class, SoftAssertions.class})
public class WebAutomationComponentConfig {}
