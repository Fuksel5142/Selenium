package Day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_readexcel1 {
    @Test
    public void readExceltesti() throws IOException {
        // input olarak verilen
        // satirNo, sutunNo degerlerini parametre olarak alip
        // O cell'deki datayi String olarak bana donduren bir method olusturun
        int satirNo=12;
        int sutunNo=2;
        // donen String'in Cezayir oldugunu test edingeggeg
        String expectedData="Baku";
        String actualData= banadaGetir(satirNo-1,sutunNo-1);
        Assert.assertEquals(expectedData, actualData);
        System.out.println(actualData);
}

    public static String banadaGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData="";
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        istenenData = workbook.getSheet("Sayfa1").getRow(satirIndex).getCell(sutunIndex).toString();
        return istenenData;
    }
    }
