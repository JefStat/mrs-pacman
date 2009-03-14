import junit.framework.TestCase;


/**
 * Nicole did Jef's test documentation becuase he wrote nothing here.  This tests the PacManGame class
 * to ensure that it is in proper working order.
 * 
 * Milestone 3
 * @Date March 12, 2009
 * @author Jef Statham 
 *
 */
public class PacManGameTest extends TestCase {

	/**
	 * creates a new instanance of PacManGame
	 * @param name characters name
	 */
	public PacManGameTest(String name) {
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
	 * Test method for {@link PacManGame#PacManGame()}.
	 */
	public void testPacManGame() {
		new PacManGame();
	}

	/**
	 * Test method for {@link PacManGame#PacManGame(Map)}.
	 */
	public void testPacManGameMap() {
		new PacManGame(new Map(44));
	}

	/**
	 * Test method for {@link PacManGame#getMap()}.
	 */
	public void testGetMap() {
		Map map = new Map();
		PacManGame newgame = new PacManGame(map);
		assertEquals("Test to see if the map returned is the map made", map == newgame.getMap());
	}
	
}
