package com.ingenious_build.qa_home_challenge.web_automation.core.web.service;

import com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingField;
import com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingStrategy;

import static com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingField.NAME;
import static com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingStrategy.ASC;

public class SortingStrategySolverService {

    SortingField field;
    SortingStrategy strategy;

    private SortingStrategySolverService(SortingField field, SortingStrategy strategy) {
        this.field = field;
        this.strategy = strategy;
    }

    public static SortingStrategySolverService of(SortingField field, SortingStrategy strategy) {
        return new SortingStrategySolverService(field, strategy);
    }

    private String getField() {
        return field.equals(NAME) ? "Name" : "Price";
    }

    private String getFrom() {
        if (strategy.equals(ASC)) {
            return field.equals(NAME) ? "A" : "low";
        } else {
            return field.equals(NAME) ? "Z" : "high";
        }
    }

    private String getTo() {
        if (!strategy.equals(ASC)) {
            return field.equals(NAME) ? "A" : "low";
        } else {
            return field.equals(NAME) ? "Z" : "high";
        }
    }

    public String getStrategy() {
        return String.format("%s (%s to %s)", getField(), getFrom(), getTo());
    }

}
