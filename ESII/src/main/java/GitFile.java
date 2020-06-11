public class GitFile {

	private String timestamp;
	private String name;
	private String tag;
	private String description;
	private String svLink;
	
	public GitFile(String timestamp, String name, String tag, String description, String svLink) {
		// TODO Auto-generated constructor stub
		this.timestamp = timestamp;
		this.name = name;
		this.tag = tag;
		this.description = description;
		this.svLink = svLink;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSvLink() {
		return svLink;
	}

	public void setSvLink(String svLink) {
		this.svLink = svLink;
	}
	
}
