package pacmanTest;
import pacmangame.Coordinate;
import pacmangame.Map;
import pacmangame.Stupid;
import junit.framework.TestCase;
/**
 * This test case ensures that a proper Fickle is created.
 * 
 * Milestone 3
 * Date: March 10, 2009
 * Author: Nicole Waldrum
 */

public class StupidTest extends TestCase {
	//creates a new map
	Map m = new Map();
	//creates a new instanance of Stupid
	private Stupid ghost = new Stupid(m);

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	//checks that the constructor method actually created the new Stupid.
	public void testStupid() {
		//When a new ghost is created, the default position is set to the prison which is also the STARTINGPOINT
		assertNotNull("When a new Stupid is created it is not null", m.getStupid() == null);
		//when a new ghost is created the name is set
		assertEquals("Stupid named Clyde", ghost.getName(), "Clyde");
	}
	
	//checks that the ghost moved to the actual direction/place it was suppose to
	public void testMovetoPacManCoordinate() {
		Coordinate point = new Coordinate(2,2,2);
		ghost.movetoPacMan(point);
		assertNotSame("Should move ghost so not same as previous point.", m.getStupid() == point);
	}
	/**
	 * test the toXML string
	 */
	public void testtoXML(){
		Map map = new Map();
		Stupid stupid = new Stupid(map);
		String XMLstring = 
			"<Character>\n" +
			"\t<name>Clyde</name>\n" +
			"\t<Coordinate>"+map.getStupid().toString()+"</Coordinate>\n" +
			"<Character>\n";
		assertEquals("Should equal the XML string " + XMLstring, XMLstring , stupid.toXML());
		
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Stupid.class);
	}
}
