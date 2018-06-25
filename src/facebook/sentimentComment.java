
package facebook;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Workbook;

public class sentimentComment {
    static HSSFWorkbook workbook = new HSSFWorkbook();
   static HSSFSheet sheet = workbook.createSheet("First Excel Sheet");
       public  sentimentComment(){
           
        HSSFRow row=sheet.createRow(0);
        HSSFCell cell1=row.createCell(0);
        cell1.setCellValue("sentence");
        HSSFCell cell2=row.createCell(1);
        cell2.setCellValue("class");
        HSSFCell cell3=row.createCell(2);
        
       }
       public static void write_to_excel(int i,String sent) throws FileNotFoundException, IOException{ 
        
        HSSFRow rowi=sheet.createRow(i);
        HSSFCell s=rowi.createCell(0);
        s.setCellValue(sent);
        HSSFCell c=rowi.createCell(1);
        c.setCellValue("Health");
        try (FileOutputStream outputStream = new FileOutputStream("JavaBooks.xls")) {
            workbook.write(outputStream);
        }
    }
    
}
