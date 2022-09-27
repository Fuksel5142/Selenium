package Day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenShoot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        // Amazon'a gidip, "Nutella" aratalım.
        driver.get("https://amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
// Ve sonuç sayısının olduğu, web elementin fotoğrafını ekleyelim.

// Belirli bölgelerin ekran görüntüsünü almak istersek o bölgeyi locate etmek gerekir.
// Aynı zamanda belirli bölgeyi çekmek istediğimizde alttaki objeyi oluşturmaya gerek yok ! Arasındaki tek fark bu !
// TakesScreenshot ts= (TakesScreenshot) driver;
        WebElement sonucYazıElementi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));

        File sonucYazıElementss=new File("target/ekranGoruntusu/sonucYazıElementi.jpg");

        File temp=sonucYazıElementi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp, sonucYazıElementss);// dosayı kaydediyor
    }
}
