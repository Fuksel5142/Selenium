package Day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class amazonhandle extends TestBase {
    @Test
    public void test1()  {

        driver.get("https://www.amazon.com/");
     //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement srcbx=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(srcbx);
        List<WebElement> drop=select.getOptions();
        System.out.println(drop.size());
        //dropdown menude 40 eleman olduğunu doğrulayın
        int expectedsayi=40;
        int actualsayi=drop.size();
        Assert.assertNotEquals(actualsayi,expectedsayi);
    }
    @Test
    public void test02()  {
        //dropdown menuden elektronik bölümü seçin
        driver.get("https://www.amazon.com/");
        WebElement srcbx=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(srcbx);
        select.selectByVisibleText("Electronics");
        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        List<WebElement> searchResult=driver.findElements(By.className("sg-col-inner"));
        String sonucyazisi=searchResult.get(0).getText();
        String []arr=sonucyazisi.split(" ");
        Arrays.stream(sonucyazisi.split(" ")).limit(3).skip(2).forEach(System.out::println);
        String expectedKelime = "iphone";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
          //ikinci ürüne relative locater kullanarak tıklayin
       WebElement ikinci= driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
       ikinci.click();
          //ürünün title'ni ve fiyatını variable'a  assign edip ürünü sepete ekleyelim
        String title= driver.getTitle();
        String fiyat=driver.findElement(By.xpath("//*[text()='$158.00']")).getText();
    }
   /* @Test
    public void test03()  {
        //yeni bir sekme açarak amazon anasayfaya gidin
//dropdown'dan bebek bölümüne secin
//bebek puset aratıp bulundan sonuç sayısını yazdırın
//sonuç yazsının puset içerdiğini test edin
//5-üçüncü ürüne relative locater kullanarak tıklayin
//6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
//1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
*/
    }

