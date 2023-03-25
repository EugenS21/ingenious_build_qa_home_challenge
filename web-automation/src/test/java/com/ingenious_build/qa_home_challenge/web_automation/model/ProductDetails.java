package com.ingenious_build.qa_home_challenge.web_automation.model;

import io.cucumber.java.mk_latn.No;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.util.Currency;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ProductDetails {

    String name;
    String description;
    MonetaryAmount price;

}
