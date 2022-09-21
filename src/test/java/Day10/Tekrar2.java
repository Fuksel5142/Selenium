package Day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Tekrar2 extends TestBase {
    @Test
    public void test01(){
       //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragmeElement =driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dragmeElement2 =driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragmeElement, dragmeElement2).perform();
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement Droppedtext= driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedyazi="Dropped!";
        String actualyazi=Droppedtext.getText();
        Assert.assertEquals(actualyazi,expectedyazi);



    }
}
