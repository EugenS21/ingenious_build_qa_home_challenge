package com.ingenious_build.qa_home_challenge.web_automation.core.web.service;


import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.InventoryItem;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class InventoryItemSearchService {

    InventoryItemSearchCriteria searchCriteria;

    public static InventoryItemSearchService doWith(InventoryItemSearchCriteria searchCriteria) {
        return new InventoryItemSearchService(searchCriteria);
    }

    private InventoryItemSearchService(InventoryItemSearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public InventoryItemsSearch and(List<InventoryItem> items) {
        return new InventoryItemsSearch(items);
    }

    @FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
    @RequiredArgsConstructor
    public class InventoryItemsSearch {

        List<InventoryItem> items;

        public List<InventoryItem> getFoundItems() {
            List<InventoryItem> foundItems = new ArrayList<>();
            if (Objects.nonNull(searchCriteria.getPrice())) {
                foundItems = filterCollectionByPredicate(item -> item.getPrice().get().getText().equals(searchCriteria.getPrice()));
            }
            if (Objects.nonNull(searchCriteria.getName())) {
                foundItems = filterCollectionByPredicate(item -> item.getName().get().getText().equals(searchCriteria.getName()));
            }
            return foundItems;
        }

        private List<InventoryItem> filterCollectionByPredicate(Predicate<InventoryItem> predicate) {
            return items.stream()
                    .filter(predicate)
                    .toList();
        }

    }

}
