import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.github.*;
import org.kohsuke.github.GHCommit.File;

public class GitHubHandler {
	
	public static void main(String[] args) {
		try {
			GitHubHandler git = new GitHubHandler();
			System.out.println("Remote connection to GitHub initiated.\n\n");
			HTMLHelper helper = new HTMLHelper();
			System.out.println("Retrieving all specified files. This may take a while.\n\n");
			helper.fillGitFiles();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private GitHubBuilder gitBuilder;
	private GitHub git;
	private GHRepository gitRep;
	private static String REPO_LINK = "vbasto-iscte/ESII1920";
	private static String ACCESS_TOKEN = "74ef6e2b3c1cac85df37a9f469d9b8b80e17265d";
	private static List<GHCommit> commitList;
	
	@SuppressWarnings("static-access")
	public GitHubHandler() throws IOException {
		// TODO Auto-generated constructor stub
		gitBuilder = new GitHubBuilder();
		git = gitBuilder
//				.withAbuseLimitHandler(AbuseLimitHandler.WAIT)
//				.withRateLimitHandler(RateLimitHandler.WAIT)
				.build()
				.connectUsingOAuth(ACCESS_TOKEN);
		gitRep = git.getRepository(REPO_LINK);
		commitList = gitRep.listCommits().toList();
	}
	
	public String getFileTimestamp(File file) throws IOException {
		if(fileListContainsFile(commitList.get(0).getFiles(), file)) {
			return commitList.get(0).getLastStatus().toString().split("updatedAt=")[1].split("]")[0];
		} else {
			for (GHTag tag : getTags()) {
				if(fileListContainsFile(tag.getCommit().getFiles(), file)) {
					return tag.getCommit().getLastStatus().toString().split("updatedAt=")[1].split("]")[0];
				}
			}
		}
		return null;
	}
	
	public String getFileTag(File file) throws IOException {
		if(fileListContainsFile(commitList.get(0).getFiles(), file)) {
			return "master";
		} else {
			for (GHTag tag : getTags()) {
				if(fileListContainsFile(tag.getCommit().getFiles(), file)) {
					return tag.getName();
				}
			}
		}
		return null;
	}
	
	public String getFileDescription(File file) throws IOException {
		if(fileListContainsFile(commitList.get(0).getFiles(), file)) {
			return commitList.get(0).getCommitShortInfo().getMessage();
		} else {
			for (GHTag tag : getTags()) {
				if(fileListContainsFile(tag.getCommit().getFiles(), file)) {
					return tag.getCommit().getCommitShortInfo().getMessage();
				}
			}
		}
		return null;
	}
	
	public String getSVLink(File file) throws IOException {
		if(fileListContainsFile(commitList.get(0).getFiles(), file)) {
			return "http://visualdataweb.de/webvowl/#iri=" + file.getRawUrl();
		} else {
			for (GHTag tag : getTags()) {
				if(fileListContainsFile(tag.getCommit().getFiles(), file)) {
					return "http://visualdataweb.de/webvowl/#iri=" + file.getRawUrl();
				}
			}
		}
		return null;
	}
	
	public boolean fileListContainsFile(List<File> fileList, File file) {
		List<String> shaList = new ArrayList<String>();
		for(File f : fileList) {
			shaList.add(f.getSha());
		}
		if(shaList.contains(file.getSha())) {
			return true;
		}
		return false;
	}
	
	public PagedIterable<GHTag> getTags() throws IOException {
		return gitRep.listTags();
	}
	
	public GHRepository getGitRep() {
		return gitRep;
	}
	
}