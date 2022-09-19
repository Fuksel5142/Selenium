package Day09;

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
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandle {
   /* Tests package’inda yeni bir class olusturun: WindowHandle2
    https://the-internet.herokuapp.com/windows adresine gidin.
    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    Click Here butonuna basın.
    Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    Sayfadaki textin “New Window” olduğunu doğrulayın.
    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.*/
   WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
       // driver.quit();
    }
    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement opening=driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        Assert.assertTrue(opening.isDisplayed());
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
           String actualTitle= driver.getTitle();
           Assert.assertTrue(driver.getTitle().contains(actualTitle));
           // Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        List<String> windowlist=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));
        String title=driver.getTitle();
        String actual="New Window";
        Assert.assertTrue(title.contains(actual));

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement text=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isDisplayed());
        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın
        driver.switchTo().window(windowlist.get(0));
        Assert.assertTrue(driver.getTitle().contains(actualTitle));



    }
}
