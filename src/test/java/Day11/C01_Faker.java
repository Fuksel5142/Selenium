package Day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {
    @Test
    public void test01(){
        //https://www.amazon.com sayfasina gidelim
        driver.get("https://amazon.com");
        //Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Actions action = new Actions(driver);
        action.click(SearchBox).sendKeys("s")
                .sendKeys("a").sendKeys("m")
                .sendKeys("s").sendKeys("u")
                        .sendKeys("n").sendKeys("g").sendKeys(" ")
                .keyDown(Keys.SHIFT).sendKeys("a")
                .keyUp(Keys.SHIFT).sendKeys("7")
                .sendKeys("1").sendKeys(Keys.ENTER).perform();
       // aramanin gerceklestigini test edin
    }
}
