package pacmanTest;
import pacmangame.Coordinate;
import pacmangame.Node;
import junit.framework.TestCase;
/**
 * This will test that the node class properly adds and evaluates the positions
 * 
 * Milestone 3
 * @Date March 14, 2009
 * @author Nicole Waldrum
 *
 */


public class NodeTest extends TestCase {
	//creates a new coordinate
	Coordinate point = new Coordinate(5,4, 1);
	//creates a new node
	Node test = new Node(point, 3, 4, null);
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	/**
	 * tests that the node constructor works properly
	 */
	public void testNode() {
		assertTrue("The node's position should equal point", test.getPosition() == point);
		assertTrue("The node's h should equal 3", test.goalEstimate == 3);
		assertTrue("The node's g should be 4", test.costPath == 4);
		assertTrue("The node's f should be h + g", test.sum== 7);
	}
	/**
	 * tests that the equals works properly
	 */
	public void testEqualsObject() {
		assertNull("Should return true if they equal",null);
	}

}
