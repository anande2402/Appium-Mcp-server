package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private static final By SEARCH_BOX = By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text");
    private static final By SEARCH_BUTTON = By.id("com.amazon.mShop.android.shopping:id/rs_search_button");

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public SearchResultsPage searchForProduct(String productName) {
        sendKeys(SEARCH_BOX, productName);
        click(SEARCH_BUTTON);
        return new SearchResultsPage(driver);
    }
}
