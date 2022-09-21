package Day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDownload extends TestBase {
    @Test
    public void test01() {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        WebElement text = driver.findElement(By.xpath("//*[text()='test.txt']"));
        text.click();
        String dosyayolu ="C:\\Users\\ASUS\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));
        //indirildiğini konsolda gösterin
        System.out.println(Files.exists(Paths.get(dosyayolu)));
    }
}
