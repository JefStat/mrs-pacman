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
		assertEquals(new Coordinate(1,1,Coordinate.EMPTY),regularmap.getPacManStart());
	}

	/**
	 * Test method for {@link Map#printMap()}.
	 */

	public void testPrintMap() {
		Map regularmap = new Map(30);
		regularmap.printMap();
	}
	
	public void testExportMap(){
		Map regularmap = new Map(30);
		try {
			regularmap.ExportMap("BasicMap.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testImportMap(){
		Map regularmap = new Map(30);
		try {
			regularmap.ExportMap("BasicMap.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			regularmap.ImportMap("BasicMap.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(30, regularmap.getSize());
		assertEquals(new Coordinate(15,15,Coordinate.PRISON),regularmap.getPrison());
		assertEquals(new Coordinate(1,1,Coordinate.EMPTY),regularmap.getPacManStart());
	}
	
	/**
	 * Test method for {@link Map#getMap()}.
	 */
	public void testGetMap() {
		fail("Not yet implemented"); // TODO
	}


}
