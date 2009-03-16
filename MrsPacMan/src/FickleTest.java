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
		assertTrue("When a new Fickle is created setPosition should equal STARTINGPOINT which is the prison", m.getFickle() == m.getPrison());
		//When a new ghost is created isScared() is false
		assertTrue("When a new ghost is created it isn't scared", ghost.isScared() == false);
		//when a new ghost is created the name is set
		assertEquals("Chasers name Inky", ghost.name, "Inky");
		//sets the ghost coordinate to compare to the ghost's corner
		Coordinate coordinate1 = new Coordinate(m.getSize()-1,0,0);
		//when a new ghost is created the corner coordinate is set
		assertEquals("Returns the ghost's corner coordinate", ghost.fickleCorner(), coordinate1);
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
		assertEquals("Should move ghost to x = 2, y = 2 and identity = 2 (pacdot).", m.getFickle(), point);
	}
	
	
	/**
	 * checks that fickles corner is correct
	 */
	public void testFickleCorner() {
		//sets the corner
		Coordinate corner = new Coordinate(m.getSize()-1, 0, m.getIdentity(m.getSize()-1, 0));
		//moves ghost towards the corner
		ghost.movetoPacMan(ghost.fickleCorner());
		//the ghost should have moved towards this corner
		assertEquals("Should move fickle ghost to the corner getSize()-1, 0", m.getFickle(), corner);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Fickle.class);
	}
}
