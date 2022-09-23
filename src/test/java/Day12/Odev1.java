package Day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Odev1 extends TestBase {
   @Test
    public void test1() throws InterruptedException {
       // "http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
       driver.get("http://webdriveruniversity.com/IFrame/index.html");
       //"Our Products" butonuna basin
      WebElement iFrameElementi=driver.findElement(By.id("frame"));
      driver.switchTo().frame(iFrameElementi);//locate ettiğimiz frame e geçmek için bu kullanılır
       driver.findElement(By.xpath("//*[text()='Our Products']")).click();
       //"Cameras product"i tiklayin

       driver.findElement(By.xpath("//*[text()='Cameras']")).click();
       Thread.sleep(3000);
       //Popup mesajini yazdirin
       driver.switchTo().defaultContent( );
     //  System.out.println(driver.switchTo().alert().getText());
       //"close" butonuna basin
       driver.switchTo().alert().dismiss();
       //"WebdriverUniversity.com (IFrame)" linkini tiklayin
       driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']")).click();
       //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
       String expectedurl = "http://webdriveruniversity.com/index.html";
       String actualurl=driver.getCurrentUrl();
       Assert.assertTrue(expectedurl.contains(actualurl));
   }
}
