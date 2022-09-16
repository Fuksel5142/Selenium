package Day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
   /* Bir Class olusturalim YanlisEmailTesti
    http://automationpractice.com/index.php sayfasina gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim*/
    WebDriver driver;

    @Before
    public  void setUp() {
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
    public void test1() {
        // http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php ");
        driver.findElement(By.xpath("//*[@class='login']")).click();
        WebElement email= driver.findElement(By.xpath("//*[@id='email_create']"));
        email.sendKeys("fukselmail.com");
        driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='create_account_error']")).isDisplayed());


    }
}
