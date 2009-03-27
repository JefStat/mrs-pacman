package pacmangame;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PacManDefaultHandler extends DefaultHandler{
	final private String MAP = "Map";
	final private String SIZE = "size";
	final private String PACMAN = "PacMan";
	final private String COORDINATE = "Coordinate";
	final private String NAME = "Name";
	final private String AMBUSHER = "Pinky";
	final private String CHASER = "Blinky";
	final private String FICKLE = "Inky";
	final private String STUPID = "Clyde";
	
	private Map newMap = null;
	private String c;
	private String[] coordinates = new String[5];
	int index;
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) 
	throws SAXException{
		if (qName == MAP){
			System.out.println(attributes.toString());
			// Get value(int index), index is Get index (qName) lastly convert the value string into an integer
			newMap = new Map(new Integer(attributes.getValue(attributes.getIndex(SIZE))));
		}
	}

	public void endElement(String uri, String localName, String qName)
     throws SAXException{
		if (qName == NAME ){
			if (c == PACMAN){
				index = 0;
			}
			if (c == AMBUSHER){
				index = 1;
			}
			if (c == CHASER){
				index = 2;
			}
			if (c == FICKLE){
				index = 3;
			}
			if (c == STUPID){
				index = 4;
			}
		}
		if (qName == COORDINATE){
			coordinates[index] = c;
		}
		if (qName == MAP){
			// set the coordinates of the ghosts and pacman
		}
	}
	
	public void characters(char[] ch, int start, int length)
     throws SAXException{
		c = new String(ch, start, length);
	}
	
	/**
	 * @return the newMap
	 */
	public Map getMap() {
		return newMap;
	}
}
