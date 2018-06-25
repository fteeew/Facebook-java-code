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


public class WriteComment {
    
    static HSSFWorkbook workbook = new HSSFWorkbook();
    static HSSFSheet sheet = workbook.createSheet("First Excel Sheet");
    public static int excel_count=0;
    
       public WriteComment(){
           
        
        HSSFRow row=sheet.createRow(0);
        HSSFCell cell1=row.createCell(0);
        cell1.setCellValue("post-id");
        HSSFCell cell2=row.createCell(1);
        cell2.setCellValue("Comment content");
        HSSFCell cell3=row.createCell(2);
        cell3.setCellValue("reaction count");
        excel_count=excel_count+1;
        
         
       }

        public WriteComment(Postcomment c) throws FileNotFoundException, IOException{ 
            
       
        System.out.println(excel_count);
        HSSFRow rowi=sheet.createRow(excel_count); 
        HSSFCell post_id=rowi.createCell(0);
        post_id.setCellValue(c.getPost_id());
        HSSFCell commentContent=rowi.createCell(1);
        commentContent.setCellValue(c.getComment_content());
        HSSFCell reaction_count=rowi.createCell(2);
        reaction_count.setCellValue(c.getReaction_count()); 
        try (FileOutputStream outputStream = new FileOutputStream("Books.xls")) {
            workbook.write(outputStream);
        }
    }
    
}
