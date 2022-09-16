package Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClaasAfterClass {
    /*
    BeforeClass ve AfterClass notasyonları kullanıyorsak oluşturacağız method u static yapmamız gerekiiyor
     */
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    @Ignore
    /*
    Çalışmasını istemediğimiz test için @Ignore rotasyonu kullanılır
     */
    public void method1() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://amazon.com");
    }
    @Test
    public void method2(){
        driver.get("https://techproeducation.com");
    }
    @Test
    public void method3(){
        driver.get("https://hepsiburada.com");
        //BeforeClass ve AfterClass da bir kere calısır // before ve after da 3 kere çalısır
        /*beforeclass-afterclass kullanirsak ayni browserda islem yaapar once beforeclass
         calisir arada 3 method calisir en son afterclass calisir. Toplam da 5 method calisir*/
    }
}
