import junit.framework.TestCase;


public class PacManGameTest extends TestCase {

	public PacManGameTest(String name) {
		super(name);
	}

	public void testPacManGame() {
		PacManGame pg1 = new PacManGame();
		assertTrue(pg1.isPlayersTurn());
	}

	public void testPacManGameMap() {
		fail("Not yet implemented");
	}


}
