package pacmanTest;
import pacmangame.Ambusher;
import pacmangame.Coordinate;
import pacmangame.Map;
import junit.framework.TestCase;
/**
 * This test class ensures that the Ambusher class is properly functioning by testing each individual method
 * 
 * @date Date: March 10, 2009
 * @author: Author: Nicole Waldrum
 * 
 * Jef's notes: commented out assertEquals and testAmbusherCorner since the function of ambusherCorner has changed as of ghostpath revision 176
 *
 */

public class AmbusherTest extends TestCase {
	//creates a new map
	Map m = new Map();
	//creates a new instance of Ambusher
	private Ambusher ghost = new Ambusher(m);

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * checks that the constructor method actually created the new Ambusher.
	 */
	public void testAmbusher() {
		//When a new ghost is created, the default position is set to the prison which is also the STARTINGPOINT
		assertNotNull("When a new Ambusher is created it should no longer be null", m.getAmbusher() == null);
		//when a new ghost is created the name is set
		assertEquals("Ambushers name Pinky", ghost.getName(), "Pinky");
	}

	/**
	 * checks that the ghost moved to the actual direction/place it was suppose to
	 */
	public void testMovetoPacManCoordinate() {
		Coordinate point = new Coordinate(2,2,2);
		ghost.movetoPacMan(point);
		assertNotSame("Should move ghost so it won't be in the same place it was.", m.getAmbusher(), point);
	}
	/**
	 *  test the to XML string
	 */
	public void testtoXML(){
		Map map = new Map();
		Ambusher ambusher = new Ambusher(map);
		String XMLstring = 
			"<Character>\n" +
			"\t<Name>Pinky</Name>\n" +
			"\t<Coordinate>"+map.getAmbusher().toString()+"</Coordinate>\n" +
			"</Character>\n";
		assertEquals("Should equal the XML string " + XMLstring, XMLstring , ambusher.toXML());
		
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Ambusher.class);
	}
}
