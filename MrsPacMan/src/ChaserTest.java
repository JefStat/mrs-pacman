import junit.framework.TestCase;
/**
 * This test case ensures that the chaser class runs properly.
 * 
 * Milestone 3
 * Date: March 10, 2009
 * Author: Nicole Waldrum
 */

public class ChaserTest extends TestCase {
	//creates a new instanance of Chaser
	private Chaser ghost = new Chaser();

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
		//checks that a new ghost was actually created
		assertTrue("This value should return true as a new Chaser was created.", ghost == null);
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
