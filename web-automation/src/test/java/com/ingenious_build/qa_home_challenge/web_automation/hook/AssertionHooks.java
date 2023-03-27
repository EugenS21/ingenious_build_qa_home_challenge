package com.ingenious_build.qa_home_challenge.web_automation.hook;

import io.cucumber.java.After;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AssertionHooks {

    SoftAssertions softAssertions;

    @After(order = 9)
    public void doSoftAssert() {
        softAssertions.assertAll();
    }

}
