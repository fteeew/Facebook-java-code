
package facebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class prepearingARFF {
    public static void main(String args[]) throws Exception {
        ArrayList<String> f = new ArrayList<String>();
       
        f=read("positive.txt");
        for(int i=0;i<f.size();++i)
        {
          
           String newString = f.get(i).replaceAll("[^a-zA-Z]","");
            write("New Text Document.txt",newString);
        }
       
    
      }
     public static void write(String file,String post_Content) throws IOException{
         
        PrintWriter out = null;
        BufferedWriter bufWriter;

        bufWriter = Files.newBufferedWriter(Paths.get(file),
                Charset.forName("UTF8"),
                StandardOpenOption.WRITE, 
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE); //Oh, no! Failed to create PrintWriter
        out = new PrintWriter(bufWriter, true);

        //After successful creation of PrintWriter
        String m=",1";
        out.println('"' +m+ '"');
        out.print('"' + post_Content + '"');
       
        
       
        
        //After done writing, remember to close!
        out.close();
    
    }
     public static ArrayList<String> read(String filepath) throws FileNotFoundException, IOException {
         
      FileInputStream fstream = new FileInputStream(filepath);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        ArrayList<String> Lines = new ArrayList<String>();
        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   
        {
            // Print the content on the console
            Lines.add(strLine);
        }

        //Close the input stream
        br.close();
  
       return Lines; 
  }
  
}
