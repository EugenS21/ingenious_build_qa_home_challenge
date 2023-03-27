package com.ingenious_build.qa_home_challenge.api_automation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.net.URL;

@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class User {

    Long id;
    String email;
    String firstName;
    String lastName;
    URL avatar;

}
