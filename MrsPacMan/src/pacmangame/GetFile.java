package pacmangame;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class GetFile {
	public static URL thefile;
	
	
	public Map importlevel(String filename){
		thefile = this.getClass().getResource(filename + ".xml");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			PacManDefaultHandler parser = new PacManDefaultHandler();
			saxParser.parse(thefile.openStream(), parser);
			if (parser.getMap().validateMap(parser.getMap())){
				return parser.getMap();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Map();
	}
}
