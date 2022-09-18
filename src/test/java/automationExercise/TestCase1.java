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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase1 {

    //Launch browser
    WebDriver driver ;

    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
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
        WebElement Signup = driver.findElement(By.xpath("//a[@href='/login']"));
        Signup.click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignın= driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignın.isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Fatih");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("fuksel551@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[text()='Signup']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInfo= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountInfo.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");

        WebElement Dayddm= driver.findElement(By.xpath("//select[@data-qa='days']"));
        Thread.sleep(1000);
        Select opt1=new Select(Dayddm);
        opt1.selectByVisibleText("6");

        WebElement Mntddm= driver.findElement(By.xpath("//select[@data-qa='months']"));
        Select opt2=new Select(Mntddm);
        Thread.sleep(1000);
        opt2.selectByVisibleText("March");

        WebElement yearddm= driver.findElement(By.xpath("//select[@data-qa='years']"));
        Select opt3=new Select(yearddm);
        Thread.sleep(1000);
        opt3.selectByVisibleText("1992");

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("fatih");
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("yuksel");
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("turkey");
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("konya");
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("selcuklu");
        WebElement Country= driver.findElement(By.xpath("//select[@data-qa='country']"));
        Select cntr=new Select(Country);
        cntr.selectByVisibleText("Canada");

        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Konya");
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("turkey");
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("535545654");

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //16. Verify that 'Logged in as username' is visible
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a"));
        Assert.assertTrue(loggedInAsUsername.isDisplayed());

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();







    }
}
