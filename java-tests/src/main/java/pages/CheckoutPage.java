package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {
    private static final By SIGN_IN_EMAIL_FIELD = By.id("com.amazon.mShop.android.shopping:id/username_field");
    private static final By SIGN_IN_PASSWORD_FIELD = By.id("com.amazon.mShop.android.shopping:id/password_field");
    private static final By SIGN_IN_BUTTON = By.id("com.amazon.mShop.android.shopping:id/sign_in_button");
    private static final By CONTINUE_BUTTON = By.id("com.amazon.mShop.android.shopping:id/continue_button");

    public CheckoutPage(AppiumDriver driver) {
        super(driver);
    }

    public void signInWithEmail(String email, String password) {
        waitForElement(SIGN_IN_EMAIL_FIELD);
        sendKeys(SIGN_IN_EMAIL_FIELD, email);
        click(CONTINUE_BUTTON);
        sendKeys(SIGN_IN_PASSWORD_FIELD, password);
        click(SIGN_IN_BUTTON);
    }

    public ShippingAddressPage selectShippingAddress() {
        waitForElement(By.id("com.amazon.mShop.android.shopping:id/shipping_address_selector"));
        click(By.id("com.amazon.mShop.android.shopping:id/shipping_address_selector"));
        return new ShippingAddressPage(driver);
    }
}
