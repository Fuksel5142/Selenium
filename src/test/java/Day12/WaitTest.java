package Day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class WaitTest extends TestBase {
    @Test
    public void imlicityWaitTest1() {
          // 1. Bir class olusturun : WaitTest
          // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
          //    Iki metod icin de asagidaki adimlari test edin.
          // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls ");
        // 4. Remove butonuna basin.
        WebElement removeWE = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeWE.click();
          // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebElement removee = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue( removee.isDisplayed());
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
            // 7. It's back mesajinin gorundugunu test edin
        WebElement back = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(back.isDisplayed());
    }
    @Test
    public void explicityWaitTest2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls ");
        // 4. Remove butonuna basin.
        WebElement removeWE = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeWE.click();
        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGone.isDisplayed());
        //implicitly wait testten once calsitirilir ve calistirilan testin tamamina etki eder
        //explicitly wait ise once obje olarak olusturulur sonra
        // sadece kullanildigi yerde ve belirlenen sarta gore calisir class yada test in tamamina uygulanmaz
        //Add butonuna basın
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        // 7. It's back mesajinin gorundugunu test edin
        WebElement istsBackMe=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(istsBackMe.isDisplayed());


    }
}
