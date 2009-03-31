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
	final private String IDENTITIES = "Identities";
	
	private Map newMap = null;
	private String c;
	private String[] coordinates = new String[5];
	int index;
	int size;
	Coordinate[][] level;
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) 
	throws SAXException{
		if (qName == MAP){
			System.out.println(attributes.toString());
			//Get value(int index), index is Get index (qName) lastly convert the value string into an integer
			size = new Integer(attributes.getValue(attributes.getIndex(SIZE)));
			newMap = new Map(size);
			level = new Coordinate[size][size];
		}
	}

	public void endElement(String uri, String localName, String qName)
     throws SAXException{
		if (qName == NAME ){
			if (c.equals(PACMAN)){
				index = 0;
			}
			if (c.equals(AMBUSHER)){
				index = 1;
			}
			if (c.equals(CHASER)){
				index = 2;
			}
			if (c.equals(FICKLE)){
				index = 3;
			}
			if (c.equals(STUPID)){
				index = 4;
			}
		}
		if (qName == COORDINATE){
			coordinates[index] = c;
		}
		if (qName == IDENTITIES){
			//create the level matrix of coordinates
			for (int i = 0; i<size;i++){
				for (int j =0; j<size;j++){
					level[i][j] = new Coordinate(i,j,c.charAt(i*size+j)-'0');
					if (c.charAt(i*size+j) == '5'){
						newMap.setPrison(i,j);
					}
				}
			}
			newMap.setLevel(level);
		}
		if (qName == MAP){
			int x = new Integer(coordinates[0].charAt(coordinates[0].lastIndexOf('x')+2)) - '0';
			int y = new Integer(coordinates[0].charAt(coordinates[0].lastIndexOf('y')+2)) - '0';
			Coordinate coord = new Coordinate(x,y,0);
			newMap.setPacMan(coord);
			x = new Integer(coordinates[1].charAt(coordinates[1].lastIndexOf('x')+2)) - '0';
			y = new Integer(coordinates[1].charAt(coordinates[1].lastIndexOf('y')+2)) - '0';
			coord = new Coordinate(x,y,0);
			newMap.setAmbusher(coord);
			x = new Integer(coordinates[2].charAt(coordinates[2].lastIndexOf('x')+2)) - '0';
			y = new Integer(coordinates[2].charAt(coordinates[2].lastIndexOf('y')+2)) - '0';
			coord = new Coordinate(x,y,0);
			newMap.setChaser(coord);
			x = new Integer(coordinates[3].charAt(coordinates[3].lastIndexOf('x')+2)) - '0';
			y = new Integer(coordinates[3].charAt(coordinates[3].lastIndexOf('y')+2)) - '0';
			coord = new Coordinate(x,y,0);
			newMap.setFickle(coord);
			x = new Integer(coordinates[4].charAt(coordinates[4].lastIndexOf('x')+2)) - '0';
			y = new Integer(coordinates[4].charAt(coordinates[4].lastIndexOf('y')+2)) - '0';
			coord = new Coordinate(x,y,0);
			newMap.setStupid(coord);
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
