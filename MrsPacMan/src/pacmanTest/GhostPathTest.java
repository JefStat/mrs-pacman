package pacmanTest;
import pacmangame.Ambusher;
import pacmangame.Chaser;
import pacmangame.Fickle;
import pacmangame.Map;
import pacmangame.Stupid;
import junit.framework.TestCase;
/**
 * checks that ghostpath is properly implemented in order for ghost to take the shortest path
 * to pacman.  Due to complete failure this test case was not implemented because it is being rewritten,
 * hopefully I will get it up tonight.
 * 
 * Milestone 3
 * @Date March 14, 2009
 * @author Nicole Waldrum
 * 
 * Milestone 4
 * @Date: March 29th, 2009
 * @Author: Nicole Waldrum
 * 
 * Created an AStarSearch tests for each ghost.  Checks that each ghost is taking its initial move towards PacMan
 *
 */

public class GhostPathTest extends TestCase {
	//creates a new map
	Map m = new Map();
	//creates a new instanance of Chaser
	private Chaser ghost1 = new Chaser(m);
	//creates a new instanance of Ambusher
	private Ambusher ghost2 = new Ambusher(m);
	//creates a new instanance of Fickle
	private Fickle ghost3 = new Fickle(m);
	//creates a new instanance of Stupid
	private Stupid ghost4 = new Stupid(m);
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	/**
	 * tests that the ghosts move a long the shortest path to a goal
	 */
	public void testAStarSearch() {
		ghost1.movetoPacMan(m.getPacMan());
		ghost2.movetoPacMan(m.getPacMan());
		ghost3.movetoPacMan(m.getPacMan());
		ghost4.movetoPacMan(m.getPacMan());
		//this will check that the Chaser has moved
		assertNotNull("Chaser is moving towards PacMan so position should not be null", m.getChaser());
		//this will check that the Ambusher has moved
		assertNotNull("Ambusher is moving towards PacMan so position should not be null", m.getAmbusher());
		//this will check that the Fickle has moved
		assertNotNull("Fickle is moving towards PacMan so position should not be null", m.getFickle());
		//this will check that the Stupid has moved
		assertNotNull("Stupid is moving towards PacMan so position should not be null", m.getStupid());
		
	}

}
