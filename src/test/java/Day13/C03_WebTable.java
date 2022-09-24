package Day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_WebTable extends TestBase {
    @Test
    public void test01() {
        // onceki class'daki adrese gidip
        // girisYap method'unu kullanarak sayafaya giris yapin
        // input olarak verilen satir sayisi ve sutun sayisi'na sahip
        // cell'deki text'i yazdirin
        login();
        int satir=3;
        int sutun=3;
        WebElement aranancell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));//çmce tr olur sonra td
        //tr satır td sütün satır komple alınır sütün tek tek doldurulur
        System.out.println(aranancell.getText());
    }

    public void login() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[text()='Log in']")).click();
      Actions action = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        action.click(username).sendKeys("manager")
                .sendKeys(Keys.TAB).sendKeys("Manager1!").
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
           /*
Tabloda<table> tagı altinda tablonun basligini gösteren <thead> tag'i bulunur.
Eger baslikta satir(row) varsa <thead> tag'i altinda <tr> (satir-row) tagi vardir.
Ve basliktaki sutunlara yani hucrelere(cell) de <th> tag' ile ulasilir.
Basligin altindaki verilere <tbody> tag'i ile altindaki satirlara(row) <tr> tag'i ile
sutunlara yani hucrelere<td> tag'i ile ulasilir.
 */

    }
}
