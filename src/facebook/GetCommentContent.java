package facebook;
import static Facebook.Main.read_from_file;
import com.restfb.Connection;
//package birzeit.edu.ps.gradproject;
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
//import com.restfb.Version;
import com.restfb.types.Comment;
//import com.restfb.types.Message.Share;
import com.restfb.types.Post;
import com.restfb.types.*;
import static facebook.getReaction.callURL;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
//import com.restfb.types.Re
public class GetCommentContent {
    public static void main(String[] args) throws IOException{
        
        ArrayList<String> neww = new ArrayList<String>();
	neww=read_from_file("C:\\Users\\User\\Documents\\NetBeansProjects\\Facebook\\health\\_القولون العصبى_ – Facebook Search.txt");
       for(int i = 0; i < neww.size(); i++)
      {
	    //System.out.println("post id:"+neww.get(i)+":");
            getComment(neww.get(i));
            
       }
      
    }
    public static void getComment(String postId)throws IOException {
            Postcomment comm=new Postcomment();
             Postcomment c1;
             System.out.println("post_id:"+postId);
            FacebookClient fbClient = new DefaultFacebookClient(
"EAACEdEose0cBAI1ZBwqEhuH4lg1CQPujFjW58t7IDR8cBGCQfKmn0SaT7SZChfs0q1LZA6cZBxQYEqMkgJS2jVuM7M41SiG2Q50Jx5SMJF4HzSrqZAC79mqIuaiFqvckFwHPRj50qNpRKcNqXDpHWiANH0M8ekrXZBj4l0qsU4KApOrcyFZAjbZCSoEbSDPBALUZD");
            Connection<Comment> commentConnection = fbClient.fetchConnection(postId + "/comments", 
            Comment.class, Parameter.with("limit",50));
            int personalLimit = 50;
      
            for (List<Comment> commentPage : commentConnection)
            {    
                String header1="@RELATION   Comment";
                String header2="@ATTRIBUTE	'Review'	string";
                String header3="@ATTRIBUTE	'ReviewClass'	{0,1}";
                String header4="@DATA"; 
                String filename=""+postId+".txt";
                try (PrintStream out = new PrintStream(new FileOutputStream(filename))) {
                out.println(header1);
                out.println(header2);
                out.println(header3);
                out.println(header4);
 
                for (Comment comment : commentPage) 
                {
                    String comment_id=comment.getId();
                    System.out.println("comment_id:"+comment_id);
                    JsonObject reactions = fbClient.fetchObject("v2.12/" + comment_id,JsonObject.class,Parameter.with("fields","reactions.summary(1).limit(0)"));
                    String comment_reaction=reactions.toString();
                    getReaction m=new  getReaction();
                    String reaction_count=m.getReactionCount(comment_reaction);
                    System.out.println("reaction count:"+reaction_count);
                    System.out.println("comment message"+comment.getMessage());
                    //String comment_content=removeEnglishPunctuations(comment.getMessage());
                    String comment_content=removePunctuations(comment.getMessage());
                   // c1 = new Postcomment(postId,comment_content,reaction_count);
                   // WriteComment t=new WriteComment();
                   // WriteComment t2=new WriteComment(c1);
                   
                    write(filename,comment_content);
                     
                 
                    personalLimit--;

                    // break both loops
                    if (personalLimit == 0) 
                    {
                        
                        return;
                    }
                }
            }
        
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
        String newString=removeEnglishPunctuations(post_Content);
        out.print('"' + newString + '"');
        out.print(",");
        out.println("?");
        
        //After done writing, remember to close!
        out.close();
    
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
 public static String removeEnglishPunctuations(String s) 
    {
        
        String res = "";
        for (int i = 0; i < s.length();i++) {
        int c1 = s.codePointAt(i);
        if (c1 >= 0x0600 && c1 <= 0x06E0){
       
        for (Character c : s.toCharArray()) 
        {
            if((c==' ')||Character.isLetterOrDigit(c))
                res += c;
        }
        }
        }
        return res;
    }
}