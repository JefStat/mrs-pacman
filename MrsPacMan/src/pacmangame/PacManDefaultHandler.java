package pacmangame;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PacManDefaultHandler extends DefaultHandler{
	final private String MAP = "Map";
	final private String SIZE = "size";
	
	private Map newMap = null;
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if (qName == MAP){
			System.out.println(attributes.toString());
			// Get value(int index), index is Get index (qName) lastly convert the value string into an integer
			newMap = new Map(new Integer(attributes.getValue(attributes.getIndex(SIZE))));
		}
	}

	/**
	 * @return the newMap
	 */
	public Map getMap() {
		return newMap;
	}
}
