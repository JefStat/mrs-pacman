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
	//creates the coordinate where Chaser starts
	Coordinate test = new Coordinate(5, 4, m.getIdentity(5,4));
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
		//When a new ghost is created isScared() is false
		assertFalse("When a new ghost is created it isn't scared", ghost.isScared() == false);
		//when a new ghost is created the name is set
		assertEquals("Chasers name Blinky", ghost.getName(), "Blinky");
		//sets the ghost coordinate to compare to the ghost's corner
		Coordinate coordinate1 = new Coordinate(m.getSize() - 1, m.getSize() - 1, 0);
		//when a new ghost is created the corner coordinate is set
		assertEquals("Returns the ghost has move from original point towards corner and thus not null", ghost.chaserCorner(), coordinate1);
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
	 * checks that chasers corner is correct
	 */
	/*
	public void testChaserCorner() {
		//sets the corner coordinates for the map
		Coordinate corner = new Coordinate(m.getSize()-1, m.getSize()-1, m.getIdentity(m.getSize()-1, m.getSize()-1));
		//moves the ghost to a new position
		ghost.movetoPacMan(ghost.chaserCorner());
		//checks that the ghost has moved to the proper location
		assertEquals("Shoudld move Chaser ghost to the corner getSize()-1, getSize-1", m.getChaser(), corner);
	}*/
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
