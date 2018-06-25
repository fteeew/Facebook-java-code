
package facebook;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class ReadContent {
	String fileName;

	public ReadContent(String fileName) {
		this.fileName = fileName; // set the path for each file
	}

	/**
	 * @param fileName2
	 * @return the content of the HTML file
	 * @throws IOException
	 */
	public String[] openFile(String fileName2) throws IOException {
		FileReader fr = new FileReader(fileName2);
		BufferedReader textReader = new BufferedReader(fr);
		int numberOfLines = readLines(fileName2); // save the number of lines of
													// the HTML file
		String[] textData = new String[numberOfLines];
		int i;
		for (i = 0; i < numberOfLines; i++) {
			textData[i] = textReader.readLine();
		}
		textReader.close();

		return textData;

	}

	/**
	 * @param fileName1
	 * @return the number of lines in the HTML file
	 * @throws IOException
	 */
	int readLines(String fileName1) throws IOException {

		FileReader file_to_read = new FileReader(fileName1);
		BufferedReader bf = new BufferedReader(file_to_read);
		String aLine;
		int numberOfLines = 0;
		while ((aLine = bf.readLine()) != null) {
			numberOfLines++;
		}
		bf.close();
		return numberOfLines;
	}

}
