package Day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {
    @Test
    public void test1() {
       // 1- https://www.facebook.com adresine gidelim  2- Yeni hesap olustur butonuna basalim
        driver.get("https://www.facebook.com");
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement isim=driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        action.click(isim)
                .sendKeys("Fatih")
                .sendKeys(Keys.TAB)
                .sendKeys("yuksel")
                .sendKeys(Keys.TAB)
                .sendKeys("fuksel@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("4567899")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("6").sendKeys(Keys.TAB).sendKeys("Mar")
                .sendKeys(Keys.TAB).sendKeys("1992").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

       // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim  4- Kaydol tusuna basalim

    }
}
