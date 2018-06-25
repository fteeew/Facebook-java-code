
package facebook;
import static facebook.ConvertFileExtenssion.listOfFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream; 
import java.io.FileReader;
import java.io.IOException; 
import java.io.InputStream;
import java.io.InputStreamReader; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class FileToString {
    public static void main(String args[]) throws IOException {
        
       
      ArrayList<String> files = new ArrayList<String>();
      //هون الداريكتوري تاع الفايل اللي جواتو التكست فايل اللي طلعو من كلو كويري
      files=listOfFile("C:\\Users\\User\\Desktop\\Text Classiicationمشروع\\صحة");
       for(int i = 0; i < files.size(); i++)
      {
	  
        String m=convertFileToString(files.get(i));
        sentimentComment t=new sentimentComment();
        int c=i+1;
        t.write_to_excel(c,m);
            
      }
        
    
  
        
    
}
     public static String convertFileToString(String f) throws IOException{
                  
        String line;
        File file = new File(f);
        FileReader fr = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fr);
        String Wfile=" ";
        while((line = bufferedReader.readLine()) != null) {

            String lineWords[] = line.split(" ");
            String space=" ";
            for(String singleWord:lineWords) {
                
                Wfile=Wfile+""+singleWord;
                //System.out.print(singleWord); 
                Wfile= Wfile+""+space;
            }
           
        }
        return Wfile;
          
        
     }
   
        
        

   
    
}
