import junit.framework.TestCase;
/**
 * This test case ensures that a proper Fickle is created.
 * 
 * Milestone 3
 * Date: March 10, 2009
 * Author: Nicole Waldrum
 */

public class FickleTest extends TestCase {
	//creates a new instanance of Fickle
	private Fickle ghost = new Fickle();

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
		//checks that a new instanance of ghost was created
		assertTrue("This value should return true as a new Chaser was created.", ghost == null);
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
		assertTrue("Should move ghost to x = 2, y = 2 and identity = 2 (pacdot).", ghost.getPosition() == point);
	}
	
	
	/**
	 * checks that fickles corner is correct
	 */
	public void testFickleCorner() {
		//creates a new map
		Coordinate[][] map3 = null;
		//sets the corner
		Coordinate corner = new Coordinate(Map.MAX, 0, map3[Map.MAX][0].getIdentity());
		//moves ghost towards the corner
		ghost.movetoPacMan(ghost.fickleCorner());
		//the ghost should have moved towards this corner
		assertTrue("Should move fickle ghost to the corner 0, MAX", ghost.getPosition() == corner);
	}
	
	/**
	 * not yet implemented for observer pattern
	 */
	public void testUpdate() {
		assertNull("This method should return null becuase its not implemented.", null);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Fickle.class);
	}
}
