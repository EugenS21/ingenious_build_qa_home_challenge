package com.ingenious_build.qa_home_challenge.web_automation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CheckoutInformation {

    String firstName;
    String lastName;
    String zipCode;

}
