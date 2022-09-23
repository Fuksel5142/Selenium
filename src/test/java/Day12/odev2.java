package Day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class odev2 extends TestBase {
    @Test
    public void test1(){
       // 1."http://webdriveruniversity.com/" adresine gidin
                driver.get("http://webdriveruniversity.com");
                String actualtitle = driver.getTitle();
       // 2."Login Portal" a  kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // 3."Login Portal" a tiklayin  4.Diger window'a gecin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();
        List<String> loginPage=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(loginPage.get(1));
        // 5."username" ve  "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        // 6."login" butonuna basin
        driver.findElement(By.xpath("//button[text()='Login']")).click();
       //  7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualpopup=driver.switchTo().alert().getText();
        String expectedpopup="validation failed";
        Assert.assertTrue(actualpopup.contains(expectedpopup));
        //  8.Ok diyerek Popup'i kapatin// Ilk sayfaya geri donun
        driver.switchTo().alert().accept();
        driver.switchTo().window(loginPage.get(0));
       //  Ilk sayfaya donuldugunu test edin
        Assert.assertTrue(driver.getTitle().contains(actualtitle) );
    }
}
