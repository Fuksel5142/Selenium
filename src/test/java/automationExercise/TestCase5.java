package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase5 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get(("http://automationexercise.com"));
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//li/a[@href='/login']")).click();
        //5. Verify 'New User Signup!' is visible
        WebElement newusersignup = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newusersignup.isDisplayed());
        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("fatih");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("fuksel@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        //8. Verify error 'Email Address already exist!' is visible
        WebElement alreadyexist = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        Assert.assertTrue(alreadyexist.isDisplayed());
    }
}
