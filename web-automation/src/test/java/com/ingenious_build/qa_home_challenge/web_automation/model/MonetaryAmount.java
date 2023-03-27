package com.ingenious_build.qa_home_challenge.web_automation.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.InvalidArgumentException;

import java.math.BigDecimal;
import java.util.Currency;

@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class MonetaryAmount {

    Currency currency;
    BigDecimal amount;

    public MonetaryAmount sum(MonetaryAmount other) {
        if (other.getCurrency().equals(currency)) {
            return this.toBuilder()
                    .amount(amount.add(other.amount))
                    .build();
        }
        throw new InvalidArgumentException("Can't sum monetary amounts with different currencies");
    }

}
