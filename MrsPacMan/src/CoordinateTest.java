import junit.framework.TestCase;


public class CoordinateTest extends TestCase {

	public CoordinateTest(String name) {
		super(name);
	}

	public void testCoordinate() {
		Coordinate coordinate1= new Coordinate(1,2,5);
		assertEquals(coordinate1.getIdentity(), 5);
	}

	public void testSetIdentity() {
		Coordinate coordinate2 = new Coordinate(1,2,3);
		coordinate2.setIdentity(1);
		assertEquals(coordinate2.getIdentity(), 1);
	}

}
