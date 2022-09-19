package Day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class İframe {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
        @Test
        public void test1 () {
            // https://html.com/tags/iframe/ adresine gidiniz
            // YouTube videosunu calistiriniz
            driver.get("https://html.com/tags/iframe/");
            /*
            Bir web sitesinde bir video(youtubw v.b) varsa <İframe> tag 'ı içerisindeyse bu video yu direk locate edip
            çalıştırmak dinemik olmaz çünkü link değişebilir ve locate imiz çalışmaz.
            Bunun için bütün frame'leri bir array liste etıp index ile frame i seçip sonrasına play tuşunu locate
            edip çalıştırabilirsiniz.
             */
            List<WebElement> İframelist=new ArrayList<WebElement>(driver.findElements(By.xpath("//iframe")));
            driver.switchTo().frame(İframelist.get(0));
            driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();





           /* WebElement youtubeFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
            driver.switchTo().frame(youtubeFrame);
            WebElement youtubePlayButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
            youtubePlayButton.click();*/
        }
    }


