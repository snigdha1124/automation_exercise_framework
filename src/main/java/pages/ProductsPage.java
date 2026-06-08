package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    By productsMenu = By.xpath("//a[@href='/products']");
    By searchBox = By.id("search_product");
    By searchBtn = By.id("submit_search");

    // Open Products Page
    public void openProducts() {

        WebElement products =
                wait.until(ExpectedConditions.elementToBeClickable(productsMenu));

        // JavaScript Click
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", products);

        // Wait until Products page loads
        wait.until(ExpectedConditions.urlContains("products"));

        // Wait for Search Box
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        System.out.println("Products Page Opened Successfully");
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    // Search Product
    public void searchProduct(String productName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);

        driver.findElement(searchBtn).click();

        System.out.println("Searched Product: " + productName);
    }
}
