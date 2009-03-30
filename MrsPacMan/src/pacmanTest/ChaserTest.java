package pacmanTest;
import pacmangame.Chaser;
import pacmangame.Coordinate;
import pacmangame.Map;
import junit.framework.TestCase;
/**
 * This test case ensures that the chaser class runs properly.
 * 
 * Milestone 3
 * Date: March 10, 2009
 * Author: Nicole Waldrum
 */

public class ChaserTest extends TestCase {
	//creates a new map
	Map m = new Map();
	//creates a new instanance of Chaser
	private Chaser ghost = new Chaser(m);

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * checks that the constructor method actually created the new Chaser.
	 */
	public void testChaser() {
		//When a new ghost is created, the default position is set to the prison which is also the STARTINGPOINT
		assertNotNull("When a new Chaser is created it is not null", m.getChaser() == null);
		//when a new ghost is created the name is set
		assertEquals("Chasers name Blinky", ghost.getName(), "Blinky");
	}
	
	/**
	 * checks that the ghost moved to the actual direction/place it was suppose to
	 */
	public void testMovetoPacManCoordinate() {
		//creates a new coorindate called point
		Coordinate point = new Coordinate(2,2,2);
		//moves the ghost to that point
		ghost.movetoPacMan(point);
		//checks that the ghosts position and the point are the same
		assertNotSame("Should move ghost so won't be in original position.", m.getChaser(), point);
	}

	/**
	 * test the to XML string
	 */
	public void testtoXML(){
		Map map = new Map();
		Chaser chaser = new Chaser(map);
		String XMLstring = 
			"<Character>\n" +
			"\t<name>Blinky</name>\n" +
			"\t<Coordinate>"+map.getChaser().toString()+"</Coordinate>\n" +
			"<Character>\n";
		assertEquals("Should equal the XML string " + XMLstring, XMLstring , chaser.toXML());
		
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Chaser.class);
	}
}
