package Day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExist {
    @Test
    public void test1() {
        System.out.println(System.getProperty("user.dir"));//şu anki içinde bulunduğu yolu gösterir
        System.out.println(System.getProperty("user.home"));// Geçerli kullanıcın ana dizinini verir
        String farklıbolum=System.getProperty("user.home");
        //"C:\Users\ASUS\Desktop\tezt.txt" --> masa üstündeki dosyanın yolu
        String dosyayolu="C:\\Users\\ASUS\\Desktop\\text.txt";
        System.out.println(Files.exists(Paths.get(dosyayolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));
        /*
        Bir web sitesinden indirdiğmiz yada windows içinde oluşturduğumuz dosyanın indiğini yada orda olduğunu
        test edebilmem için o dosyanın üzerine shift tuşuna basılı olarak sağ klik yapıp dosyanın yolunu kopyalayıp
        bir string değişkenine atarız ve dosyayı doğrulamak için
        Assert.assertTrue(files.exists(Paths.get(dosyayolu))); bu methodu kullanırız
         */

    }
}
