package Autamationwithmaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alert {
    WebDriver driver;
    @Before
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();


        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();

        }
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
        WebDriverWait wait=new WebDriverWait(driver, 5);
         wait.until(ExpectedConditions.alertIsPresent());
         driver.switchTo().alert().accept();

        WebElement Onbuttonk= driver.findElement(By.xpath("//button[@id='confirmButton']"));
        Onbuttonk.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        WebElement yazi=driver.findElement(By.xpath("//*[@id='confirmResult']"));
        String result=yazi.getText();
        String actual="selected";
        Assert.assertTrue(result.contains(actual));

        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();

        }
        driver.switchTo().alert().sendKeys("Fatih");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();

        }
        driver.switchTo().alert().accept();









    }
}
