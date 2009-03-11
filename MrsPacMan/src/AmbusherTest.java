import junit.framework.TestCase;
/**
 * This test classes ensures that the Ambusher class is properly function by testing each individual method
 * 
 * @date Date: March 10, 2009
 * @author: Author: Nicole Waldrum
 *
 */

public class AmbusherTest extends TestCase {
	//creates a new instanance of Ambusher
	private Ambusher ghost = new Ambusher();

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	//checks that the constructor method actually created the new Ambusher.
	public void testAmbusher() {
		assertTrue("This value should return true as a new ambusher was created.", ghost == null);
	}
	
	//checks that the ghost moved to the actual direction/place it was suppose to
	public void testMovetoPacManCoordinate() {
		Coordinate point = new Coordinate(2,2,2);
		ghost.movetoPacMan(point);
		assertTrue("Should move ghost to x = 2, y = 2 and identity = 2 (pacdot).", ghost.getPosition() == point);
	}
	
	
	//checks that ambushers corner is correct
	public void testAmbusherCorner() {
		Coordinate[][] map3 = null;
		Coordinate corner = new Coordinate(0, Map.MAX, map3[0][Map.MAX].getIdentity());
		ghost.movetoPacMan(ghost.ambusherCorner());
		assertTrue("Shoudld move Ambusher ghost to the corner 0, MAX", ghost.getPosition() == corner);
	}
	
	//not yet implemented for observer pattern
	public void testUpdate() {
		assertNull("This method should return null becuase its not implemented.", null);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Ambusher.class);
		new Ambusher();
	}
}
