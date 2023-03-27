package com.ingenious_build.qa_home_challenge.web_automation.configuration;

import com.ingenious_build.qa_home_challenge.testing_components.core.storage.ScenarioContext;
import com.ingenious_build.qa_home_challenge.web_automation.core.WebAutomationCore;
import com.ingenious_build.qa_home_challenge.web_automation.enums.UiStorageKey;
import io.cucumber.spring.CucumberContextConfiguration;
import org.assertj.core.api.SoftAssertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = {WebAutomationCore.class, SoftAssertions.class})
public class WebAutomationComponentConfig {}
