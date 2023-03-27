package com.ingenious_build.qa_home_challenge.api_automation.data_table_types;

import com.github.javafaker.Faker;

public abstract class AbstractUserType {

    protected String generateRandomDataIfNeeded(String scenarioValue) {
        Faker faker = new Faker();
        scenarioValue = scenarioValue.toLowerCase();
        if (scenarioValue.toLowerCase().contains("rnd") && scenarioValue.contains("name")) {
            return faker.name().fullName();
        } else if (scenarioValue.toLowerCase().contains("rnd") && scenarioValue.contains("job")) {
            return faker.job().position();
        }
        return scenarioValue;
    }

}
