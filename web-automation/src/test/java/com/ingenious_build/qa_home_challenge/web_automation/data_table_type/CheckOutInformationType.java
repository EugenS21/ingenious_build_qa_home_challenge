package com.ingenious_build.qa_home_challenge.web_automation.data_table_type;

import com.ingenious_build.qa_home_challenge.web_automation.model.CheckoutInformation;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CheckOutInformationType {

    @DataTableType
    public CheckoutInformation getDetailsFromDataType(Map<String, String> dataTable) {
        return CheckoutInformation.builder()
                .lastName(dataTable.get("lastName"))
                .firstName(dataTable.get("firstName"))
                .zipCode(dataTable.get("zipCode"))
                .build();
    }

}
