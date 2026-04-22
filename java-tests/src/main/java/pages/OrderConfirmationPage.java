package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class OrderConfirmationPage extends BasePage {
    private static final By ORDER_NUMBER = By.id("com.amazon.mShop.android.shopping:id/order_number");
    private static final By ORDER_CONFIRMATION_MESSAGE = By.xpath("//android.widget.TextView[@text='Order Placed']");

    public OrderConfirmationPage(AppiumDriver driver) {
        super(driver);
    }

    public String getOrderNumber() {
        return getText(ORDER_NUMBER);
    }

    public boolean isOrderConfirmed() {
        return isElementDisplayed(ORDER_CONFIRMATION_MESSAGE);
    }
}
