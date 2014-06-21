package brain;

import java.util.TreeMap;

import exceptions.BrokenCSVFileException;
import exceptions.EndOfCSVFileException;

/**
 * The InformationLine represents a single line in the csv file which is not a Headline.
 * The InformationLine has always the same amount of elements as the corresponing headline.
 * @author jonathanhasenburg
 *
 */

public class InformationLine {
	
	private TreeMap<String, String> map = new TreeMap<String, String>();
	
	public InformationLine(String[] line, Headline headline) throws EndOfCSVFileException, BrokenCSVFileException {
		if (line == null) {
			throw new EndOfCSVFileException("CSV File completely parsed");
		}
		if (headline == null) {
			throw new BrokenCSVFileException("The given headline was null");
		}
		
		if (line.length -1 != headline.getCount()) {
			throw new BrokenCSVFileException("Could not create information line because line length<" + line.length + ">was less than headline length<" + headline.getCount() + ">");
		}
		//-1 because last element is "empty"
		for (int i = 0; i < line.length - 1; i++) {
			map.put(headline.get(i), line[i]);
		}
	}
	
	/**
	 * Returns the value with with the given key. Returns null if the value does not exist.
	 * @param key
	 * @return the above specified boolean
	 */
	public String getValue(String key) {
		return map.get(key);
	}
	
	/**
	 * Returns the count of informationLine Strings.
	 * @return the above specified int
	 */
	public int getCount() {
		return map.size();
	}
	
	/**
	 * Returns all key values in the information line, separated by commas.
	 * @return the above specified String
	 */
	@Override
	public String toString() {
		return map.toString() + "\n";
	}
	
	public String toJson() {
		return "";
	}
}
