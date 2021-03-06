package pacmanTest;
import pacmangame.Coordinate;
import pacmangame.Fickle;
import pacmangame.Map;
import junit.framework.TestCase;
/**
 * This test case ensures that a proper Fickle is created.
 * 
 * Milestone 3
 * Date: March 10, 2009
 * Author: Nicole Waldrum
 */

public class FickleTest extends TestCase {
	//creates a new map
	Map m = new Map();
	//creates a new instanance of fickle
	private Fickle ghost = new Fickle(m);

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * checks that the constructor method actually created the new Fickle.
	 */
	public void testFickle() {
		//When a new ghost is created, the default position is set to the prison which is also the STARTINGPOINT
		assertNotNull("When a new Fickle is created it should no longer be null", m.getFickle() == null);
		//when a new ghost is created the name is set
		assertEquals("Fickles named Inky", ghost.getName(), "Inky");
	}
	
	/**
	 * checks that the ghost moved to the actual direction/place it was suppose to
	 */
	public void testMovetoPacManCoordinate() {
		//cretes a new coordinate
		Coordinate point = new Coordinate(2,2,2);
		//moves ghost towards the new coordinate
		ghost.movetoPacMan(point);
		//verifies that ghost moved towards the new coordinate
		assertNotSame("Should move ghost closer to PacMan so the ghost won't be in the same spot.", m.getFickle(), point);
	}
	/**
	 * test the toXML string
	 */
	public void testtoXML(){
		Map map = new Map();
		Fickle fickle = new Fickle(map);
		String XMLstring = 
			"<Character>\n" +
			"\t<Name>Inky</Name>\n" +
			"\t<Coordinate>"+map.getFickle().toString()+"</Coordinate>\n" +
			"</Character>\n";
		assertEquals("Should equal the XML string " + XMLstring, XMLstring , fickle.toXML());
		
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Fickle.class);
	}
}
