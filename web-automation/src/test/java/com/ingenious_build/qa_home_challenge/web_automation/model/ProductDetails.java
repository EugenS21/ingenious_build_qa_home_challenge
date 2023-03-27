package com.ingenious_build.qa_home_challenge.web_automation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ProductDetails {

    String name;
    String description;
    MonetaryAmount price;

}
