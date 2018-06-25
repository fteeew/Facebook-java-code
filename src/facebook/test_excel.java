
package facebook;
import static Facebook.Main.read_from_file;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class test_excel {
    public void readExcel() throws BiffException, IOException {
        
		String FilePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\Facebook\\culture_comment\\انخفاض الكوليسترول.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
                ArrayList<String> neww = new ArrayList<String>();
                neww=read_from_file("C:\\Users\\User\\Documents\\NetBeansProjects\\Facebook\\culture\\انخفاض الكوليسترول.txt");
		// TO get the access to the sheet
		Sheet sh = wb.getSheet("First Excel Sheet");
		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();
		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();
                int negative_counter=0;
                int positive_counter=0;
                int total_count_positive=0;
                int total_count_negative=0;
                for(int i = 0; i < neww.size(); i++)
                {
                    System.out.println("post:"+neww.get(i));
                    for (int row = 0; row < totalNoOfRows; row++)
                    {

			if(sh.getCell(0,row).getContents().equals(neww.get(i)))
                        {
			    if(sh.getCell(3,row).getContents().equals("negative"))
                            {
                                negative_counter=negative_counter+1;
                                total_count_negative+=Integer.parseInt(sh.getCell(2,row).getContents());
                                
                            }
                            else
                            {
                                 positive_counter= positive_counter+1;
                                 total_count_positive+=Integer.parseInt(sh.getCell(2,row).getContents());
                            }
                        }
                    }
                    System.out.println("neg:"+negative_counter);
                    System.out.println("pos:"+positive_counter);
                    System.out.println("neg reaction:"+total_count_negative);
                    System.out.println("pos reaction:"+total_count_positive);
                    negative_counter=0;
                    positive_counter=0;
                    total_count_positive=0;
                    total_count_negative=0;
                    
                }
	}
     
  

	public static void main(String args[]) throws BiffException, IOException, Exception {
		test_excel DT = new test_excel();
		DT.readExcel();
                
	}
    
}
