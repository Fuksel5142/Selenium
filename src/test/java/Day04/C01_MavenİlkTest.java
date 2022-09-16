package Day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenİlkTest {
    /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
       //“Samsung headphones” ile arama yapalim
        aramakutusu.sendKeys("Samsung headphones"+Keys.ENTER);
        // 4- Bulunan sonuc sayisini yazdiralim
        WebElement sonuc= driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-fixed-height'])[1]"));
        System.out.println(sonuc.getText());
        Thread.sleep(3000);
        //Ilk urunu tiklayalim
        sonuc.click();
        //Sayfadaki tum basliklari yazdiralim
        List<WebElement> urunListesi = driver.findElements(By.cssSelector("div[class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        String[]arr=urunListesi.get(0).getText().split(" ");
        System.out.println(arr[2]);
        String sonucyazisi=urunListesi.get(0).getText();
        Arrays.stream(sonucyazisi.split(" ")).limit(3).skip(2).forEach(System.out::println);


    }
}
