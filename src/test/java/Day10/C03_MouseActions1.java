package Day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_MouseActions1 extends TestBase {

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        String ilksayfaHandledegeri=driver.getWindowHandle();
        //3- Cizili alan uzerinde sag click yapalim
        WebElement cizilialan=driver.findElement(By.id("hot-spot"));
        Actions action=new Actions(driver);
        action.moveToElement(cizilialan).contextClick().perform();


    }

}
