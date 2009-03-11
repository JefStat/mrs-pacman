import junit.framework.TestCase;
/**
 * This test case ensures that a proper Chaser is created.
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

	//checks that the constructor method actually created the new Chaser.
	public void testChaser() {
		assertTrue("This value should return true as a new Chaser was created.", ghost == null);
	}
	
	//checks that the ghost moved to the actual direction/place it was suppose to
	public void testMovetoPacManCoordinate() {
		Coordinate point = new Coordinate(2,2,2);
		ghost.movetoPacMan(point);
		assertTrue("Should move ghost to x = 2, y = 2 and identity = 2 (pacdot).", ghost.getPosition() == point);
	}
	
	
	//checks that chasers corner is correct
	public void testChaserCorner() {
		Coordinate[][] map3 = null;
		Coordinate corner = new Coordinate(Map.MAX, Map.MAX, map3[Map.MAX][Map.MAX].getIdentity());
		ghost.movetoPacMan(ghost.chaserCorner());
		assertTrue("Shoudld move Chaser ghost to the corner 0, MAX", ghost.getPosition() == corner);
	}
	
	//not yet implemented for observer pattern
	public void testUpdate() {
		assertNull("This method should return null becuase its not implemented.", null);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Chaser.class);
		new Chaser();
	}
}
