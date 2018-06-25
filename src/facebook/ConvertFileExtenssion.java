
package facebook;
import static Facebook.Main.read_from_file;
import static facebook.GetCommentContent.getComment;
import static facebook.prepearingARFF.read;
import static facebook.prepearingARFF.write;
import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.*; 
import java.util.ArrayList;

public class ConvertFileExtenssion {
    
 public static boolean renameFileExtension(String source, String newExtension)
  {
    String target;
    String currentExtension = getFileExtension(source);

    if (currentExtension.equals("")){
      target = source + "." + newExtension;
    }
    else {
      target = source.replaceFirst(Pattern.quote("." +
          currentExtension) + "$", Matcher.quoteReplacement("." + newExtension));

    }
    return new File(source).renameTo(new File(target));
  }

  public static String getFileExtension(String f) {
    String ext = "";
    int i = f.lastIndexOf('.');
    if (i > 0 &&  i < f.length() - 1) {
      ext = f.substring(i + 1);
    }
    return ext;
  }
  
  public static ArrayList<String> listOfFile(String filepath) {
      
    File folder = new File(filepath);
    File[] listOfFiles = folder.listFiles();
    ArrayList<String> Files = new ArrayList<String>();
    for (int i = 0; i < listOfFiles.length; i++)
    {
        
       if (listOfFiles[i].isFile()) {
           
           String file_name=listOfFiles[i].getName();
           Files.add(file_name);
        } else if (listOfFiles[i].isDirectory()) {
            //System.out.println("Directory " + listOfFiles[i].getName());
        }
    }
    return Files; 
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
  

  public static void main(String args[]) throws Exception {
      
     
    ArrayList<String> files = new ArrayList<String>();
    //هون الداريكتوري تاع الفايل اللي جواتو التكست فايل اللي طلعو من كلو كويري
    files=listOfFile("C:\\Users\\User\\Desktop\\Text Classiicationمشروع\\صحة");
       for(int i = 0; i < files.size(); i++)
      {
	  //renameFileExtension(files.get(i), "arff");  
          //System.out.println(files.get(i));
            
      }
        
    
  }
}
