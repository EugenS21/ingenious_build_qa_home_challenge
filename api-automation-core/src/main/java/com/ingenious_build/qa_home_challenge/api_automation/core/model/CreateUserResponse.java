package com.ingenious_build.qa_home_challenge.api_automation.core.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class CreateUserResponse {

    String name;
    String job;
    Long id;
    LocalDateTime createdAt;

}
