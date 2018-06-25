package Facebook;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws IOException {

		//ArrayList<String> PostIDs = new ArrayList<String>();
		//ParsingForID parse=new ParsingForID();
	        //PostIDs=parse.getPage_PostID();
		//write_to_file(PostIDs);
	        ArrayList<String> neww = new ArrayList<String>();
		neww=read_from_file("C:\\Users\\User\\Documents\\NetBeansProjects\\Facebook\\culture\\تخثر الدم.txt");
		AccessToken access=new AccessToken();
		for(int i = 0; i < neww.size(); i++)
                {
			   
                    System.out.println(neww.get(i)+"\n");
                    String returnAccess=access.getAccessToken(neww.get(i));
                    System.out.println(neww.get(i)+"\n");
                    System.out.println("return access="+returnAccess+"\n");
			 
	        }
		//GetComments comments=new GetComments();
//	comments.getComments();
		
		}
	
	
		public static void write_to_file(ArrayList<String> page_PostIDs)throws IOException  {
			BufferedWriter writer = new BufferedWriter(new FileWriter("write.txt"));
			FileWriter fileWriter = new FileWriter("write.txt");
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    
		    for(int i = 0; i < page_PostIDs.size(); i++){
		   
		    	 printWriter.println(page_PostIDs.get(i));
		    	
			     //writer.write(page_PostIDs.get(i) + "\n");
		        
		     }
		    System.out.print(" write to file done successfully.\n");
		    printWriter.close();
	
	}
	public static ArrayList<String> read_from_file(String filpath)throws IOException {
		
		Scanner s = new Scanner(new File(filpath));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.next());
		}
		s.close();
		return list;
		}

}
