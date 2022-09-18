package Day08;

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

public class basic_Authenication {
    WebDriver driver;


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/basic_auth ");

    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1() {
        /*
1.Bir class olusturun :BasicAuthentication
2.https://the-internet.herokuapp.com/basic_auth sayfasinagidin
3.asagidaki yontem ve test datalarini kullanarak authentication'i yapin
    -Html komutu :https://username:password@URL
    -Username:admin
    -password:admin
4.Basarili sekilde sayfaya girildiginidogrulayin

       */
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='example']")).isDisplayed());
    }

    }

/*
//Basarili sekilde sayfaya girildigini dogrulayin
WebElement girildi=driver.findElement(By.xpath("//*[text()='Basic Auth']"));
Assert.assertTrue(girildi.isDisplayed());
 */