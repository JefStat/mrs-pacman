package pacmanTest;
import pacmangame.Ambusher;
import pacmangame.Coordinate;
import pacmangame.Map;
import junit.framework.TestCase;
/**
 * This test class ensures that the Ambusher class is properly functioning by testing each individual method
 * 
 * @date Date: March 10, 2009
 * @author: Author: Nicole Waldrum
 * 
 * Jef's notes: commented out assertEquals and testAmbusherCorner since the function of ambusherCorner has changed as of ghostpath revision 176
 *
 */

public class AmbusherTest extends TestCase {
	//creates a new map
	Map m = new Map();
	//creates a new instanance of Ambusher
	private Ambusher ghost = new Ambusher(m);

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * checks that the constructor method actually created the new Ambusher.
	 */
	public void testAmbusher() {
		//When a new ghost is created, the default position is set to the prison which is also the STARTINGPOINT
		assertTrue("When a new Ambusher is created setPosition should equal STARTINGPOINT which is the prison", m.getAmbusher() == m.getPrison());
		//When a new ghost is created isScared() is false
		assertFalse("When a new ghost is created it isn't scared", ghost.isScared() == false);
		//when a new ghost is created the name is set
		assertEquals("Ambushers name Pinky", ghost.getName(), "Pinky");
		//sets the ghost coordinate to compare to the ghost's corner
		Coordinate coordinate1 = new Coordinate(0, m.getSize() - 1, 0);
		//when a new ghost is created the corner coordinate is set
		//assertEquals("Returns the ghost's corner coordinate", ghost.ambusherCorner(), coordinate1);
	}

	/**
	 * checks that the ghost moved to the actual direction/place it was suppose to
	 */
	public void testMovetoPacManCoordinate() {
		Coordinate point = new Coordinate(2,2,2);
		ghost.movetoPacMan(point);
		assertEquals("Should move ghost to x = 2, y = 2 and identity = 2 (pacdot).", m.getAmbusher(), point);
	}
	
	
	/**
	 * checks that ambushers corner is correct
	 */
	public void testAmbusherCorner() {
		Coordinate corner = new Coordinate(0, m.getSize()-1, m.getIdentity(0, m.getSize()-1));
	//	ghost.movetoPacMan(ghost.ambusherCorner());
		assertEquals("Shoudld move Ambusher ghost to the corner 0, getSize()-1", m.getAmbusher(), corner);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Ambusher.class);
	}
}
