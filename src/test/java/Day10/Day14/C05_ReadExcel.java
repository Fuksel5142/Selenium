package Day10.Day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        //-WorkbookFactory.create(fileInputStream)
        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin
        int sonSatirIndex=workbook
                .getSheet("Sayfa2")
                .getLastRowNum();
        int expectedSatirsayisi=6;
        System.out.println(sonSatirIndex);
        Assert.assertNotEquals(expectedSatirsayisi,sonSatirIndex);
        int kullanilanSatirsayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        int expectedactualSatirsayisi=3;
        Assert.assertNotEquals(kullanilanSatirsayisi,expectedactualSatirsayisi);

    }
}
