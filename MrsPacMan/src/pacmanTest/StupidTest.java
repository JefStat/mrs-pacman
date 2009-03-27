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
		assertTrue("When a new Chaser is created setPosition should equal STARTINGPOINT which is the prison",  m.getPrison() == m.getChaser());
		//When a new ghost is created isScared() is false
		assertFalse("When a new ghost is created it isn't scared", ghost.isScared() == false);
		//when a new ghost is created the name is set
		assertEquals("Chasers name Blinky", ghost.getName(), "Blinky");
		//sets the ghost coordinate to compare to the ghost's corner
		Coordinate coordinate1 = new Coordinate(m.getSize() - 1, 0, 0);
		//when a new ghost is created the corner coordinate is set
		assertEquals("Returns the ghost's corner coordinate", ghost.stupidCorner(), coordinate1);
	}
	
	//checks that the ghost moved to the actual direction/place it was suppose to
	public void testMovetoPacManCoordinate() {
		Coordinate point = new Coordinate(2,2,2);
		ghost.movetoPacMan(point);
		assertTrue("Should move ghost to x = 2, y = 2 and identity = 2 (pacdot).", m.getStupid() == point);
	}
	
	
	//checks that Stupids corner is correct
	public void testStupidCorner() {
		Coordinate corner = new Coordinate(m.getSize()-1, 0, m.getIdentity(m.getSize()-1, 0));
		ghost.movetoPacMan(ghost.stupidCorner());
		assertTrue("Shoudld move Stupid ghost to the corner MAX, 0", m.getStupid() == corner);
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
