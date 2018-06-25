
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

public class Try {
    static HSSFWorkbook workbook = new HSSFWorkbook();
   static HSSFSheet sheet = workbook.createSheet("First Excel Sheet");
       public Try(){
           
        HSSFRow row=sheet.createRow(0);
        HSSFCell cell1=row.createCell(0);
        cell1.setCellValue("post-id");
        HSSFCell cell2=row.createCell(1);
        cell2.setCellValue("total count of reaction");
        HSSFCell cell3=row.createCell(2);
        cell3.setCellValue("reactions love");
        HSSFCell cell4=row.createCell(3);
        cell4.setCellValue("reactions haha");
        HSSFCell cell5=row.createCell(4);
        cell5.setCellValue("reactions wow");
        HSSFCell cell6=row.createCell(5);
        cell6.setCellValue("reactions sad");
        HSSFCell cell7=row.createCell(6);
        cell7.setCellValue("reactions angry");
        HSSFCell cell8=row.createCell(7);
        cell8.setCellValue("like count");
        HSSFCell cell9=row.createCell(8);
        cell9.setCellValue("share count");
        HSSFCell cell10=row.createCell(9);
        cell10.setCellValue("comments count");
        HSSFCell cell11=row.createCell(10);
        cell11.setCellValue("post content");
        HSSFCell cell12=row.createCell(11);
        cell12.setCellValue("positive_comment_count");
        HSSFCell cell13=row.createCell(12);
        cell13.setCellValue("negative_comment_count");
        HSSFCell cell14=row.createCell(13);
        cell14.setCellValue("negative_comment_reaction_count");
        HSSFCell cell15=row.createCell(14);
        cell15.setCellValue("positive_comment_reaction_count");
        HSSFCell cell16=row.createCell(15);
        cell16.setCellValue("positive_reaction_count");
        HSSFCell cell17=row.createCell(16);
        cell17.setCellValue("negative_reaction_count");
        HSSFCell cell18=row.createCell(17);
        cell18.setCellValue("positive signal");
        HSSFCell cell19=row.createCell(18);
        cell19.setCellValue("negative signal");
        HSSFCell cell20=row.createCell(19);
        cell20.setCellValue("old signal");
        HSSFCell cell21=row.createCell(20);
        cell21.setCellValue("label");
         
       }
        
       public static void write_to_excel(int i,post p) throws FileNotFoundException, IOException{ 
        
        HSSFRow rowi=sheet.createRow(i);
        HSSFCell post_id=rowi.createCell(0);
        post_id.setCellValue(p.getPost_id());
        HSSFCell total_count_of_reaction=rowi.createCell(1);
        total_count_of_reaction.setCellValue(p.getTotal_count_of_reaction());
        HSSFCell reactions_love=rowi.createCell(2);
        reactions_love.setCellValue(p.getReactions_love());
        HSSFCell reactions_haha=rowi.createCell(3);
        reactions_haha.setCellValue(p.getReactions_haha());
        HSSFCell reactions_wow=rowi.createCell(4);
        reactions_wow.setCellValue(p.getReactions_wow());
        HSSFCell reactions_sad=rowi.createCell(5);
        reactions_sad.setCellValue(p.getReactions_sad());
        HSSFCell reactions_angry=rowi.createCell(6);
        reactions_angry.setCellValue(p.getReactions_angry());
        HSSFCell like_count =rowi.createCell(7);
        like_count.setCellValue(p.getLike_count());
        HSSFCell share_count =rowi.createCell(8);
        share_count.setCellValue(p.getShare_count());
        HSSFCell comments_count =rowi.createCell(9);
        comments_count.setCellValue(p.getComments_count());  
        HSSFCell post_content =rowi.createCell(10);
        post_content.setCellValue(p.getPost_content()); 
        HSSFCell positive_comment_count =rowi.createCell(11);
        positive_comment_count.setCellValue(p.getPositive_comment_count()); 
        HSSFCell negative_comment_count =rowi.createCell(12);
        negative_comment_count.setCellValue(p.getNegative_comment_count()); 
        HSSFCell negative_comment_reaction_count =rowi.createCell(13);
        negative_comment_reaction_count.setCellValue(p.getNegative_comment_reaction_count()); 
        HSSFCell positive_comment_reaction_count =rowi.createCell(14);
        positive_comment_reaction_count.setCellValue(p.getPositive_comment_reaction_count()); 
        HSSFCell positive_reaction_count =rowi.createCell(15);
        positive_reaction_count.setCellValue(p.getPositive_reaction_count()); 
        HSSFCell negative_reaction_count =rowi.createCell(16);
        negative_reaction_count.setCellValue(p.getNegative_reaction_count());
        HSSFCell positive_signal =rowi.createCell(17);
        positive_signal.setCellValue(p.getPositive_signal());
        HSSFCell negative_signal =rowi.createCell(18);
        negative_signal.setCellValue(p.getNegative_signal());
        HSSFCell old_signal =rowi.createCell(19);
        old_signal.setCellValue(p.getOld_signal());
        HSSFCell label =rowi.createCell(20);
        label.setCellValue(p.getLabel());
        try (FileOutputStream outputStream = new FileOutputStream("JavaBooks.xls")) {
            workbook.write(outputStream);
        }
    }
}

