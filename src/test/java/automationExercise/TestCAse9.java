package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCAse9 extends TestBase {
    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement productsPage = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(productsPage.isDisplayed());
        //6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("men");
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        driver.findElement(By.xpath("//*[text()='Searched Products']")).isDisplayed();
        //8. Verify all the products related to search are visible
        driver.findElement(By.xpath("//div[@class='product-image-wrapper']")).isDisplayed();






    }

}
