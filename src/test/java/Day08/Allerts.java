package Day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Allerts {

    WebDriver driver;
    Select select;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() throws InterruptedException {
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        // Click for JS Alert butonuna tıklayalım
        // Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // Click for JS Alert butonuna tıklayalım
            driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
            Thread.sleep(3000);
        // Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim
            driver.switchTo().alert().accept();//uyarıyı gecmek icin kullanırız, uyarıyı gecmeyi kabul et gibi bir anlamı var.
        driver.switchTo().alert().dismiss(); //iki secenek cıktığınıda iptal e basmak istiyorsak dismiss kullanacağız
        //tamam demek istiyorsak accept kullanacağız
        //uyarıdaki alert mesaj yazısını almak istiyorsak getText() kullanacağız.
        }

    }

