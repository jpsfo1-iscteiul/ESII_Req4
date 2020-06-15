import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * 
 * @author João
 * @version 1
 * 
 * Class exclusively used to execute the project
 * 
 */

public class Req4Exe {

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {
		try {
			System.out.println("Initiating a remote connection to GitHub.\n");
			GitHubHandler git = new GitHubHandler();
			System.out.println("Remote connection to GitHub initiated.\n");
			HTMLHelper helper = new HTMLHelper();
			System.out.println("Retrieving all specified files. This may take a while.\n");
			helper.fillGitFiles();
			HTMLTableBuilder htmlBuilder = new HTMLTableBuilder(null, true, helper.getGitFiles().size(), 5);
			htmlBuilder.addTableHeader("File timestamp", "File name","File tag","Tag description", "Spread Visualization link");
			for (GitFile gitFile : helper.getGitFiles()) {
				htmlBuilder.addRowValues(gitFile.getTimestamp(), gitFile.getName(), gitFile.getTag(), gitFile.getTagDescription(), "<a href=" + gitFile.getSvLink() + "> Click here!</a>");
			}
			String table = htmlBuilder.build();
			FileUtils.writeStringToFile(new java.io.File("table.html"), table);
			System.out.println("\nDone! All files were successfully retrieved and an HTML table was generated.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}