package pacmanTest;
import pacmangame.Map;
import junit.framework.TestCase;

/**
 * TEST CLASS FOR THE MAP CLASS
 *
 * @author Nahim
 * Version 1.0
 * Monday March 2nd, 2009
 */
public class MapTest extends TestCase {

	/**
	 * sets the map
	 * @param name
	 */
	public MapTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link Map#Map(int)}.
	 */
	public void testMap() {
		Map regularmap = new Map(30);
		assertEquals(30,regularmap.getSize());
		assertEquals(5,regularmap.getPrison().x);
		assertEquals(5,regularmap.getPrison().y);
		assertEquals(781,regularmap.getPacdots());
	}

	
	public void testExportMap(){
		Map regularmap = new Map(30);
		try {
			regularmap.ExportMap("BasicMap.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testImportMap(){
		Map regularmap = new Map(30);
		try {
			regularmap.ExportMap("BasicMap.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			regularmap.ImportMap("BasicMap.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(30, regularmap.getSize());
	}
	/**
	 * test the toXML from map. with the import and export functionality
	 */
	public void testXML(){
		
		String MapXML =	
				"<Map size=10>\n" +
				"\t<Identities>" +
				"\t\t1111111111\n" +
				"\t\t1022222221\n" +
				"\t\t1222222221\n" +
				"\t\t1222222221\n" +
				"\t\t1222222221\n" +
				"\t\t1222052221\n" +
				"\t\t1222222221\n" +
				"\t\t1222222221\n" +
				"\t\t1222222221\n" +
				"\t\t1111111111\n" +
				"\t</Identities>" +
				"\t<Character>\n" +
				"\t\t<Name>PacMan</Name>\n" +
				"\t\t<Coordinate>pacmangame.Coordinate[x=1,y=1]</Coordinate>\n" +
				"\t</Character>\n" +
				"\t<Character>\n" +
				"\t\t<Name>Pinky</Name>\n" +
				"\t\t<Coordinate>pacmangame.Coordinate[x=5,y=5]</Coordinate>\n" +
				"\t</Character>\n" +
				"\t<Character>\n" +
				"\t\t<Name>Blinky</Name>\n" +
				"\t\t<Coordinate>pacmangame.Coordinate[x=5,y=4]</Coordinate>\n" +
				"\t</Character>\n" +
				"\t<Character>\n" +
				"\t\t<Name>Inky</Name>\n" +
				"\t\t<Coordinate>pacmangame.Coordinate[x=5,y=5]</Coordinate>\n" +
				"\t</Character>\n" +
				"\t<Character>\n" +
				"\t\t<Name>CLYDE</Name>\n" +
				"\t\t<Coordinate>pacmangame.Coordinate[x=5,y=5]</Coordinate>\n" +
				"\t</Character>\n" +
				"</Map>\n";
		Map aMap = new Map(10);
		assertEquals("MapXML should be the same string as \n" + MapXML, MapXML, aMap.toXML());
		aMap.exportXML("test");
	}

}
