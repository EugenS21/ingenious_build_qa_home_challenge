package com.ingenious_build.qa_home_challenge.web_automation.core.web.elements;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.ItemSearchCriteria;

import java.util.List;

public interface Grid<T> {

    List<T> searchForItem(ItemSearchCriteria searchCriteria);

    List<T> getItems();

}
