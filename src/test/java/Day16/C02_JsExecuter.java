package Day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JsExecuter extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Aşağıdaki carrers butonunu görünceye kadar js ile scroll yapalım
        WebElement carrers = driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carrers);
        //Carrers butonuna js ile click yapalım
        jse.executeScript("arguments[0].click();",carrers);
        /*
     Yeni bir class olusturun : ScroolInto
     hotelmycamp anasayfasina gidin
     2 farkli test method’u olusturarak actions classi ve Js Executor kullanarak asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
     istediginiz oda inceleme sayfasi acildigini test  edin
        */
    }
}
