import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

public class CartPriceTest {
    private Object WebDriver;

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

        Assert.assertEquals(checkoutPage.sumTotalPrice(), checkoutPage.getTotalSum(), "Product sum is not equals");
        System.out.println(checkoutPage.sumTotalPrice() + "=" + checkoutPage.getTotalSum());

        driver.close();


    }
      @Test
    public void verifySumOfThreeProducts() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Racunar 1\\Desktop\\qa comtrade\\New folder\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCartByName("Sauce Labs Bike Light");
        productsPage.addProductToCartByName("Sauce Labs Backpack");
        productsPage.addProductToCartByName("Sauce Labs Bolt T-Shirt");
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setFirstName("milan");
        checkoutPage.setLastName("Ilic");
        checkoutPage.setZipCode("000");
        checkoutPage.clickContinue();

        Assert.assertEquals(checkoutPage.sumTotalPrice(), checkoutPage.getTotalSum(), "Product sum is not equals");
        System.out.println(checkoutPage.sumTotalPrice() + "=" + checkoutPage.getTotalSum());

        driver.close();
    }
}
