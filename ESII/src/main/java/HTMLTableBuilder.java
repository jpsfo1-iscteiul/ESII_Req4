/**
 *     @author João
 *     @version 1
 *     
 *     Creates an HTML Table that can be manipulated dynamically.
 *     
 *     Thanks to: https://gist.github.com/2sbsbsb/2951464
 */

public class HTMLTableBuilder {


	private int columns;
	private final StringBuilder table = new StringBuilder();
	public static String HTML_START = "<html>";
	public static String HTML_END = "</html>";
	public static String TABLE_START_BORDER = "<table border=\"1\">";
	public static String TABLE_START = "<table>";
	public static String TABLE_END = "</table>";
	public static String HEADER_START = "<th>";
	public static String HEADER_END = "</th>";
	public static String ROW_START = "<tr>";
	public static String ROW_END = "</tr>";
	public static String COLUMN_START = "<td>";
	public static String COLUMN_END = "</td>";


	/**
	 * @param header
	 * @param border
	 * @param rows
	 * @param columns
	 * 
	 * Constructor of HTMLTableBuilder
	 * 
	 */
	public HTMLTableBuilder(String header, boolean border, int rows, int columns) {
		this.columns = columns;
		if (header != null) {
			table.append("<b>");
			table.append(header);
			table.append("</b>");
		}
		table.append(HTML_START);
		table.append(border ? TABLE_START_BORDER : TABLE_START);
		table.append(TABLE_END);
		table.append(HTML_END);
	}


	/**
	 * @param values
	 * 
	 * Adds a Table Header
	 * 
	 */
	public void addTableHeader(String... values) {
		if (values.length != columns) {
			System.out.println("Error column lenth");
		} else {
			int lastIndex = table.lastIndexOf(TABLE_END);
			if (lastIndex > 0) {
				StringBuilder sb = new StringBuilder();
				sb.append(ROW_START);
				for (String value : values) {
					sb.append(HEADER_START);
					sb.append(value);
					sb.append(HEADER_END);
				}
				sb.append(ROW_END);
				table.insert(lastIndex, sb.toString());
			}
		}
	}


	/**
	 * @param values
	 * 
	 * Adds values to the row
	 * 
	 */
	public void addRowValues(String... values) {
		if (values.length != columns) {
			System.out.println("Error column lenth");
		} else {
			int lastIndex = table.lastIndexOf(ROW_END);
			if (lastIndex > 0) {
				int index = lastIndex + ROW_END.length();
				StringBuilder sb = new StringBuilder();
				sb.append(ROW_START);
				for (String value : values) {
					sb.append(COLUMN_START);
					sb.append(value);
					sb.append(COLUMN_END);
				}
				sb.append(ROW_END);
				table.insert(index, sb.toString());
			}
		}
	}


	/**
	 * @return
	 */
	public String build() {
		return table.toString();
	}
	
}