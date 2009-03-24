package pacmanTest;
import pacmangame.Coordinate;
import junit.framework.TestCase;
/**
 * This test class ensures that the coordinates used to set characters positions and set the item identities
 * for each coordinate properly works.
 * 
 * @Date March 2, 2009
 * @author Jen Kasun
 * 
 * Milestone 3
 * @Date March 14, 2009
 * @author Nicole Waldrum
 * 
 * Documented the test class with javaDoc and improved testing implementations.
 *
 */

public class CoordinateTest extends TestCase {
	/**
	 * sets the name of the coordinate test
	 * @param name
	 */
	public CoordinateTest(String name) {
		super(name);
	}
	/**
	 * will tests the new coordinate created will properly set and return
	 */
	public void testCoordinate() {
		//creates a new coordinate x = 1, y = 2 and identity = 5
		Coordinate coordinate1= new Coordinate(1,2,5);
		//checks that the identity is 5
		assertEquals("This coordinate 1 identity should equal 5 and return true", coordinate1.getIdentity(), 5);
	}
	/**
	 * this method tests both setIdentity() and getIdentity methods from the Coordinate class
	 */
	public void testSetIdentity() {
		//this creates a new identity of x= 1, y = 2 and identity = 3
		Coordinate coordinate2 = new Coordinate(1,2,3);
		//checks that the identity is 3
		assertEquals("This coordinate2 identity should equal 3 and return true", coordinate2.getIdentity(), 3);
		//sets the identity to the value of one
		coordinate2.setIdentity(1);
		//checks that the identity changed to 1
		assertTrue("This coordinate2 identity now equals 1, and should return true", coordinate2.getIdentity()== 1);
		coordinate2.setIdentity(6);
		//checks that identity is set to 6
		assertTrue("This coordinate2 identity is not able to be set to 6 should return -1", coordinate2.getIdentity() == -1);
	}

}
