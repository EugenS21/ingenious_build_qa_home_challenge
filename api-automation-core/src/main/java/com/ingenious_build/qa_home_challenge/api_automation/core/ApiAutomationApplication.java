package com.ingenious_build.qa_home_challenge.api_automation.core;

import com.ingenious_build.qa_home_challenge.api_automation.core.properties.ApiApplicationProperties;
import com.ingenious_build.qa_home_challenge.api_automation.core.properties.EndpointProperties;
import com.ingenious_build.qa_home_challenge.api_automation.core.properties.endpoints.users.UserEndpointProperties;
import com.ingenious_build.qa_home_challenge.api_automation.core.properties.web_client.WebClientProperties;
import com.ingenious_build.qa_home_challenge.common_tools.FrameworkConfig;
import com.ingenious_build.qa_home_challenge.common_tools.properties.processor.CustomYamlProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@Import(FrameworkConfig.class)
@Configuration
@ComponentScan(
        basePackages = "com.ingenious_build.qa_home_challenge.api_automation"
)
@EnableConfigurationProperties({EndpointProperties.class, ApiApplicationProperties.class})
@PropertySources({
        @PropertySource(value = "classpath:web-client-config.yml", factory = CustomYamlProcessor.class),
        @PropertySource(value = "classpath:endpoints.yml", factory = CustomYamlProcessor.class)
})
public class ApiAutomationApplication {

    @Autowired
    ApiApplicationProperties apiApplicationProperties;
    @Autowired
    EndpointProperties endpointProperties;

    @Bean
    public WebClientProperties webClientProperties() {
        return apiApplicationProperties.getWebClient();
    }

    @Bean
    public UserEndpointProperties userEndpointProperties() {
        return endpointProperties.getUsers();
    }


}
