package Day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_Allert {
    /*
    Bir class olusturun: Alerts
https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
Bir metod olusturun: acceptAlert
1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
Bir metod olusturun: dismissAlert
2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin.
Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */
    WebDriver driver;
    Select select;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public  void test1(){
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

    }
    @Test
    public  void test2() throws InterruptedException {
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String result1 = result.getText();
        String result2 = "You successfully clicked an alert";
        Assert.assertEquals(result2,result1);
    }
    @Test
    public  void dismissAlert() throws InterruptedException {
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        System.out.println("alert mesajını yazısı"+driver.switchTo().alert().getText());
        WebElement result = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualmessage = result.getText();
        String expextedm = "successfully ";
        Assert.assertFalse(actualmessage.contains(expextedm) );
    }
    @Test
    public  void sendKeysAlert() throws InterruptedException {
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);
        System.out.println("3.butonun alert mesaji"+driver.switchTo().alert().getText());
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Fatih");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        String actualmessage = driver.findElement(By.xpath("//*[text()='You entered: Fatih']")).getText();
        String expextedmessage ="Fatih";
        Assert.assertTrue(actualmessage.contains(expextedmessage));




    }

}
/*
--alert icindeki mesajı almak icin
driver.switchTo().alert().getText();

--alert bizden bir metin istiyorsa
driver.switchTo().alert().sendKeys("");
 */