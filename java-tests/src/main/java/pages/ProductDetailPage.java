package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProductDetailPage extends BasePage {
    private static final By ADD_TO_CART_BUTTON = By.id("com.amazon.mShop.android.shopping:id/action_button");
    private static final By PRODUCT_NAME = By.id("com.amazon.mShop.android.shopping:id/product_title");

    public ProductDetailPage(AppiumDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getText(PRODUCT_NAME);
    }

    public CartPage addToCart() {
        click(ADD_TO_CART_BUTTON);
        waitForElement(By.xpath("//android.widget.Button[@text='View Cart']"));
        return new CartPage(driver);
    }
}
