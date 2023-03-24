package com.ingenious_build.qa_home_challenge.web_automation.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;
import java.util.Currency;

@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class MonetaryAmount {

    Currency currency;
    BigDecimal amount;

}
