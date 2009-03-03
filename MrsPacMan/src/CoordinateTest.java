import junit.framework.TestCase;


public class CoordinateTest extends TestCase {

	public CoordinateTest(String name) {
		super(name);
	}

	public void testCoordinate() {
		fail("Not yet implemented");
	}

	public void testGetIdentity() {
		fail("Not yet implemented");
	}

	public void testSetIdentity() {
		Coordinate c1 = new Coordinate(1,2,3);
		c1.setIdentity(1);
		assertEquals(c1.getIdentity(), 1);
	}

}
