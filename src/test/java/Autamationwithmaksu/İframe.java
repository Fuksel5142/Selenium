package Autamationwithmaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class İframe {
    WebDriver driver;
    @Before
    public void setUp() {
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
    public void test() {
        driver.get("https://demoqa.com/frames");
        // frame e geçmek lazım
       driver.switchTo().frame("frame1");
        WebElement heading=driver.findElement(By.id("sampleHeading"));
        String text=heading.getText();
        System.out.println(text);
        driver.switchTo().parentFrame();//frame e girdikten sonra çık

        List<WebElement> elementlist=driver.findElements(By.cssSelector("div[id='framesWrapper']"));
        String paragraph=elementlist.get(0).getText();
        System.out.println(paragraph);

        //2.Frame e geçiyoruz
        driver.switchTo().frame("frame2");
        WebElement heading2=driver.findElement(By.id("sampleHeading"));
        String text2=heading2.getText();
        System.out.println(text2);
        driver.switchTo().parentFrame();
    }
        }

