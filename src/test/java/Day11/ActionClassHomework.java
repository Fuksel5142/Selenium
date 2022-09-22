package Day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionClassHomework extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin  2- Hover over Me First" kutusunun ustune gelin
        driver.get("http://webdriveruniversity.com/Actions");
        Actions action=new Actions(driver);
        WebElement howtofirst=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        action.moveToElement(howtofirst).perform();
        //Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        //Popup mesajini yazdirin
        String popup=driver.switchTo().alert().getText();
        System.out.println(popup);
         //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        //"Click and hold" kutusuna basili tutun
        WebElement clickandhold=driver.findElement(By.xpath("//*[text()='Dont release me!!!']"));
        action.clickAndHold(clickandhold).perform();
        //7-"Click and hold" kutusunda cikan yaziyi yazdirin
        String click=driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[1]")).getText();
        System.out.println(click);
         //8- "Double click me" butonunu cift tiklayin
        WebElement doubleclick=driver.findElement(By.xpath("//h2"));
        action.contextClick(doubleclick).perform();
    }

}
