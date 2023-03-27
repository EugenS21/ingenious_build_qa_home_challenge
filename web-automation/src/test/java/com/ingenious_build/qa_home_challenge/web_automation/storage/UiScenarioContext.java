package com.ingenious_build.qa_home_challenge.web_automation.storage;

import com.ingenious_build.qa_home_challenge.testing_components.core.storage.ScenarioContext;
import com.ingenious_build.qa_home_challenge.web_automation.enums.UiStorageKey;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@ScenarioScope
@SuppressWarnings("all")
public class UiScenarioContext extends ScenarioContext<UiStorageKey> {
}
