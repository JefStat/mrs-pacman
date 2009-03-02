import junit.framework.TestCase;

/**
 * TEST CLASS FOR THE MAP CLASS
 */

/**
 * @author Nahim
 * Version 1.0
 * Monday March 2nd, 2009
 */
public class testMap extends TestCase {

	/**
	 * @param name
	 */
	public testMap(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link Map#Map(int)}.
	 */
	public void testMap() {
		Map regularmap = new Map(30);
		assertEquals(30,regularmap.getSize());
		assertEquals(15,regularmap.getPrison().x);
		assertEquals(15,regularmap.getPrison().y);
		assertEquals(782,regularmap.getPacdots());
	}

	/**
	 * Test method for {@link Map#printMap()}.
	 */

	public void testPrintMap() {
		Map regularmap = new Map(30);
		regularmap.printMap();
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link Map#getMap()}.
	 */
	public void testGetMap() {
		fail("Not yet implemented"); // TODO
	}


}
