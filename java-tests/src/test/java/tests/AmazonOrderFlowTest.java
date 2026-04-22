package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AmazonOrderFlowTest extends BaseTest {
    private static final String PRODUCT_SEARCH = "Pixel 10 Pro XL";
    private static final String TEST_EMAIL = "test@example.com";
    private static final String TEST_PASSWORD = "testpassword123";

    @Test(description = "Complete Amazon order flow: Search, Select, Add to Cart, Checkout, Sign In, Select Address, Payment, Review, and Place Order")
    public void testCompleteAmazonOrderFlow() {
        // Step 1: Open Home Page and Search
        System.out.println("Step 1: Searching for product...");
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchForProduct(PRODUCT_SEARCH);
        Assert.assertNotNull(searchResultsPage, "Search results page not loaded");

        // Step 2: Select First Search Result
        System.out.println("Step 2: Selecting first search result...");
        ProductDetailPage productDetailPage = searchResultsPage.selectFirstSearchResult();
        Assert.assertNotNull(productDetailPage, "Product detail page not loaded");

        // Step 3: Get Product Name and Add to Cart
        System.out.println("Step 3: Adding product to cart...");
        String productName = productDetailPage.getProductName();
        System.out.println("Product selected: " + productName);
        CartPage cartPage = productDetailPage.addToCart();
        Assert.assertNotNull(cartPage, "Cart page not loaded");

        // Step 4: Verify Item in Cart
        System.out.println("Step 4: Verifying item in cart...");
        int cartItemCount = cartPage.getCartItemCount();
        Assert.assertTrue(cartItemCount > 0, "Item not added to cart");
        System.out.println("Cart item count: " + cartItemCount);

        // Step 5: Proceed to Checkout
        System.out.println("Step 5: Proceeding to checkout...");
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        Assert.assertNotNull(checkoutPage, "Checkout page not loaded");

        // Step 6: Sign In with Email and Password
        System.out.println("Step 6: Signing in with credentials...");
        checkoutPage.signInWithEmail(TEST_EMAIL, TEST_PASSWORD);
        System.out.println("Signed in with email: " + TEST_EMAIL);

        // Step 7: Select Shipping Address
        System.out.println("Step 7: Selecting shipping address...");
        ShippingAddressPage shippingAddressPage = checkoutPage.selectShippingAddress();
        PaymentMethodPage paymentMethodPage = shippingAddressPage.selectDefaultAddress();
        Assert.assertNotNull(paymentMethodPage, "Payment method page not loaded");

        // Step 8: Choose Payment Method
        System.out.println("Step 8: Selecting payment method...");
        OrderReviewPage orderReviewPage = paymentMethodPage.selectDefaultPaymentMethod();
        Assert.assertNotNull(orderReviewPage, "Order review page not loaded");

        // Step 9: Review Order Details
        System.out.println("Step 9: Reviewing order details...");
        String orderTotal = orderReviewPage.getOrderTotal();
        System.out.println("Order Total: " + orderTotal);
        Assert.assertNotNull(orderTotal, "Order total not displayed");

        // Step 10: Place Order
        System.out.println("Step 10: Placing order...");
        OrderConfirmationPage confirmationPage = orderReviewPage.placeOrder();
        Assert.assertNotNull(confirmationPage, "Order confirmation page not loaded");

        // Step 11: Verify Order Confirmation
        System.out.println("Step 11: Verifying order confirmation...");
        Assert.assertTrue(confirmationPage.isOrderConfirmed(), "Order confirmation not displayed");
        String orderNumber = confirmationPage.getOrderNumber();
        System.out.println("Order placed successfully! Order Number: " + orderNumber);
        System.out.println("Test completed successfully!");
    }
}
