package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ProductsPage {
    public WebDriver driver;

    public ProductsPage(ChromeDriver driver) {
        this.driver = driver;
    }


    public WebElement getCart() {
        return driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
    }

    public void openCart() {
        //driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        getCart().click();
    }

    public void close() {
        driver.close();
        driver.quit();
    }


    public void sortByAlphabet(String sortAlphabet) {
        WebElement sortContainer = driver.findElement(By.xpath("//select[@data-test='product_sort_container']"));

        sortContainer.click();

        List<WebElement> options = sortContainer.findElements(By.xpath(".//option"));

        for (int i = 0; i < options.size(); i++) {
            String optionText = options.get(i).getText();
            if (optionText.equals(sortAlphabet)) {
                options.get(i).click();
                break;
            }
        }
    }

    public void printProductsName() {
        WebElement container = driver.findElement(By.id("inventory_container"));

        List<WebElement> listInventoryItems = container.findElements(By.xpath(".//div[@class='inventory_item']"));

        for (int i = 0; i < listInventoryItems.size(); i++) {
            WebElement itemPrice = listInventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            System.out.println(itemPrice.getText());
        }
    }

    public void addProductToCartByName(String productName) {
        WebElement container = driver.findElement(By.id("inventory_container"));

        List<WebElement> listInventoryItems = container.findElements(By.xpath(".//div[@class='inventory_item']"));

        for (int i = 0; i < listInventoryItems.size(); i++) {
            WebElement itemName = listInventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            String itemNameText = itemName.getText();

            if (itemNameText.equals(productName)) {
                WebElement addButton = listInventoryItems.get(i).findElement(By.xpath(".//button"));
                addButton.click();
                break;
            }
        }
    }


}

