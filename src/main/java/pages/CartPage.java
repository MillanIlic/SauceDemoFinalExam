package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement checkoutButton() {
        return driver.findElement(By.name("checkout"));
    }

    public void clickCheckoutButton() {
        driver.findElement(By.name("checkout")).click();
    }

    public void openPage() {

    }

    public boolean isProductInCart(String productName) {
        boolean toReturn = false;

        WebElement cartList = driver.findElement(By.xpath("//div[@class='cart_list']"));

        List<WebElement> listItems = cartList.findElements(By.xpath(".//div[@class='cart_item']"));

        for(int i = 0; i < listItems.size(); i++) {
            WebElement name = listItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            if(name.getText().equals(productName)) {
                toReturn = true;
                break;
            }
        }
        return toReturn;
    }

    public boolean isDescriptionSame(String productDescription) {
        boolean toReturn = false;

        WebElement cartList = driver.findElement(By.xpath("//div[@class='cart_list']"));

        List<WebElement> listItems = cartList.findElements(By.xpath(".//div[@class='cart_item']"));

        for(int i = 0; i < listItems.size(); i++) {
            WebElement name = listItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_desc']"));
            if(name.getText().equals(productDescription)) {
                toReturn = true;
                break;
            }
        }
        return toReturn;
    }

    public boolean isPriceSame(String productPrice) {
        boolean toReturn = false;

        WebElement cartList = driver.findElement(By.xpath("//div[@class='cart_list']"));

        List<WebElement> listItems = cartList.findElements(By.xpath(".//div[@class='cart_item']"));

        for(int i = 0; i < listItems.size(); i++) {
            WebElement itemPrice = listItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_price']"));
           // String itemPriceText = itemPrice.getText();
           // Double itemPriceFirstNumber = Double.parseDouble(itemPriceText.substring(1));
            if(itemPrice.getText().equals(productPrice)) {
                toReturn = true;
                break;
            }
        }
        return toReturn;
    }


    public void close() {
        driver.close();
        driver.quit();
    }

}
