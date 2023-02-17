package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public  void setFirstName(String firstName) {inputFirstName().sendKeys(firstName);
    }
    public  void setLastName(String lastName) {inputLastName().sendKeys(lastName);
    }

    public void setZipCode(String zipCode) {
        inputZipCode().sendKeys(zipCode);
    }

    public void clickContinue() {
        driver.findElement(By.name("continue")).click();
    }


    public void close() {
        driver.close();
        driver.quit();
    }



}
