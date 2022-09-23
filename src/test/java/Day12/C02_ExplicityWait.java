package Day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicityWait extends TestBase {
    @Test
    public void test() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textbox.isEnabled());
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textbox));// orası etkin mi
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement element=driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
        Assert.assertTrue(element.isDisplayed());
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textbox.isEnabled());
            /*

    Senkronize etmekten kasıt bilgisayar, internet sayfasinın hızını kodlarimizda eş zamanli çalışmasini sağlamaktir.
    Bunun için 3 tane bekletme yolu vardir.

    1-- Thread.sleep ---> Java tabanli wait. seleniumda yoktur. javadan kullaniriz.

    2-- implicitly wait ---> Selenium tabanli. site içerisinde elementlerin yüklenmesini beklemek için kullanilir.
    Bu kod sayfa acilmadiysa verilen sure kadar bekler ve sayfa içerisinde çalışırken karşılaştığı yüklenmemis elementleri de
    yüklenene kadar verilen süre kadar bekler.
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    3-- Explicitly wait --> istediğimiz bir element için koşul gerçekleşene kadar bekler
    Özellikle bekletmek istediğimiz elementlerin öncesinde ayarladığımız sure ve koşuldur.Koşul gerçekleşince surenin dolmasini beklemez.
    Aslinda wait kullandiğmiz elementten once o element yüklenene kadar şu kadar süre içerisinde ve şu şart gerçekleşene
    kadar bekle demektirdir.
    örneğin; dosya indirilene kdar bekle, veya dosyanin inmesini 15 sn bekle gibi...
       --> her element yada işlem için oncesinde yapilir.

       oluşturmak için (1)wait objesi yapariz. --> WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
       --> sonrasinda 2. satirda (2) wait.until() yazarak parantez içine ExpectedConditions + nokta basarak uygun şartı belirleriz.
       --> koşulların parantez içine --wait.until(ExpectedConditions.elementToBeClickable(enableKutusu);--
       webelement gibi şeyler yazmak gerekebilir.

       Ornegin;
        wait.until(ExpectedConditions.alertIsPresent()); -->
        wait.until(ExpectedConditions.elementToBeClickable(enableKutusu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("locate adresi"));
       wait.until(ExpectedConditions.refreshed();

        Birde ek olarak FluentWait vardir. o da her 2 saniyede bir çalışmayı dene demektir. dosya indi mi inmedi mi diye loop yapiyor denebilir.






                Cookies
                2 çeşittir.
                1) oturum çerezi -  bizim ip gibi bilgilerimizi serverda tutup bir daha bize soru sormuyor.
                Oturum çerezleri yalnızca bir web sitesinde gezinirken kullanılır.
                Bunlar rastgele erişimli bellekte saklanır ve hiçbir zaman sabit sürücüye yazılmaz.
                Oturum sona erdiğinde oturum çerezleri otomatik olarak silinir.

                2) kalıcı çerezler - Kalıcı çerezler bir bilgisayarda sonsuza kadar kalır
                ancak birçoğunun bir son kullanma tarihi olup bu tarihe gelindiğinde otomatik olarak kaldırılırlar.

                *** Üçüncü taraf çerezler daha sıkıntılıdır. Bunlar, genellikle kullanıcıların halihazırda
                gezindiği web sayfalarındaki reklamlarla bağlantılı olduklarından bu sayfalardan farklı
                web siteleri tarafındanoluşturulur.

     */



    }
}
