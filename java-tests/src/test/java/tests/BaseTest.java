package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;
    protected static final String APPIUM_SERVER = "http://127.0.0.1:4723";
    protected static final String APP_PATH = "/Users/anandedulakanti/Appium-Mcp-Server/app/android/wdio.apk";

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "Pixel 10 Pro XL");
        capabilities.setCapability("appium:platformVersion", "16.0");
        capabilities.setCapability("appium:app", APP_PATH);
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:newCommandTimeout", 300);
        capabilities.setCapability("appium:autoGrantPermissions", true);

        driver = new AndroidDriver(new URL(APPIUM_SERVER), capabilities);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
