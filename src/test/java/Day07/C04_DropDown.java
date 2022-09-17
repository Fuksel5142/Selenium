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

public class C04_DropDown {
   /* Bir class oluşturun: DropDown
    https://the-internet.herokuapp.com/dropdown adresine gidin.
    Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Tüm dropdown değerleri(value) yazdırın
    Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.
*/

    WebDriver driver;
    Select select;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1() {

        WebElement optionBoxs=driver.findElement(By.xpath("//select[@id='dropdown'][1]"));
        Select select=new Select(optionBoxs);
        //1. Index kullanarak Secenek 1'i (Option 1) secin ve yazdirin
        select.selectByIndex(1); //sectik
        System.out.println(select.getFirstSelectedOption().getText()); // bir onceki adimda sectigimizi yazdiriyoruz
        // 2. Value kullanarak Secenek 2'yi (Option 2) secin ve yazdirin
        select.selectByValue("2");// direl value değeri ile oluyor
        System.out.println(select.getFirstSelectedOption().getText());
        // 3. Visible Text(Gorunen metin) kullanarak Secenek'i (Option) secin ve yazdirin
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> drops=select.getOptions();
        for (WebElement drop : drops) {
            System.out.println(drop.getText());
        }
        // drops.forEach(t-> System.out.println(t.getText()));
        int dropdownboyut=select.getOptions().size();
      if(dropdownboyut==4){
          System.out.println("True");
      }else System.out.println("False");
      Assert.assertNotEquals(drops.size(),4);

    }
}
