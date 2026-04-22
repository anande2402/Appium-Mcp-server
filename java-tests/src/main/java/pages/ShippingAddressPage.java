package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ShippingAddressPage extends BasePage {
    private static final By FIRST_ADDRESS = By.xpath("//android.widget.CheckBox[1]");
    private static final By CONFIRM_ADDRESS_BUTTON = By.id("com.amazon.mShop.android.shopping:id/confirm_button");

    public ShippingAddressPage(AppiumDriver driver) {
        super(driver);
    }

    public PaymentMethodPage selectDefaultAddress() {
        waitForClickableElement(FIRST_ADDRESS);
        click(FIRST_ADDRESS);
        click(CONFIRM_ADDRESS_BUTTON);
        return new PaymentMethodPage(driver);
    }
}
