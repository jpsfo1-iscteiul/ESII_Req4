import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.github.GHCommit.File;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHTag;
import org.kohsuke.github.PagedIterable;

public class HTMLHelper	{
	
	private GitHubHandler git;
	private GHRepository gitRep;
	private ArrayList<GitFile> gitFiles;
	private PagedIterable<GHTag> tags;
	private static String FILE_NAME = "covid19spreading.rdf";
	
	public HTMLHelper() throws IOException {
		// TODO Auto-generated constructor stub
		git = new GitHubHandler();
		gitRep = git.getGitRep();
		gitFiles = new ArrayList<GitFile>();
		tags = git.getTags();
	}
	
	public void fillGitFiles() throws IOException {
		int i = 0;
		while(i <= tags.toList().size()) {
			if(i == 0) {
				List<File> fileList = gitRep.listCommits().toList().get(0).getFiles();
				for(File file : fileList) {
					if(file.getFileName().equalsIgnoreCase(FILE_NAME)) {
						gitFiles.add(new GitFile(git.getFileTimestamp(file), file.getFileName(), git.getFileTag(file), git.getFileDescription(file), git.getSVLink(file)));
						System.out.println("Successfully retrieved the specified file from master branch.\n");
					}
				}
				i++;
			} else {
				for (GHTag tag : tags) {
					List<File> fileList = tag.getCommit().getFiles();
					for(File file : fileList) {
						if(file.getFileName().equalsIgnoreCase(FILE_NAME)) {
							gitFiles.add(new GitFile(git.getFileTimestamp(file), file.getFileName(), git.getFileTag(file), git.getFileDescription(file), git.getSVLink(file)));
							System.out.println("Successfully retrieved the specified file from tag " + tag.getName() + "\n");
						}
					}
					i++;
				}
			}
		}
		System.out.println("Done! All files were successfully retried.");
		for(int test = 0; test < gitFiles.size(); test++) {
			System.out.println("Timestamp: " + gitFiles.get(test).getTimestamp());
			System.out.println("Name: " + gitFiles.get(test).getName());
			System.out.println("Tag: " + gitFiles.get(test).getTag());
			System.out.println("Description: " + gitFiles.get(test).getDescription());
			System.out.println("SVLink: " + gitFiles.get(test).getSvLink());
			System.out.println("\n\n");
		}
	}
	
}
