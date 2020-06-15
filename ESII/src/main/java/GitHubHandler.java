import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.github.*;
import org.kohsuke.github.GHCommit.File;

/**
 * 
 * @author João
 * @version 1
 * 
 * Class used to connect to GitHub and scrape all specified needs (repository, commits, tags, files, info, etc.)
 * 
 */

public class GitHubHandler {
	
	private GitHubBuilder gitBuilder;
	private GitHub git;
	private GHRepository gitRep;
	private static String REPO_LINK = "vbasto-iscte/ESII1920";
	private static String ACCESS_TOKEN = "74ef6e2b3c1cac85df37a9f469d9b8b80e17265d";
	private static List<GHCommit> commitList;
	
	/**
	 * 
	 * @throws IOException
	 * 
	 * Class constructor that connects to the specified Git Repository
	 * 
	 */
	
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
	
	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * 
	 * Gets the specified file's timestamp
	 * 
	 */
	
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
	
	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * 
	 * Gets the specified file's tag
	 * 
	 */
	
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
	
	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * 
	 * Gets the specified file's description
	 * 
	 */
	
	public String getFileTagDescription(File file) throws IOException {
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
	
	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * 
	 * Gets the specified file's spread visualization link
	 * 
	 */
	
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
	
	/**
	 * 
	 * @param fileList
	 * @param file
	 * @return
	 * 
	 * Checks if the specified file is inside a specified list of files
	 * 
	 */
	
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
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 * 
	 * Gets all tags of a Git Repository
	 * 
	 */
	
	public PagedIterable<GHTag> getTags() throws IOException {
		return gitRep.listTags();
	}
	
	/**
	 *
	 * @return
	 * 
	 * Gets the Git Repository
	 * 
	 */
	
	public GHRepository getGitRep() {
		return gitRep;
	}
}