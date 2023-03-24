package com.ingenious_build.qa_home_challenge.web_automation.core.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;


@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@EqualsAndHashCode(exclude = {"password"})
@FieldNameConstants
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class LoginFormDetails {

    String username;
    String password;
    String errorMessage;

}
