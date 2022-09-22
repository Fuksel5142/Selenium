package Day12;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_Actions extends TestBase {

    @Test
    public void test1() {
        //Automationexercise.com sitesine gidelim
        driver.get("https://www.automationexercise.com");
        //Product bölümğne girelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
          //ilk urunu secelim
        driver.findElement(By.cssSelector("img[alt=\"ecommerce website products\"]")).click();


    }
}
