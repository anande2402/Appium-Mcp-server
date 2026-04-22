package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {
    private static final By FIRST_SEARCH_RESULT = By.xpath("//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/product_image'][1]");

    public SearchResultsPage(AppiumDriver driver) {
        super(driver);
    }

    public ProductDetailPage selectFirstSearchResult() {
        waitForClickableElement(FIRST_SEARCH_RESULT);
        click(FIRST_SEARCH_RESULT);
        return new ProductDetailPage(driver);
    }
}
