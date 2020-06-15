	/**
	 * 
	 * @author João
	 * @version 1
	 *
	 * Class that represents a file inside a repository, with the clear info for an HTML Table build
	 *
	 */

public class GitFile {

	private String timestamp;
	private String name;
	private String tag;
	private String tagDescription;
	private String svLink;
	
	/**
	 * 
	 * @param timestamp
	 * @param name
	 * @param tag
	 * @param tagDescription
	 * @param svLink
	 * 
	 * Class constructor
	 * 
	 */
	
	public GitFile(String timestamp, String name, String tag, String tagDescription, String svLink) {
		// TODO Auto-generated constructor stub
		this.timestamp = timestamp;
		this.name = name;
		this.tag = tag;
		this.tagDescription = tagDescription;
		this.svLink = svLink;
	}

	/**
	 * 
	 * @return
	 * 
	 * Gets the file timestamp
	 * 
	 */
	
	public String getTimestamp() {
		return timestamp;
	}
	
	/**
	 * 
	 * @param timestamp
	 * 
	 * Sets the file timestamp to a given value
	 * 
	 */

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * 
	 * @return
	 * 
	 * Gets the file name
	 * 
	 */

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 * 
	 * Sets the file name to a given value
	 * 
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 * 
	 * Gets the file tag
	 * 
	 */

	public String getTag() {
		return tag;
	}
	
	/**
	 * 
	 * @param tag
	 * 
	 * Sets the file tag to a given value
	 * 
	 */

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	/**
	 * 
	 * @return
	 * 
	 * Gets the file tag description
	 * 
	 */

	public String getTagDescription() {
		return tagDescription;
	}
	
	/**
	 * 
	 * @param tagDescription
	 * 
	 * Sets the file tag description to a given value
	 * 
	 */

	public void setDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}
	
	/**
	 * 
	 * @return
	 * 
	 * Gets the file spread visualization link
	 * 
	 */

	public String getSvLink() {
		return svLink;
	}
	
	/**
	 * 
	 * @param svLink
	 * 
	 * Sets the file spread visualization link to a given value
	 * 
	 */

	public void setSvLink(String svLink) {
		this.svLink = svLink;
	}
	
}
