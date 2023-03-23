package com.ingenious_build.qa_home_challenge.web_automation.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@Builder(toBuilder = true)
@FieldNameConstants
public class LoginDetails {

    String username;
    String password;

}
