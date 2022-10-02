package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase10 extends TestBase {
    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4.//Scroll down to footer
        WebElement subcrated = driver.findElement(By.xpath("//*[text()='Subscription']"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",subcrated);
        //5. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("fuksel@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement succesful = driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
        JavascriptExecutor jse2=(JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView(true);",succesful);
        Assert.assertTrue(succesful.isDisplayed());




    }
}
