package Autamationwithmaksu;

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

public class Test_1 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/browser-windows");
    }
    @Test
    public void test() throws InterruptedException {
        WebElement newtab= driver.findElement(By.xpath("//*[text()='New Tab']"));
        Thread.sleep(3000);
        newtab.click();
        List<String> tabs=new ArrayList<String>(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));// 1.taba geçiş yaparız

        System.out.println(driver.getCurrentUrl());

        driver.close();



    }
}
