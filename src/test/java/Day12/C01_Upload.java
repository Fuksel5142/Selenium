package Day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Upload extends TestBase {
    @Test
    public void test1() {

        ///https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement UploadButton = driver.findElement(By.xpath("//input[@id='file-upload']"));
        //Yuklemek istediginiz dosyayi secelim.
        UploadButton.sendKeys("C://Users//ASUS//Downloads/sampleFile.jpeg");
        //Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@class='button']")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileuploadf= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(fileuploadf.isDisplayed());

    }
}
