package Day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class İframe02 {
      /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest

       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
     */
      WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        //driver.close();

    }
    @Test
    public void test1 () throws InterruptedException {
        // https://html.com/tags/iframe/ adresine gidiniz
        // YouTube videosunu calistiriniz
        driver.get(" https://the-internet.herokuapp.com/iframe");
        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement İframeYazi= driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(İframeYazi.isDisplayed());
        System.out.println(İframeYazi.getText());
        //      ○ Text Box’a “Merhaba Dunya!” yazin.
        // textbox'i dogru olarak locate etmemize ragmen driver bulamadi
        // bunun uzerine HTML kodlari inceleyince
        // textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
        // bu durumda once iframe'i locate edip
        // switchTo() ile o iFrame'e gecmeliyiz
        WebElement iFrameElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);//locate ettiğimiz frame e geçmek için bu kullanılır
        WebElement textkutusu= driver.findElement(By.xpath("//p"));
        textkutusu.clear();
        Thread.sleep(3000);
        textkutusu.sendKeys("Mehaba Dunya");
        //      ○ TextBox’in altinda bulunan “Elemental Selenium”
        //      linkinin textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();//frameden cıkmak lazim
        WebElement elemantal=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemantal.isDisplayed());
        System.out.println(elemantal.getText());
        // link yazi elementini dogru locate etmemize ragmen yazdirmadi
        // cunku yukarida iFrame'e gecis yapmistik
        // once oradan cikmamiz lazim
        /*
        - driver.switchTo() methodu ile geçilebilecek 3 farklı yapı vardır:
    1) alert
    2) iframe
    3) window (sonraki konu)

- Bir websitesi içinde farklı bir websitesi olabilir (embedded).

- Iframe genellkikle bir web sayfasına doküman, video veya interaktif medya gibi
  başka bir kaynaktan içerik eklemek için kullanılır.

- <iframe> tag'ı bir inline frame belirtir.

- iframe tagı'ı bulunan web sayfalarında locate işlemi yapabilmek için iframe'i handle etmek gerekir.

- Diğer bir deyişle, bir web sayfasında doğruluğundan emin olduğumuz bir locate işlemi varsa
  ancak bu düzgün çalışmıyorsa, SAYFADA IFRAME TAG'I BULUNUP BULUNMADIĞINI KONTROL ETMEMİZ GEREKİR.
  Bu durumda, önce iframe'i locate edip switchTo() method'u ile geçiş yapmamız gerekir.

- Bir web sayfasında iframe varsa switchTo() method'unu kullanmak gerekir.
  switchTo() method'u ile iframe'e geçmenin 3 yolu vardır:

    1) index ile
        driver.switchTo().frame(index of the iframe);   //index 0'dan başlar

    2) id veya name value ile
        driver.switchTo().frame("id of the frame");

    3) WebElement ile
        driver.switchTo().frame(WebElement of the iframe);

- iframe'den çıkmak için 2 komut vardır:

    1) driver.switchTo( ).parentFrame( ); ===> 1 ust seviyedeki frame'e cikartir

    2) driver.switchTo( ).defaultContent( ); ===> En ustteki frame'e cikmak icin kullanilir

- Birden fazla iframe varsa gecislerde dikkatli olmak lazim.
  Gecisler her zaman basit olamayabilir
         */

    }

}
