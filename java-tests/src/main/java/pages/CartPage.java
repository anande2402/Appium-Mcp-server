package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CartPage extends BasePage {
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.id("com.amazon.mShop.android.shopping:id/button_proceed_to_checkout");
    private static final By CART_ITEM_COUNT = By.xpath("//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/item_count']");

    public CartPage(AppiumDriver driver) {
        super(driver);
    }

    public int getCartItemCount() {
        String itemCountText = getText(CART_ITEM_COUNT);
        return Integer.parseInt(itemCountText.replaceAll("[^0-9]", ""));
    }

    public CheckoutPage proceedToCheckout() {
        click(PROCEED_TO_CHECKOUT_BUTTON);
        return new CheckoutPage(driver);
    }
}
