package com.ingenious_build.qa_home_challenge.web_automation.pages;

import com.ingenious_build.qa_home_challenge.web_automation.core.properties.PagesProperties;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout.overview.CheckOutOverviewItem;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout.overview.CheckOutOverviewItemsGrid;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout.overview.CheckOutOverviewFooter;
import com.ingenious_build.qa_home_challenge.web_automation.core.web.composite_elements.checkout.overview.CheckoutOverviewSummary;
import com.ingenious_build.qa_home_challenge.web_automation.model.MonetaryAmount;
import com.ingenious_build.qa_home_challenge.web_automation.model.ProductDetails;
import com.ingenious_build.qa_home_challenge.web_automation.utils.TestUtils;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ScenarioScope
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckoutOverviewPage extends AbstractPageWithGrid {

    CheckOutOverviewItemsGrid checkOutOverviewItemsGrid;
    CheckoutOverviewSummary checkoutOverviewSummary;
    CheckOutOverviewFooter checkoutOverviewFooter;

    public CheckoutOverviewPage(ModelMapper modelMapper, PagesProperties properties, WebDriver webDriver) {
        super(modelMapper, properties, webDriver);
        this.checkOutOverviewItemsGrid = new CheckOutOverviewItemsGrid(properties.getCheckOutOverview().getItems(), webDriver);
        this.checkoutOverviewSummary = new CheckoutOverviewSummary(properties.getCheckOutOverview().getSummaryInfo(), webDriver);
        this.checkoutOverviewFooter = new CheckOutOverviewFooter(properties.getCheckOutOverview().getFooter(), webDriver);
    }

    @Override
    public String getExpectedUrl() {
        return properties.getCheckOutOverview().getUrl();
    }

    public List<ProductDetails> getCheckoutOverviewItems() {
        return getProductsFromGrid(checkOutOverviewItemsGrid.getItems());
    }

    public String getPaymentInfo() {
        return checkoutOverviewSummary.getPaymentInfo();
    }

    public String getShippingInfo() {
        return checkoutOverviewSummary.getShippingInfo();
    }

    public MonetaryAmount getProductTotalPrice() {
        return TestUtils.getMonetaryAmountFromString.apply(checkoutOverviewSummary.getItemTotalPrice());
    }

    public MonetaryAmount getTax() {
        return TestUtils.getMonetaryAmountFromString.apply(checkoutOverviewSummary.getTax());
    }

    public MonetaryAmount getTotalPrice() {
        return TestUtils.getMonetaryAmountFromString.apply(checkoutOverviewSummary.getTotalPrice());
    }

    public void finish() {
        checkoutOverviewFooter.finish();
    }

    public void cancel() {
        checkoutOverviewFooter.cancel();
    }

}
