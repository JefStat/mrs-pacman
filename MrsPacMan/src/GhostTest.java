import junit.framework.TestCase;
/**
 * This test case ensures that a proper Ghost is created and controlled.
 * 
 * Milestone 3
 * Date: March 10, 2009
 * Author: Nicole Waldrum
 */

public class GhostTest extends TestCase {

	private Ghost testGhost;

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	//this tests the constructor of ghost
	public void testGhost() {
		testGhost = new  Ghost();
		assertTrue("This tests to ensure that a new Ghost was created.", testGhost == null);
	}

	public void testSetPosition() {
		fail("Not yet implemented");
	}

	public void testGetPosition() {
		fail("Not yet implemented");
	}

	public void testMovetoPacMan() {
		fail("Not yet implemented");
	}

	public void testMovetoPrison() {
		fail("Not yet implemented");
	}

	public void testRunAway() {
		fail("Not yet implemented");
	}

	public void testActionPerformed() {
		fail("Not yet implemented");
	}

	public void testSetIncarcerated() {
		fail("Not yet implemented");
	}

	public void testIsIncarcerated() {
		fail("Not yet implemented");
	}

	public void testSetScatter() {
		fail("Not yet implemented");
	}

	public void testIsScatter() {
		fail("Not yet implemented");
	}

	public void testUpdate() {
		fail("Not yet implemented");
	}

}
