package Day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
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
        driver.quit();

    }
    @Test
    public void test01(){
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonwindowhandle=driver.getWindowHandle();
        //2- Url'nin amazon içerdiğini test edelim
        String expectedurl = driver.getCurrentUrl();
        String actualurl="amazon";
        Assert.assertTrue(expectedurl.contains(actualurl));
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String BestbuyWindowHanndle=driver.getWindowHandle();
        //4- title'in BestBuy içerdiğini test edelim
        String actualtitle  = driver.getTitle();
        String expectedtitie= "Best Buy";
        Assert.assertTrue(actualtitle.contains(expectedtitie));
         //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonwindowhandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
         //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramasonucu=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String aranankelime="Java";
        String actualsonuc= aramasonucu.getText();
        Assert.assertTrue(actualsonuc.contains(aranankelime));
          //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(BestbuyWindowHanndle);
         //8- Logonun görünürlüğünü test edelim
        WebElement logo= driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
        //9- Sayfaları Kapatalım
    }
}
