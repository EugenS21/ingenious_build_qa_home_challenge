package com.ingenious_build.qa_home_challenge.web_automation.data_table_type;

import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

import static com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails.Fields.*;
import static com.ingenious_build.qa_home_challenge.web_automation.utils.TestUtils.*;

public class ProductDetailsType {

    @DataTableType
    public ProductDetails getDetailsFromDataType(Map<String, String> dataTable) {
        return ProductDetails.builder()
                .name(dataTable.get(name))
                .description(dataTable.get(description))
                .price(getMonetaryAmountFromString.apply(dataTable.get(price)))
                .build();
    }
}
