package Day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        //-Turkce baskentler sutununu yazdiralim
        int turkceBaskent=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(turkceBaskent);
        String baskent="";
        for (int i = 0; i < turkceBaskent; i++) {
            baskent=C03_readexcel1.banadaGetir(i,2);
            System.out.println(baskent);

        }
}
}
