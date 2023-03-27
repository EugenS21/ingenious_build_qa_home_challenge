package com.ingenious_build.qa_home_challenge.api_automation.data_table_types;

import com.github.javafaker.Faker;
import com.ingenious_build.qa_home_challenge.api_automation.model.CreateUserDetails;
import com.ingenious_build.qa_home_challenge.api_automation.model.UpdateUserDetails;
import io.cucumber.java.DataTableType;
import lombok.SneakyThrows;

import java.net.URL;
import java.util.Map;

public class CreateUserType extends AbstractUserType {

    @DataTableType
    @SneakyThrows
    public CreateUserDetails getUser(Map<String, String> dataTable) {
        Faker faker = new Faker();
        return CreateUserDetails.builder()
                .name(generateRandomDataIfNeeded(dataTable.get("name")))
                .job(generateRandomDataIfNeeded(dataTable.get("job")))
                .build();
    }


}
