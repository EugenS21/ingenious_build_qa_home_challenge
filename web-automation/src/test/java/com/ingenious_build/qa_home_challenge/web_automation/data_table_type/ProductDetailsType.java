package com.ingenious_build.qa_home_challenge.web_automation.data_table_type;

import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import com.ingenious_build.qa_home_challenge.web_automation.utils.TestUtils;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class ProductDetailsType {

    @DataTableType
    public ProductDetails getDetailsFromDataType(Map<String, String> dataTable) {
        return ProductDetails.builder()
                .name(dataTable.get("name"))
                .description(dataTable.get("description"))
                .price(TestUtils.getMonetaryAmountFromString.apply(dataTable.get("price")))
                .build();
    }
}
