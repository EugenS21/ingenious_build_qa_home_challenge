package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.model.item.Item;
import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.AbstractItem;
import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import com.ingenious_build.qa_home_challenge.web_automation.utils.TestUtils;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AbstractPageWithGrid extends AbstractPage {

    public AbstractPageWithGrid(ModelMapper modelMapper, PagesProperties properties, WebDriver webDriver) {
        super(modelMapper, properties, webDriver);
    }

    public <T extends AbstractItem<DataType>, DataType extends Item> List<ProductDetails> getProductsFromGrid(List<T> items) {
        return items.stream()
                .map(AbstractItem::getData)
                .map(grid -> modelMapper.map(grid, ProductDetails.class).toBuilder()
                        .price(TestUtils.getMonetaryAmountFromString.apply(grid.getPrice()))
                        .build())
                .toList();
    }

}
