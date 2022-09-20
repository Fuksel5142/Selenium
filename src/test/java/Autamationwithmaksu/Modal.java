package Autamationwithmaksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Modal {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test() {
        driver.get("https://demoqa.com/modal-dialogs");
        WebElement smallButoon=driver.findElement(By.xpath("//button[@id='showSmallModal']"));
        smallButoon.click();

        WebElement modaltext=driver.findElement(By.xpath("//*[text()='This is a small modal. It has very less content']"));
        System.out.println(modaltext.getText());

        WebElement smallclosebutton=driver.findElement(By.xpath("//button[@id='closeSmallModal']"));
        smallclosebutton.click();



    }
}
