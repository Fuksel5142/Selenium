package Day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test(){
        //amazon git
        driver.get("https://amazon.com");
        // accont menusunden create a list linkiine tıklayalım
        Actions action=new Actions(driver);
        WebElement accounLink=driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        action.moveToElement(accounLink).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }

}
