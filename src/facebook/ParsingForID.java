


package Facebook;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingForID {
	int count = 0;
	String page_PostID = null;
	SaveContent saveCont = new SaveContent("C:\\Users\\User\\Documents\\NetBeansProjects\\Facebook\\data set\\culture\\_ارتفاع منسوب مياه المحيطات_ – Facebook Search.html");
	String[] fileCont = saveCont
			.getContentOfQueriesFiles("C:\\Users\\User\\Documents\\NetBeansProjects\\Facebook\\data set\\culture\\_ارتفاع منسوب مياه المحيطات_ – Facebook Search.html");

	/**
	 * @param line
	 * @return
	 */

	public ArrayList<String> getPage_PostID() {

		ArrayList<String> page_PostIDs = new ArrayList<String>();
		int lineNum;
		for (lineNum = 0; lineNum < fileCont.length; lineNum++) {
			String lineCont = fileCont[lineNum];
			if (lineCont.contains("class=\"_401d\" data-gt")) {

				Pattern pattern = Pattern.compile("\\&\\w{4}\\;\\d{4,30}\\:\\d{4,30}");
				Matcher matcher = pattern.matcher(lineCont);
				while (matcher.find()&&(count<500)) {
					this.page_PostID = matcher.group(0);
					String page_PostID1 = this.page_PostID.replace(":", "_").replace("&quot;", "");

					if (page_PostIDs.contains(page_PostID1) != true) {
						page_PostIDs.add(page_PostID1);
						System.out.println(page_PostID1);
						count++;
					}
				}
			}

		}
		System.out.println("\n the number of post id in this query =");
		System.out.println(count);
		return page_PostIDs;
	}
	

}
