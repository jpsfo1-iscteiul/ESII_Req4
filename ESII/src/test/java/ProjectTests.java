import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class ProjectTests {
	
	@SuppressWarnings("unused")
	private GitHubHandler gh;
	private HTMLHelper hh;
	private HTMLTableBuilder htb;
	
//	PRIMEIRO FICHEIRO
	
	@Test
	public void testFile1ByTimestamp() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String timestamp = hh.getGitFiles().get(0).getTimestamp();
		String expected = "2020-05-26T12:03:52Z";
		assertEquals(timestamp,expected);
	}

	@Test
	public void testFile1ByName() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String name = hh.getGitFiles().get(0).getName();
		String expected = "covid19spreading.rdf";
		assertEquals(name,expected);
	}
	
	@Test
	public void testFile1ByTag() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String tag = hh.getGitFiles().get(0).getTag();
		String expected = "master";
		assertEquals(tag,expected);
	}
	
	@Test
	public void testFile1ByTagDescription() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String tagDescription = hh.getGitFiles().get(0).getTagDescription();
		String expected = "Update covid19spreading.rdf";
		assertEquals(tagDescription,expected);
	}
	
	@Test
	public void testFile1BysvLink() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String svLink = hh.getGitFiles().get(0).getSvLink();
		String expected = "http://visualdataweb.de/webvowl/#iri=https://github.com/vbasto-iscte/ESII1920/raw/ff268d8849bceb43e4fe8111aa7042bf21d72732/covid19spreading.rdf";
		assertEquals(svLink,expected);
	}
	
//	SEGUNDO FICHEIRO

	@Test
	public void testFile2ByTimestamp() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String timestamp = hh.getGitFiles().get(1).getTimestamp();
		String expected = "2020-05-26T11:58:12Z";
		assertEquals(timestamp,expected);
	}
	
	@Test
	public void testFile2ByName() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String name = hh.getGitFiles().get(1).getName();
		String expected = "covid19spreading.rdf";
		assertEquals(name,expected);
	}
	
	@Test
	public void testFile2ByTag() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String tag = hh.getGitFiles().get(1).getTag();
		String expected = "TestesGeracaoIII";
		assertEquals(tag,expected);
	}
	
	@Test
	public void testFile2ByTagDescription() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String tagDescription = hh.getGitFiles().get(1).getTagDescription();
		String expected = "Update covid19spreading.rdf";
		assertEquals(tagDescription,expected);
	}
	
	@Test
	public void testFile2BysvLink() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String svLink = hh.getGitFiles().get(1).getSvLink();
		String expected = "http://visualdataweb.de/webvowl/#iri=https://github.com/vbasto-iscte/ESII1920/raw/56e85e5f52352e4ff76086454912fb0478941c8e/covid19spreading.rdf";
		assertEquals(svLink,expected);
	}
	
//	TERCEIRO FICHEIRO

	@Test
	public void testFile3ByTimestamp() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String timestamp = hh.getGitFiles().get(2).getTimestamp();
		String expected = "2020-05-26T11:15:56Z";
		assertEquals(timestamp,expected);
	}
	
	@Test
	public void testFile3ByName() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String name = hh.getGitFiles().get(2).getName();
		String expected = "covid19spreading.rdf";
		assertEquals(name,expected);
	}
	
	@Test
	public void testFile3ByTag() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String tag = hh.getGitFiles().get(2).getTag();
		String expected = "TestesGeracaoII";
		assertEquals(tag,expected);
	}
	
	@Test
	public void testFile3ByTagDescription() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String tagDescription = hh.getGitFiles().get(2).getTagDescription();
		String expected = tagDescription;
		assertEquals(tagDescription,expected);
	}
	
	@Test
	public void testFile3BysvLink() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String svLink = hh.getGitFiles().get(2).getSvLink();
		String expected = "http://visualdataweb.de/webvowl/#iri=https://github.com/vbasto-iscte/ESII1920/raw/27f05d4643243cda43bb5a8bad40b534c406265d/covid19spreading.rdf";
		assertEquals(svLink,expected);
	}
	
//	QUARTO FICHEIRO
	
	@Test
	public void testFile4ByTimestamp() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String timestamp = hh.getGitFiles().get(3).getTimestamp();
		String expected = "2020-05-26T11:52:42Z";
		assertEquals(timestamp,expected);
	}

	@Test
	public void testFile4ByName() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String name = hh.getGitFiles().get(3).getName();
		String expected = "covid19spreading.rdf";
		assertEquals(name,expected);
	}
	
	@Test
	public void testFile4ByTag() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String tag = hh.getGitFiles().get(3).getTag();
		String expected = "NovoSurto";
		assertEquals(tag,expected);
	}
	
	@Test
	public void testFile4ByTagDescription() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String tagDescription = hh.getGitFiles().get(3).getTagDescription();
		String expected = "Detetado novo surto";
		assertEquals(tagDescription,expected);
	}
	
	@Test
	public void testFile4BysvLink() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		String svLink = hh.getGitFiles().get(3).getSvLink();
		String expected = "http://visualdataweb.de/webvowl/#iri=https://github.com/vbasto-iscte/ESII1920/raw/c1331ef7244225d67c13b1d41383bec6e793956b/covid19spreading.rdf";
		assertEquals(svLink,expected);
	}
	
	
//	HTMLBUILDER TEST
	
	@Test
	public void testHTMLBuilder() throws IOException {
		gh = new GitHubHandler();
		hh = new HTMLHelper();
		hh.fillGitFiles();
		htb = new HTMLTableBuilder(null, true, hh.getGitFiles().size(), 5);
		htb.addTableHeader("File timestamp", "File name","File tag","Tag description", "Spread Visualization link");
		for (GitFile gitFile : hh.getGitFiles()) {
			htb.addRowValues(gitFile.getTimestamp(), gitFile.getName(), gitFile.getTag(), gitFile.getTagDescription(), "<a href=" + gitFile.getSvLink() + "> Click here!</a>");
		}
		String table = htb.build();
		String expected = table;
		assertEquals(table,expected);
	}
	
}
