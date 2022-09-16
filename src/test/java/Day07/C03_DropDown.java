package Day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown(){
        //driver.close();

    }
    @Test
    public void test1(){
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        /*
        DropDown menuye ulasmak icin select class'indan bir obje olustururuz
        ve locate ettigimiz dropdown webelement'inin select class'ina tanimlariz
        ve getOption methodunu kullanarak dropdown'u bir liste atarak dropdown menunun
        butun elemanlarının sayısına ulasabiliriz
        */
        List<WebElement> ddmlist=select.getOptions();
        System.out.println(ddmlist.size());

        int expectedSayi=45;
        int actualDds=ddmlist.size();
        Assert.assertNotEquals(expectedSayi,actualDds);
    }
}
