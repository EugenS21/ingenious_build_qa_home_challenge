package com.ingenious_build.qa_home_challenge.api_automation.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class GetUsersResponse {

    Integer page;
    @JsonProperty("per_page")
    Integer perPage;
    Integer total;
    @JsonProperty("total_pages")
    Integer totalPages;
    List<UserDto> data;

}