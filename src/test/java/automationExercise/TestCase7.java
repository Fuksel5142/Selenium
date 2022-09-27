package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase7 extends TestBase {
    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("(//a[@href='/test_cases'])[1]")).click();
        //5. Verify user is navigated to test cases page successfully
        driver.findElement(By.xpath("//html/body")).isDisplayed();

    }
}

