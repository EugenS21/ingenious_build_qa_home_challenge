package com.ingenious_build.qa_home_challenge.api_automation.storage;

import com.ingenious_build.qa_home_challenge.api_automation.enums.ApiStorageKey;
import com.ingenious_build.qa_home_challenge.testing_components.core.storage.ScenarioContext;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@ScenarioScope(proxyMode = ScopedProxyMode.NO)
public class ApiScenarioContext extends ScenarioContext<ApiStorageKey> {
}
