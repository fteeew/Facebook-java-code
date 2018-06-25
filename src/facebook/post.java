package facebook;
public class post {
    
    public String post_id;
    public String total_count_of_reaction;
    public String reactions_love;
    public String reactions_haha;
    public String reactions_wow;
    public String reactions_sad;
    public String reactions_angry;
    public String like_count;
    public String comments_count;
    public String share_count;
    public String post_content;
    public String positive_comment_count;
    public String negative_comment_count;
    public String negative_comment_reaction_count;
    public String positive_comment_reaction_count;
    public String positive_reaction_count;
    public String negative_reaction_count;
    public String positive_signal;
    public String negative_signal;
    public String old_signal;
    public String label;
     
    
    
    public post(){}

    public post(String post_id, String total_count_of_reaction, String reactions_love, String reactions_haha,
           String reactions_wow, String reactions_sad, String reactions_angry,
           String like_count, String comments_count,String share_count,String post_content,String positive_comment_count
            ,String negative_comment_count,String negative_comment_reaction_count,String positive_comment_reaction_count,String negative_reaction_count,String positive_reaction_count,String label ,String positive_signal,String negative_signal,String old_signal
) {
        this.post_id = post_id;
        this.total_count_of_reaction = total_count_of_reaction;
        this.reactions_love = reactions_love;
        this.reactions_haha = reactions_haha;
        this.reactions_wow = reactions_wow;
        this.reactions_sad = reactions_sad;
        this.reactions_angry = reactions_angry;
        this.like_count = like_count;
        this.comments_count = comments_count;
        this.share_count = share_count;
        this.post_content=post_content;
        this.positive_comment_count=positive_comment_count;
        this.negative_comment_count=negative_comment_count;
        this.negative_comment_reaction_count=negative_comment_reaction_count;
        this.positive_comment_reaction_count=positive_comment_reaction_count;
        this.positive_reaction_count=positive_reaction_count;
        this.negative_reaction_count=negative_reaction_count;
        this.positive_signal=positive_signal;
        this.negative_signal=negative_signal;
        this.old_signal=old_signal;
        this.label=label;
    }

    public String getPost_id() {
        return post_id;
    }

    public String getTotal_count_of_reaction() {
        return total_count_of_reaction;
    }

    public String getReactions_love() {
        return reactions_love;
    }

    public String getReactions_haha() {
        return reactions_haha;
    }

    public String getReactions_wow() {
        return reactions_wow;
    }

    public String getReactions_sad() {
        return reactions_sad;
    }

    public String getReactions_angry() {
        return reactions_angry;
    }

    public String getLike_count() {
        return like_count;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public void setTotal_count_of_reaction(String total_count_of_reaction) {
        this.total_count_of_reaction = total_count_of_reaction;
    }

    public void setReactions_love(String reactions_love) {
        this.reactions_love = reactions_love;
    }

    public void setReactions_haha(String reactions_haha) {
        this.reactions_haha = reactions_haha;
    }

    public void setReactions_wow(String reactions_wow) {
        this.reactions_wow = reactions_wow;
    }

    public void setReactions_sad(String reactions_sad) {
        this.reactions_sad = reactions_sad;
    }

    public void setReactions_angry(String reactions_angry) {
        this.reactions_angry = reactions_angry;
    }

    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public String getShare_count() {
        return share_count;
    }

    public void setShare_count(String share_count) {
        this.share_count = share_count;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPositive_comment_count() {
        return positive_comment_count;
    }

    public String getNegative_comment_count() {
        return negative_comment_count;
    }

    public String getNegative_comment_reaction_count() {
        return negative_comment_reaction_count;
    }

    public String getPositive_comment_reaction_count() {
        return positive_comment_reaction_count;
    }

    public void setPositive_comment_count(String positive_comment_count) {
        this.positive_comment_count = positive_comment_count;
    }

    public void setNegative_comment_count(String negative_comment_count) {
        this.negative_comment_count = negative_comment_count;
    }

    public void setNegative_comment_reaction_count(String negative_comment_reaction_count) {
        this.negative_comment_reaction_count = negative_comment_reaction_count;
    }

    public void setPositive_comment_reaction_count(String positive_comment_reaction_count) {
        this.positive_comment_reaction_count = positive_comment_reaction_count;
    }

    public String getPositive_reaction_count() {
        return positive_reaction_count;
    }

    public String getNegative_reaction_count() {
        return negative_reaction_count;
    }

    public void setPositive_reaction_count(String positive_reaction_count) {
        this.positive_reaction_count = positive_reaction_count;
    }

    public void setNegative_reaction_count(String negative_reaction_count) {
        this.negative_reaction_count = negative_reaction_count;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPositive_signal() {
        return positive_signal;
    }

    public String getNegative_signal() {
        return negative_signal;
    }

    public String getOld_signal() {
        return old_signal;
    }

    public void setPositive_signal(String positive_signal) {
        this.positive_signal = positive_signal;
    }

    public void setNegative_signal(String negative_signal) {
        this.negative_signal = negative_signal;
    }

    public void setOld_signal(String old_signal) {
        this.old_signal = old_signal;
    }
    
   
}
