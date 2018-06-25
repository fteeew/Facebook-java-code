
package facebook;

public class Postcomment {
     public String post_id;
     public String comment_content;
     public String reaction_count;
  
    
    public Postcomment(){};
         
    public Postcomment(String post_id, String comment_content,String reaction_count) {
        this.post_id = post_id;
        this.comment_content = comment_content;
        this.reaction_count=reaction_count;
    }

    public String getPost_id() {
        return post_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getReaction_count() {
        return reaction_count;
    }

    public void setReaction_count(String reaction_count) {
        this.reaction_count = reaction_count;
    }
    
}
