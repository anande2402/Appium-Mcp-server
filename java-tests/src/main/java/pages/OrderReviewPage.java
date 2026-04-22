package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class OrderReviewPage extends BasePage {
    private static final By ORDER_TOTAL = By.id("com.amazon.mShop.android.shopping:id/order_total");
    private static final By PLACE_ORDER_BUTTON = By.id("com.amazon.mShop.android.shopping:id/place_order_button");
    private static final By ORDER_CONFIRMATION = By.xpath("//android.widget.TextView[@text='Order Placed']");

    public OrderReviewPage(AppiumDriver driver) {
        super(driver);
    }

    public String getOrderTotal() {
        return getText(ORDER_TOTAL);
    }

    public OrderConfirmationPage placeOrder() {
        click(PLACE_ORDER_BUTTON);
        waitForElement(ORDER_CONFIRMATION);
        return new OrderConfirmationPage(driver);
    }
}
