package com.ingenious_build.qa_home_challenge.web_automation.core.web.elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.InventoryItemSearchCriteria;

import java.util.List;

public interface Grid<T> {

    List<T> searchForItem(InventoryItemSearchCriteria searchCriteria);

    List<T> getItems();

}
