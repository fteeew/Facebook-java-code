
package facebook;
import static Facebook.Main.read_from_file;
import com.restfb.Connection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.json.JsonObject;
import com.restfb.json.JsonWriter;
import com.restfb.types.Comment;
import com.restfb.types.Post;
import com.restfb.types.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class getReaction{
   
    public static void main(String[] args) throws IOException, BiffException, Exception
    {
       
        ArrayList<String> neww = new ArrayList<String>();
        // التكست فايل اللي جواتو البوست اي دي 
	neww=read_from_file("C:\\Users\\User\\Documents\\NetBeansProjects\\Facebook\\culture\\انخفاض الكوليسترول.txt");
        
        for(int i = 0; i < neww.size(); i++)
        {
	    System.out.println("post id:"+neww.get(i)+":");
            //فايل الكومنتات
            String CommentExcelFilePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\Facebook\\culture_comment\\انخفاض الكوليسترول.xls";
            String PostExcelFilePath="C:\\Users\\User\\Documents\\NetBeansProjects\\Facebook\\culture posts\\انخفاض الكوليسترول.xls";
            post postt=new post();
            postt=getAll(neww.get(i),CommentExcelFilePath,PostExcelFilePath);
            int c=i+1;
            Try t=new  Try();
            t.write_to_excel(c,postt);
            //System.out.println(postt.getComments_count());
            	 
	}
        
    }
   public static post getAll(String postId,String CommentExcelFilePath,String PostExcelFilePath) throws IOException, BiffException, Exception {
        int positive_reaction_count=0;
        int negative_reaction_count=0;
        int old_signal=0;
        int positive_signal=0;
        int negative_signal=0;
        post p=new post();
        p.setPost_id(postId);
        String accessToken="EAACEdEose0cBAJ5DL0t9wcRSZAL0SP7GV0vnmj1LQNZCr96697uvn8p2VAKitzWTk7kXoBnseJDu7J1Iw9gqcghaYP3Qog0R3HPBs37JsRoC6ykNyzLux3SofSC5XZCEuBq2i9bd9idvG60x0qIwRYNru5WB5bdhuBBCC0s9hI84YyT3PPdvh5rC7DGISAZD";
        FacebookClient fbClient = new DefaultFacebookClient(
        "EAACEdEose0cBAJ5DL0t9wcRSZAL0SP7GV0vnmj1LQNZCr96697uvn8p2VAKitzWTk7kXoBnseJDu7J1Iw9gqcghaYP3Qog0R3HPBs37JsRoC6ykNyzLux3SofSC5XZCEuBq2i9bd9idvG60x0qIwRYNru5WB5bdhuBBCC0s9hI84YyT3PPdvh5rC7DGISAZD");
       
        //+++++++++++++++++++++++++++
       //get total number of reation wow+sad+angry+like+love+haha
       JsonObject reactions = fbClient.fetchObject("v2.12/" + postId,JsonObject.class,Parameter.with("fields","reactions.summary(1)"));
        String reac=reactions.toString();
        String b23=getReactionCount(reac);
        //System.out.println("total number of reaction= "+b23);
        p.setTotal_count_of_reaction(b23);
       //+++++++++++++++++++++
        JsonObject r1 = fbClient.fetchObject("v2.12/" + postId,JsonObject.class,Parameter.with("fields","reactions.type(LOVE).limit(0).summary(total_count).as(reactions_love)"));
        //System.out.println(r1);
        String n1=r1.toString();
        String b1=getReactionCount(n1);
        //System.out.println("reactions_love= "+b1);
        p.setReactions_love(b1);
        positive_signal+=Integer.parseInt(b1);
        positive_reaction_count+=Integer.parseInt(b1);
       //+++++++++++++++
        JsonObject r3 = fbClient.fetchObject("v2.12/" + postId,JsonObject.class,Parameter.with("fields","reactions.type(HAHA).limit(0).summary(total_count).as(reactions_haha)"));
        //System.out.println(r3);
        String n=r3.toString();
        String b=getReactionCount(n);
        //System.out.println("reactions_haha= "+b);
        p.setReactions_haha(b);
        positive_signal+=Integer.parseInt(b);
        positive_reaction_count+=Integer.parseInt(b);
       //+++++++++++++++
        JsonObject r2 = fbClient.fetchObject("v2.12/" + postId,JsonObject.class,Parameter.with("fields","reactions.type(WOW).limit(0).summary(total_count).as(reactions_WOW)"));
      //  System.out.println(r2);
        String n3=r2.toString();
        String b3=getReactionCount(n3);
       // System.out.println("reactions_wow= "+b3);
        p.setReactions_wow(b3);
        positive_signal+=Integer.parseInt(b3);
        positive_reaction_count+=Integer.parseInt(b3);
        //+++++++++++++++
        JsonObject r4 = fbClient.fetchObject("v2.12/" + postId,JsonObject.class,Parameter.with("fields","reactions.type(SAD).limit(0).summary(total_count).as(reactions_sad)"));
      //  System.out.println(r4);
        String n4=r4.toString();
        String b4=getReactionCount(n4);
       // System.out.println("reactions_sad= "+b4);
        p.setReactions_sad(b4);
        negative_signal+=Integer.parseInt(b4);
        negative_reaction_count+=Integer.parseInt(b4);
        //++++++++++++
        JsonObject r5 = fbClient.fetchObject("v2.12/" + postId,JsonObject.class,Parameter.with("fields","reactions.type(ANGRY).limit(0).summary(total_count).as(reactions_angry)"));
       // System.out.println(r5);
        String n5=r5.toString();
        String b5=getReactionCount(n5);
        //System.out.println("reactions_angry="+b5);
        p.setReactions_angry(b5);
        negative_signal+=Integer.parseInt(b5);
        negative_reaction_count+=Integer.parseInt(b5);
        ///
        Post post1=fbClient.fetchObject(postId, Post.class, Parameter.with("fields", "from,to,likes.limit(0).summary(true),comments.limit(0).summary(true),shares.limit(0).summary(true)"));
        //System.out.println("Likes count= " + post1.getLikesCount()); 
        p.setLike_count(""+post1.getLikesCount());
        old_signal+=Integer.parseInt(""+post1.getLikesCount());
       // System.out.println("Shares count= " + post1.getSharesCount());
        p.setShare_count(""+post1.getSharesCount());
        old_signal+=Integer.parseInt(""+post1.getSharesCount());
        //System.out.println("Comments count= " + post1.getCommentsCount());
        p.setComments_count(""+post1.getCommentsCount());
        old_signal+=Integer.parseInt(""+post1.getCommentsCount());
        Post p22=fbClient.fetchObject(postId, Post.class, Parameter.with("fields","message"));  
        if(p22.getMessage()!=null)
        {
            String p_content=removePunctuations(p22.getMessage());
            System.out.println(p_content);
            p.setPost_content(p_content);
        }
        p.setNegative_reaction_count(""+negative_reaction_count);
        p.setPositive_reaction_count(""+positive_reaction_count);
	FileInputStream fs = new FileInputStream(CommentExcelFilePath);
	Workbook wb = Workbook.getWorkbook(fs);
        Sheet sh = wb.getSheet("First Excel Sheet");
	// To get the number of rows present in sheet
	int totalNoOfRows = sh.getRows();
	// To get the number of columns present in sheet
	int totalNoOfCols = sh.getColumns();
        int negative_counter=0;
        int positive_counter=0;
        int total_count_positive=0;
        int total_count_negative=0;
            for (int row = 0; row < totalNoOfRows; row++)
            {

			if(sh.getCell(0,row).getContents().equals(postId))
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
                   // System.out.println("neg:"+negative_counter);
                    p.setNegative_comment_count(""+negative_counter);
                    negative_signal+=negative_counter;
                    //System.out.println("pos:"+positive_counter);
                    p.setPositive_comment_count(""+positive_counter); 
                    positive_signal+=positive_counter;
                    //System.out.println("neg reaction:"+total_count_negative);
                    p.setNegative_comment_reaction_count(""+total_count_negative);
                    negative_signal+=total_count_negative;
                    //System.out.println("pos reaction:"+total_count_positive);
                    p.setPositive_comment_reaction_count(""+total_count_positive);
                    positive_signal+=total_count_positive;
                    negative_counter=0;
                    positive_counter=0;
                    total_count_positive=0;
                    total_count_negative=0;
        p.setOld_signal(""+old_signal);
        p.setNegative_signal(""+negative_signal);
        p.setPositive_signal(""+positive_signal);
        int label=getlabel(postId,PostExcelFilePath); 
        p.setLabel(""+label);
     
       return p;
    }
    public static String callURL(String myURL) {
		//System.out.println("Requeted URL:" + myURL);
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		} 
 
		return sb.toString();
	}
    public static String getReactionCount(String str) {
        String num;
        String regex ="(\"total_count\":\\d+)";
        String n="";
        Matcher matcher = Pattern.compile( regex ).matcher( str);
        while (matcher.find( ))
        {
            num = matcher.group();     
            //System.out.println(num);
            String r ="(\\d+)";
            Matcher mat = Pattern.compile(r).matcher(num);     
             while (mat.find( ))
            {
               n = mat.group();     
                return(n);                 

            }                     

        }
      return(n);
    }
     
    public static String removePunctuations(String s) 
    {
        String res = "";
        for (Character c : s.toCharArray()) 
        {
            if((c==' ')||Character.isLetterOrDigit(c))
                res += c;
        }
        return res;
    }
    public static int getlabel(String postid,String filename)throws Exception{
        //String filename = "C:\\Users\\User\\Documents\\NetBeansProjects\\Facebook\\health post\\هشاشة العظام.xls";
        FileInputStream fis = null;
        FileInputStream fs = new FileInputStream(filename);
	Workbook wb = Workbook.getWorkbook(fs);
        Sheet sh = wb.getSheet("First Excel Sheet");
	// To get the number of rows present in sheet
	int totalNoOfRows = sh.getRows();
	// To get the number of columns present in sheet
	int totalNoOfCols = sh.getColumns();
        int label=0;
         for (int row = 0; row < totalNoOfRows; row++)
            {

	     if(sh.getCell(0,row).getContents().equals( postid))
                {
                    label=Integer.parseInt(sh.getCell(13,row).getContents());
                }
 
             }
        return label;
     }
     
}
