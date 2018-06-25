
package Facebook;
import java.io.IOException;


public class SaveContent {
	private ReadContent fileReader;
	private String queryFileName;

	public SaveContent() {
		//this.queryFileName = queryFileName;
	}

	/**
	 * @param logFileName
	 */
	public SaveContent(String queryFileName) {
		this.queryFileName = queryFileName;
	}

	/**
	 * @throws IOException
	 * 
	 */
	public String[] getContentOfQueriesFiles(String queryFileName) {
            fileReader = new ReadContent(queryFileName);
            String[] arrayOfLinesOfLogFile = fileReader.openFile(queryFileName);
            return arrayOfLinesOfLogFile;

	}

	/**
	 * @throws IOException
	 * 
	 */
	public void displayingContentsOfQueriesFile() {
		SaveContent contents = new SaveContent(queryFileName);
		String[] content = contents.getContentOfQueriesFiles(queryFileName);
		int i;
		for (i = 0; i < content.length; i++) {
			System.out.println("line number" + i + "line Content" + content[i]);
		}
	}


}