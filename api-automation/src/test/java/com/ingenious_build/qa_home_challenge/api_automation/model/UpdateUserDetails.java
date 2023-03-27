package com.ingenious_build.qa_home_challenge.api_automation.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class UpdateUserDetails {

    String name;
    String job;

}
