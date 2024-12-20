package com.ingenious_build.qa_home_challenge.web_automation.data_table_type;

import com.ingenious_build.qa_home_challenge.web_automation.model.LoginDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;
public class LoginDetailsType {

    @DataTableType
    public LoginDetails getDetailsFromDataType(Map<String,String> dataTable) {
        return LoginDetails.builder()
                .username(dataTable.get("username"))
                .password(dataTable.get("password"))
                .build();
    }

}
