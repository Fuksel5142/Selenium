package Day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Tekrar extends TestBase {

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // 3- Cizili alan uzerinde sag click yapalim
        WebElement cizilialan=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions action=new Actions(driver);
        action.moveToElement(cizilialan).contextClick().perform();
        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedyazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertTrue(actualYazi.contains(expectedyazi));
        // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //  Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> windowhandle=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowhandle.get(1));
        String expextedyazi="Elemental Selenium";
        String actualyazi=driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actualyazi,expextedyazi);



    }
}
