package Day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Faker extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        /*
        "https://facebook.com"  Adresine gidin
“create new account”  butonuna basin
“firstName” giris kutusuna bir isim yazin
“surname” giris kutusuna bir soyisim yazin
“email” giris kutusuna bir email yazin
“email” onay kutusuna emaili tekrar yazin
Bir sifre girin
Tarih icin gun secin
Tarih icin ay secin
Tarih icin yil secin
Cinsiyeti secin
Kaydol butonuna basın
Sayfayi kapatin
         */
        driver.get("https://facebook.com");
        //create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //firstName” giris kutusuna bir isim yazin
        Actions action=new Actions(driver);
        Faker faker=new Faker();
        WebElement isimKutusu=driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        String fakerMail=faker.internet().emailAddress();
        action.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakerMail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(3000);


    }
}
