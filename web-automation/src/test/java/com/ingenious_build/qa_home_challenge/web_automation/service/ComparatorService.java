package com.ingenious_build.qa_home_challenge.web_automation.service;

import com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingField;
import com.ingenious_build.qa_home_challenge.web_automation.core.enums.SortingStrategy;
import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class ComparatorService {

    public Comparator<ProductDetails> getComparator(SortingStrategy sortingStrategy, SortingField sortingField) {
        Comparator<ProductDetails> comparing;
        if (sortingField.equals(SortingField.NAME)) {
            comparing = Comparator.comparing(ProductDetails::getName);
        } else {
            comparing = Comparator.comparing(product -> product.getPrice().getAmount());
        }
        if (sortingStrategy.equals(SortingStrategy.ASC)) {
            return comparing;
        }
        return comparing.reversed();
    }

}
