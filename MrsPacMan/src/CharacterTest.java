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
	/**
	 * chacks that the character class sets the characters names
	 * @param name is the name of the character being created
	 */
	public CharacterTest(String name) {
		super(name);
	}
	/**
	 * test that the setPosition class does set a position but also getPoaition() to return the position the chacter is set to.
	 */
	public void testSetPosition() {
		PacMan character1 = new PacMan();//creates a new PacMan character
		Coordinate coordinate1= new Coordinate(1,1,1); // creates a new coordinate
		character1.setPosition(coordinate1); //sets the new character to the new coordinate position
		assertEquals("The variable character1 has setPosition to 1,1,1 and should return true against coordinate1 that is 1,1,1", character1.getPosition(), coordinate1);//checks that the character returns the correct coordinate created
		
		Ghost character2 = new Ghost(); //creates a new Ghost character
		Coordinate coordinate2= new Coordinate(2,2,2); //creates a new coordinate 2,2,2
		character2.setPosition(coordinate2);//sets the characters position to 2,2,2
		assertEquals("The variable character2 has setPosition to 2,2,2 and should return true against coordinate2 that is 2,2,2", character2.getPosition(), coordinate2);//checks that the character returns the correct coordinate created
	}
	/**
	 * checks that the setAlive and and isAlive methods properly work
	 */

	public void testSetAlive() {
		PacMan character1 = new PacMan(); //creates a new PacMan
		character1.setAlive(true); //sets the PacMans status as alive to true
		assertTrue("Boolean check that the character's status is alive", character1.isAlive() == true);//boolean check that the PacMan is alive and true
		
		character1.setAlive(false);//sets the status of PacMan's life to false
		assertTrue("Boolena check that the character's status isAlive() is false", character1.isAlive() == false); // boolean check that PacMan is set to false
		
		
		Ghost character2 = new Ghost();//creates a new ghost
		character2.setAlive(true); // checks that the ghost is set to Alive
		assertTrue("Boolean check that ghost status isAlive is true", character2.isAlive() == true); // boolean check that the ghost is alive
		
		character2.setAlive(false); //sets the status of isAlive() to false
		assertFalse("Boolean check that character2 status isAlive() is false", character2.isAlive() == false); //boolean check that setAlive() changed to flase
	}

}
