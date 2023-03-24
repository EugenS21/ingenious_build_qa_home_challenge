package com.ingenious_build.qa_home_challenge.web_automation.utils;

import com.ingenious_build.qa_home_challenge.web_automation.model.MonetaryAmount;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.function.Function;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@UtilityClass
public class TestUtils {

    public Function<String, MonetaryAmount> getMonetaryAmountFromString = string -> {
        Currency foundCurrency = Currency.getAvailableCurrencies().stream()
                .filter(currency -> currency.getSymbol().equals(string.replaceAll("[0-9.,]", EMPTY)))
                .findFirst()
                .orElse(Currency.getInstance("USD"));
        String amount = string.replaceAll("[^\\d.]", "");
        return MonetaryAmount.builder().currency(foundCurrency).amount(new BigDecimal(amount)).build();
    };

}
