package Day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;

public class C02_ReadExcel {
    @Test
    public void testReadExcel() throws Exception {
        //7. Dosya yolunu bir String degiskene atayalim
        String DosyaYolu="src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(DosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
        String actualdata= workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();
        System.out.println(actualdata);

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        //12. Row objesi olusturun sheet.getRow(index)
        //13. Cell objesi olusturun row.getCell(index
    }
}
