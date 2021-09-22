package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.base;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class shoppingPage extends base {

    WebDriver driver = initializedriver();
    WebElement hardtop = driver.findElement(By.xpath("//h2[text()='Hard top']//parent::a//following-sibling::div//div[@class='product-wishlist']//*[text()='Add to wishlist']"));
    WebElement bikini = driver.findElement(By.xpath("//h2[text()='Bikini']//parent::a//following-sibling::div//div[@class='product-wishlist']//*[text()='Add to wishlist']"));
    WebElement singleShirt = driver.findElement(By.xpath("//h2[text()='Single Shirt']//parent::a//following-sibling::div//div[@class='product-wishlist']//*[text()='Add to wishlist']"));
    WebElement modern = driver.findElement(By.xpath("(//h2[text()='Modern']//parent::a//following-sibling::div//div[@class='product-wishlist']//*[text()='Add to wishlist'])[1]"));
    WebElement wishList = driver.findElement(By.xpath("//div[@class='mobile-wishlist visible-xs']//*[@title='Wishlist']//*[@class='lar la-heart']"));

    public shoppingPage() throws IOException {
    }

    public void addFourProducts() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", hardtop);
        bikini.click();
        singleShirt.click();
        modern.click();
    }

    public void viewWishList() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1000)");
        js.executeScript("arguments[0].click();", wishList);
        Thread.sleep(4000);
    }

    public void itemcount() throws InterruptedException {
        Thread.sleep(4000);
        List<WebElement> itemcount = driver.findElements(By.xpath("//*[@id='site-content']//td[@class='product-price']"));
        int count = itemcount.size();
        Assert.assertEquals(count, 4);
    }

    public String searchLowestPrice() {
        List<WebElement> itemprice = driver.findElements(By.xpath("//td[@class='product-price']//bdi"));
        List<WebElement> itemcount = driver.findElements(By.xpath("//*[@id='site-content']//td[@class='product-price']"));
        String productname = null;
        String lowestPrice = null;
        ArrayList<String> arr = new ArrayList();
        for (int j = 0; j < itemcount.size(); j++) {
            String[] values = itemcount.get(j).getText().split(" ");
            for (int x = 0; x < values.length; x++) {
                if (values.length <= 1) {
                    arr.add(values[0]);
                } else {
                    arr.add(values[1]);
                }
            }
            Collections.sort(arr);
        }
        lowestPrice = arr.get(0);

        List<WebElement> row = driver.findElements(By.xpath("//*[@id='site-content']//td[@class='product-price']//parent::tr"));
        for (int g = 0; g < row.size(); g++) {
            if (row.get(g).getText().contains(lowestPrice)) {
                g++;
                productname = driver.findElement(By.xpath("(//*[@id='site-content']//td[@class='product-price']//parent::tr//*[@class='product-name'])[" + g + "]")).getText();
            }
        }
        return productname;
    }

    public void addLowestPriceItemToCart(String productname) throws InterruptedException {
        List<WebElement> row = driver.findElements(By.xpath("//*[@id='site-content']//td[@class='product-price']//parent::tr"));
        for (int g = 0; g < row.size(); g++) {
            if (row.get(g).getText().contains(productname)) {
                g++;
                driver.findElement(By.xpath("(//*[@id='site-content']//td[@class='product-price']//parent::tr//*[text()='Add to cart'])[" + g + "]")).click();
                Thread.sleep(3000);
            }
        }
    }

    public void clickCart(String productname) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='site-content']")).click();
        WebElement cart = driver.findElement(By.xpath("(//*[@class='header-cart-inner']//*[@class='la la-shopping-bag'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        js.executeScript("arguments[0].click();", cart);
        Thread.sleep(3000);
        String pr = driver.findElement(By.xpath("//*[@class='woocommerce-cart-form__cart-item cart_item']//*[@class='product-name']")).getText();
        Assert.assertEquals(pr, productname);
        driver.quit();
    }
}
