import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class AlphabetSortTest {
    @Test
    public void verifyAtoZSortProduct() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Racunar 1\\Desktop\\qa comtrade\\New folder\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortByValue("Name (A to Z)");
        productsPage.printProductsName();
        productsPage.close();
    }

    @Test
    public void verifyZtoASortProduct() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Racunar 1\\Desktop\\qa comtrade\\New folder\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortByValue("Name (Z to A)");
        productsPage.printProductsName();

        productsPage.close();
    }
}
