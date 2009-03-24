package pacmanTest;
import pacmangame.Map;
import pacmangame.PacMan;
import junit.framework.TestCase;
/**
 * This test case ensures that all the methods for PacMan are properly working
 * 
 * @Date March 16, 2009
 * @author Nicole Waldrum
 *
 */

public class PacManTest extends TestCase {
	//creates a new map
	Map m = new Map();
	//creates a new PacMan character
	PacMan pac = new PacMan(m);
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPacMan() {
		//should return pacman's name
		assertTrue("Returns true that name is PacMan", pac.getName() == "PacMan");
		//should return false that PacMan is not alive
		assertFalse("Should return false because PacMan is alive", pac.isAlive() == false);
		pac.setAlive(false);
		//should return true, pacman is dead
		assertTrue("Should return true since PacMan is dead", pac.isAlive() == false);
	}

}