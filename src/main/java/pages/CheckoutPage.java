package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {

    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement inputFirstName() {
        return driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
    }

    public WebElement inputLastName() {
        return driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
    }

    public WebElement inputZipCode() {
        return driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
    }

    public WebElement continueButton() {
        return driver.findElement(By.name("continue"));
    }

    public void setFirstName(String firstName) {
        inputFirstName().sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        inputLastName().sendKeys(lastName);
    }

    public void setZipCode(String zipCode) {
        inputZipCode().sendKeys(zipCode);
    }

    public void clickContinue() {
        driver.findElement(By.name("continue")).click();
    }

    public WebElement getTotalPrice() {
        return driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]"));
        //*[@id="checkout_summary_container"]/div/div[2]/div[5]/text()[2]
    }

    public Double getTotalSum() {
        WebElement totalPrice = getTotalPrice();
        return Double.parseDouble(totalPrice.getText().substring(13));
    }

    public Double sumTotalPrice() {
        WebElement container = driver.findElement(By.className("cart_list"));
        List<WebElement> listInventoryItems = container.findElements(By.className("item_pricebar"));
        double sum = 0;
        for (int i = 0; i < listInventoryItems.size(); i++) {
            WebElement itemPriceFirst = listInventoryItems.get(i).findElement(By.className("inventory_item_price"));
            String itemPriceFirstText = itemPriceFirst.getText();
            Double itemPriceNumber = Double.parseDouble(itemPriceFirstText.substring(1));
            sum += itemPriceNumber++;


        }
        return sum;
    }



        public void close () {
            driver.close();
            driver.quit();
        }


    }
