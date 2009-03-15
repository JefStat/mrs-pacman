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
	//creates a new instanance of Ambusher
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
		assertTrue("When a new Ambusher is created setPosition should equal STARTINGPOINT which is the prison", ghost.getPosition() == m.getChaser());
		//When a new ghost is created incarcerated it false
		assertTrue("When a new ghost is created it isn't incarcerated.", ghost.isIncarcerated() == false);
		//When a new ghost is created isScared() is false
		assertFalse("When a new ghost is created it isn't scared", ghost.isScared() == false);
		//when a new ghost is created the name is set
		assertEquals("Ambushers name Pinky", ghost.name, "Pinky");
		//sets the ghost coordinate to compare to the ghost's corner
		Coordinate coordinate1 = new Coordinate(m.getSize() - 1, m.getSize() - 1, 0);
		//when a new ghost is created the corner coordinate is set
		assertEquals("Returns the ghost's corner coordinate", ghost.chaserCorner(), coordinate1);
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
		assertTrue("Should move ghost to x = 2, y = 2 and identity = 2 (pacdot).", ghost.getPosition() == point);
	}
	
	
	/**
	 * checks that chasers corner is correct
	 */
	public void testChaserCorner() {
		//creates a new map
		Coordinate[][] map3 = null;
		//sets the corner coordinates for the map
		Coordinate corner = new Coordinate(Map.MAX, Map.MAX, map3[Map.MAX][Map.MAX].getIdentity());
		//moves the ghost to a new position
		ghost.movetoPacMan(ghost.chaserCorner());
		//checks that the ghost has moved to the proper location
		assertTrue("Shoudld move Chaser ghost to the corner 0, MAX", ghost.getPosition() == corner);
	}
	
	/**
	 * not yet implemented for observer pattern
	 */
	public void testUpdate()
		//this method returns null because it is not implemented
		assertNull("This method should return null becuase its not implemented.", null);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Chaser.class);
	}
}
