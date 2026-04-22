# Amazon Mobile Test Automation - JAVA + TestNG

Complete end-to-end test automation for Amazon mobile app using JAVA, TestNG, and Appium.

## Project Structure

```
java-tests/
├── pom.xml
├── src/
│   ├── main/java/pages/
│   │   ├── BasePage.java                 (Base class for all pages)
│   │   ├── HomePage.java                 (Search functionality)
│   │   ├── SearchResultsPage.java        (Search results)
│   │   ├── ProductDetailPage.java        (Product details)
│   │   ├── CartPage.java                 (Shopping cart)
│   │   ├── CheckoutPage.java             (Checkout & sign in)
│   │   ├── ShippingAddressPage.java      (Shipping address selection)
│   │   ├── PaymentMethodPage.java        (Payment method selection)
│   │   ├── OrderReviewPage.java          (Order review)
│   │   └── OrderConfirmationPage.java    (Order confirmation)
│   ├── test/java/tests/
│   │   ├── BaseTest.java                 (Base test setup & teardown)
│   │   └── AmazonOrderFlowTest.java      (Main test scenario)
│   └── test/resources/
│       └── testng.xml                    (TestNG configuration)
└── README.md
```

## Test Scenario

The test performs the following steps:

1. **Search for Product**: Opens Amazon app and searches for "Pixel 10 Pro XL"
2. **Select Item**: Selects the first search result
3. **Add to Cart**: Adds the product to shopping cart
4. **Verify Cart**: Confirms item is in cart
5. **Proceed to Checkout**: Navigates to checkout page
6. **Sign In**: Signs in with email `test@example.com` and password `testpassword123`
7. **Select Address**: Selects default shipping address
8. **Choose Payment**: Selects default payment method
9. **Review Order**: Displays and verifies order details
10. **Place Order**: Places the order
11. **Confirm Order**: Verifies order confirmation and displays order number

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Android SDK
- Appium Server running on `http://127.0.0.1:4723`
- Android device or emulator with "Pixel 10 Pro XL" device name
- Amazon app installed on device

## Installation & Setup

### 1. Install Dependencies

```bash
mvn clean install
```

### 2. Start Appium Server

```bash
appium --port 4723
```

### 3. Configure Device

Update `BaseTest.java` with your device details:

```java
capabilities.setCapability("appium:deviceName", "Your Device Name");
capabilities.setCapability("appium:platformVersion", "Your Android Version");
```

### 4. Update App Path

Update the `APP_PATH` in `BaseTest.java`:

```java
protected static final String APP_PATH = "path/to/your/amazon-app.apk";
```

## Running Tests

### Run All Tests

```bash
mvn test
```

### Run Specific Test

```bash
mvn test -Dtest=AmazonOrderFlowTest
```

### Run with TestNG XML

```bash
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

## Page Object Model (POM)

Each page is represented as a separate class with:

- **Locators**: By clauses for identifying elements
- **Actions**: Methods performing user interactions
- **Assertions**: Verification methods

### Example: BasePage

```java
protected WebElement waitForElement(By locator) {
    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}

protected void click(By locator) {
    waitForClickableElement(locator).click();
}
```

## Key Features

- ✅ Explicit waits with 10-second timeout
- ✅ Mobile scroll gestures for Android
- ✅ Comprehensive error handling
- ✅ Clear test reporting with log messages
- ✅ Modular page object design
- ✅ TestNG integration

## Troubleshooting

### Appium Connection Issues

```bash
# Verify Appium is running
curl http://127.0.0.1:4723/status
```

### Element Not Found

- Verify app package and activity names
- Update XPath/ID locators based on actual app UI
- Use Appium Inspector to inspect elements

### Device Not Found

```bash
adb devices  # List connected devices
adb connect <device_ip>:<port>  # Connect to remote device
```

## Test Execution Flow

```
├─ setUp() - Initialize AppiumDriver
├─ testCompleteAmazonOrderFlow()
│  ├─ Search for product
│  ├─ Select first result
│  ├─ Add to cart
│  ├─ Proceed to checkout
│  ├─ Sign in
│  ├─ Select shipping
│  ├─ Select payment
│  ├─ Review order
│  ├─ Place order
│  └─ Verify confirmation
└─ tearDown() - Quit driver
```

## Expected Test Result

```
[INFO] Step 1: Searching for product...
[INFO] Step 2: Selecting first search result...
[INFO] Step 3: Adding product to cart...
[INFO] Product selected: Pixel 10 Pro XL
[INFO] Step 4: Verifying item in cart...
[INFO] Cart item count: 1
[INFO] Step 5: Proceeding to checkout...
[INFO] Step 6: Signing in with credentials...
[INFO] Signed in with email: test@example.com
[INFO] Step 7: Selecting shipping address...
[INFO] Step 8: Selecting payment method...
[INFO] Step 9: Reviewing order details...
[INFO] Order Total: $XXX.XX
[INFO] Step 10: Placing order...
[INFO] Step 11: Verifying order confirmation...
[INFO] Order placed successfully! Order Number: #123456789
[INFO] Test completed successfully!
```

## Dependencies

- **Appium Java Client 9.2.0**: Appium automation library
- **Selenium 4.25.0**: WebDriver for mobile automation
- **TestNG 7.10.0**: Testing framework
- **Log4j 2.20.0**: Logging framework
- **Jackson 2.16.0**: JSON processing

## Notes

- All XPath locators are based on Amazon app standard UI elements
- Adjust locators if app version or UI layout changes
- Tests should run on Android devices with API level 16 or higher
- Each test run is independent with proper setup/teardown

## License

This project is provided as-is for testing purposes.
