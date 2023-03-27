package com.ingenious_build.qa_home_challenge.api_automation.data_table_types;

import com.ingenious_build.qa_home_challenge.api_automation.model.User;
import io.cucumber.java.DataTableType;
import lombok.SneakyThrows;

import java.net.URL;
import java.util.Map;

public class UserType {

    @DataTableType
    @SneakyThrows
    public User getUser(Map<String, String> dataTable) {
        return User.builder()
                .id(Long.valueOf(dataTable.get("id")))
                .email(dataTable.get("email"))
                .firstName(dataTable.get("firstName"))
                .lastName(dataTable.get("lastName"))
                .avatar(new URL(dataTable.get("avatar")))
                .build();
    }

}
