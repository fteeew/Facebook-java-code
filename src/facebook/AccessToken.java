package Facebook;


import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.User;
public class AccessToken {

	public static void main(String[] args) {
		
		
	}
	public String getAccessToken(String id) {
		String accessToken="EAACEdEose0cBAJpjiR5Ybmo5qmsoeK4oevclOyxr6UQuwg9c8DDZAElZBuwMOE400MBFZCa87jlNY05GKVQkhuA3DZCVGEWuPIIEIH043qlLCjStvDssu9MAg0mSaDF3K6k8UsZCGx5uJlZAeBa4HN1ZBOTmPLqpexKxijA5S8CNKMC3MNTdMAQzjn2tX2amTcZD";
	
		FacebookClient fbClient = new DefaultFacebookClient(
				"EAACEdEose0cBAJpjiR5Ybmo5qmsoeK4oevclOyxr6UQuwg9c8DDZAElZBuwMOE400MBFZCa87jlNY05GKVQkhuA3DZCVGEWuPIIEIH043qlLCjStvDssu9MAg0mSaDF3K6k8UsZCGx5uJlZAeBa4HN1ZBOTmPLqpexKxijA5S8CNKMC3MNTdMAQzjn2tX2amTcZD");
		
		User user = fbClient.fetchObject(id,User.class);
	    String return_id;
	    return_id= user.getId();
		return return_id;
     

	}

}
