import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartPriceTest {
    @Test
    public void verifySumOfTwoProducts() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Racunar 1\\Desktop\\qa comtrade\\New folder\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCartByName("Sauce Labs Bike Light");
        productsPage.addProductToCartByName("Sauce Labs Bolt T-Shirt");
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setFirstName("milan");
        checkoutPage.setLastName("Ilic");
        checkoutPage.setZipCode("000");
        checkoutPage.clickContinue();

        driver.close();


    }
}
