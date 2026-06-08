package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test
    public void searchProductTest() {

        ProductsPage products = new ProductsPage(driver);

        products.openProducts();

        products.searchProduct("Blue Top");

        Assert.assertTrue(driver.getPageSource().contains("Blue Top"));

        System.out.println("Product Search Test Passed");
    }
}


