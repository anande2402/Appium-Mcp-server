package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class PaymentMethodPage extends BasePage {
    private static final By FIRST_PAYMENT_METHOD = By.xpath("//android.widget.RadioButton[1]");
    private static final By CONFIRM_PAYMENT_BUTTON = By.id("com.amazon.mShop.android.shopping:id/confirm_button");

    public PaymentMethodPage(AppiumDriver driver) {
        super(driver);
    }

    public OrderReviewPage selectDefaultPaymentMethod() {
        waitForClickableElement(FIRST_PAYMENT_METHOD);
        click(FIRST_PAYMENT_METHOD);
        click(CONFIRM_PAYMENT_BUTTON);
        return new OrderReviewPage(driver);
    }
}
