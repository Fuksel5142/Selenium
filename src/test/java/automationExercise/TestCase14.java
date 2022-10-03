package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase14 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Add products to cart
        Actions action= new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement addtocart= driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]"));
        action.moveToElement(addtocart).perform();
        addtocart.click();
        Thread.sleep(3000);

        //5. Click 'Cart' button
        WebElement continueButton = driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']"));
        continueButton.click();
        action.sendKeys(Keys.PAGE_UP).perform();
        WebElement cartButton = driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]"));
        cartButton.click();
        //6. Verify that cart page is displayed
        driver.findElement(By.xpath("//section[@id='cart_items']")).isDisplayed();

    }
}
