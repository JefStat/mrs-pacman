import junit.framework.TestCase;
/**
 * This test class ensures that each character is properly created to the specifications that are necessary and required.
 * 
 * Milestone 2
 * @Date: March 2, 2009
 * @author: Jen Kasun
 *
 */


public class CharacterTest extends TestCase {

	public CharacterTest(String name) {
		super(name);
	}

	public void testSetPosition() {
		PacMan character1 = new PacMan();
		Coordinate coordinate1= new Coordinate(1,1,1);
		character1.setPosition(coordinate1);
		assertEquals(character1.getPosition(), coordinate1);
		
		Ghost character2 = new Ghost();
		Coordinate coordinate2= new Coordinate(2,2,2);
		character2.setPosition(coordinate2);
		assertEquals(character2.getPosition(), coordinate2);
	}


	public void testSetAlive() {
		PacMan character1 = new PacMan();
		character1.setAlive(true);
		assertTrue(character1.isAlive());
		
		character1.setAlive(false);
		assertFalse(character1.isAlive());
		
		
		Ghost character2 = new Ghost();
		character2.setAlive(true);
		assertTrue(character2.isAlive());
		
		character2.setAlive(false);
		assertFalse(character2.isAlive());
	}


	public void testSetPersonality() {
		PacMan character1 = new PacMan();
		character1.setPersonality(1);
		assertEquals(character1.getPersonality(),1);
		
		Ghost character2 = new Ghost();
		character2.setPersonality(2);
		assertEquals(character2.getPersonality(),2);
	}

}
