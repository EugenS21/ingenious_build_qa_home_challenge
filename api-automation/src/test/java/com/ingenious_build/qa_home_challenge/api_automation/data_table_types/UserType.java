package com.ingenious_build.qa_home_challenge.api_automation.data_table_types;

import com.ingenious_build.qa_home_challenge.api_automation.model.UpdateUserDetails;
import io.cucumber.java.DataTableType;
import lombok.SneakyThrows;

import java.util.Map;

public class UserType extends AbstractUserType {

    @DataTableType
    @SneakyThrows
    public UpdateUserDetails getUser(Map<String, String> dataTable) {
        return UpdateUserDetails.builder()
                .name(generateRandomDataIfNeeded(dataTable.get("name")))
                .job(generateRandomDataIfNeeded(dataTable.get("job")))
                .build();
    }

}