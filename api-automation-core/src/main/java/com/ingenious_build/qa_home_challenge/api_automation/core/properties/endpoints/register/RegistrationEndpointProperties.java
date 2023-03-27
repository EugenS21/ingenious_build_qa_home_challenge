package com.ingenious_build.qa_home_challenge.api_automation.core.properties.endpoints.register;

import com.ingenious_build.qa_home_challenge.api_automation.core.properties.endpoints.AbstractEndpoint;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class RegistrationEndpointProperties extends AbstractEndpoint {
}
