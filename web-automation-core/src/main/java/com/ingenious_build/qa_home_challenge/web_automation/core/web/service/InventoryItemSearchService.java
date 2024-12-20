package com.ingenious_build.qa_home_challenge.web_automation.core.web.service;


import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemSearchCriteria;
import com.ingenious_build.qa_home_challenge.web_automation.core.model.item.Item;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.AbstractItem;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class InventoryItemSearchService<U extends Item, T extends AbstractItem<U>> {

    InventoryItemSearchCriteria searchCriteria;

    public static InventoryItemSearchService doWith(InventoryItemSearchCriteria searchCriteria) {
        return new InventoryItemSearchService(searchCriteria);
    }

    private InventoryItemSearchService(InventoryItemSearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public InventoryItemsSearch and(List<T> items) {
        return new InventoryItemsSearch(items);
    }

    @FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
    @RequiredArgsConstructor
    public class InventoryItemsSearch {

        List<T> items;

        public List<T> getFoundItems() {
            List<T> foundItems = new ArrayList<>();
            if (Objects.nonNull(searchCriteria.getPrice())) {
                foundItems = filterCollectionByPredicate(item -> item.getPrice().get().getText().equals(searchCriteria.getPrice()));
            }
            if (Objects.nonNull(searchCriteria.getName())) {
                foundItems = filterCollectionByPredicate(item -> item.getName().get().getText().equals(searchCriteria.getName()));
            }
            return foundItems;
        }

        private List<T> filterCollectionByPredicate(Predicate<T> predicate) {
            return items.stream()
                    .filter(predicate)
                    .toList();
        }

    }

}
