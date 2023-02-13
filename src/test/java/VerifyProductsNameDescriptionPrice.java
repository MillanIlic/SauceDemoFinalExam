import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class VerifyProductsNameDescriptionPrice {
    @Test
    public void verifyProductNameDecriptionPrice() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Racunar 1\\Desktop\\qa comtrade\\New folder\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCartByName("Sauce Labs Bike Light");
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        boolean isProductAdded = cartPage.isProductInCart("Sauce Labs Bike Light");
        boolean isSameDescription = cartPage.isDescriptionSame("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");

        Assert.assertEquals(isProductAdded, true, "Product with name Sauce Labs Bike Light is not added to cart");
        Assert.assertEquals(isSameDescription, true,"Products do not have the same description" );

        cartPage.close();

    }
    @Test
    public void verifyProductNameDecriptionPriceSecond() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Racunar 1\\Desktop\\qa comtrade\\New folder\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCartByName("Sauce Labs Backpack");
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        boolean isProductAdded = cartPage.isProductInCart("Sauce Labs Backpack");
        boolean isSameDescription = cartPage.isDescriptionSame("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");

        Assert.assertEquals(isProductAdded, true, "Product with name Sauce Labs Backpack is not added to cart");
        Assert.assertEquals(isSameDescription, true,"Products do not have the same description" );

        cartPage.close();

    }

}
