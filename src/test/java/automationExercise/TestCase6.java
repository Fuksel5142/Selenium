package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase6 extends TestBase {

    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        //5. Verify 'GET IN TOUCH' is visible
        WebElement touchPage=driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(touchPage.isDisplayed());
        //6. Enter name, email, subject and message
        WebElement enterName=driver.findElement(By.xpath("//input[@data-qa='name']"));
        // geriye kalan alanlari TAB ile dolasarak
        // formu dolduracağım
        Actions action=new Actions(driver);
        action.click(enterName)
                .sendKeys("Fatih")
                .sendKeys(Keys.TAB)
                .sendKeys("fuksel@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Özel")
                .sendKeys(Keys.TAB)
                .sendKeys("Lütfen dosyayı açarmısınız")
                .perform();
        //7. Upload file
        driver.findElement(By.xpath("//input[@name='upload_file']"))
                .sendKeys("C://Users//ASUS//Downloads/sampleFile.jpeg");
        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement succestext=driver.findElement(By.xpath("(//*[text()='Success! Your details have been submitted successfully.'])[1]"));
        String expectedusual=succestext.getText();
        String actual="Success! Your details have been submitted successfully.";
        Assert.assertTrue(expectedusual.contains(actual));
        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
        driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed();

    }
}
