package com.ingenious_build.qa_home_challenge.web_automation.core.model;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class CheckoutInformationFormDetails {

    String firstName;
    String lastName;
    String zipCode;

}
