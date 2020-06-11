import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.github.GHCommit.File;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHTag;

public class HTMLHelper	{
	
	private GitHubHandler git;
	private GHRepository gitRep;
	private ArrayList<GitFile> gitFiles;
	
	public HTMLHelper() throws IOException {
		// TODO Auto-generated constructor stub
		git = new GitHubHandler();
		gitRep = git.getGitRep();
		gitFiles = new ArrayList<GitFile>();
	}
	
	public void fillGitFiles() throws IOException {
		int i = 0;
		while(i <= git.getTags().toList().size()) {
			if(i == 0) {
				List<File> fileList = gitRep.listCommits().toList().get(0).getFiles();
				for(File file : fileList) {
					if(file.getFileName().equalsIgnoreCase("covid19spreading.rdf")) {
						gitFiles.add(new GitFile(git.getFileTimestamp(file), file.getFileName(), git.getFileTag(file), git.getFileDescription(file), git.getSVLink(file)));
					}
				}
				i++;
			} else {
				for (GHTag tag : git.getTags()) {
					List<File> fileList = tag.getCommit().getFiles();
					for(File file : fileList) {
						if(file.getFileName().equalsIgnoreCase("covid19spreading.rdf")) {
							gitFiles.add(new GitFile(git.getFileTimestamp(file), file.getFileName(), git.getFileTag(file), git.getFileDescription(file), git.getSVLink(file)));
						}
					}
					i++;
				}
			}
		}
		
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
