package Day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        Map<String,String> ulkelerMap= new HashMap<>();
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        //Excel tablosundaki tüm tabloyu konsola yazdırınız
        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <=sonSatirIndex ; i++) {
            // key i. satirdaki 0 indexindeki data olacak
            String key= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            // value ise i. satirdaki 1,2 ve 3. indexdeki datalarin birlesimi olacak
            String value= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);
        /*
          int last=workbook.getSheet("Sayfa1").getLastRowNum()+1;
          for (int i = 0; i < last; i++) {
          System.out.print(""+workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString()+" - "+
          workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+" - "+
          workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+" - "+
          workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
          System.out.println();
         */
    }
}
