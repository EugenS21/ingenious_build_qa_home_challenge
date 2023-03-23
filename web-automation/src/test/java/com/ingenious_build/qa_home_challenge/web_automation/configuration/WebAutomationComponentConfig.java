package com.ingenious_build.qa_home_challenge.web_automation.configuration;

import com.ingenious_build.qa_home_challenge.web_automation.core.WebAutomationCore;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = WebAutomationCore.class)
public class WebAutomationComponentConfig {}
