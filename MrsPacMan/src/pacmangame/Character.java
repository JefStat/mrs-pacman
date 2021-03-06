package pacmangame;
/**
* This character class establishes an abstract outline of the characters of the PacMan game.
* These characters include PacMan and the four ghosts.  Each subclass overrides the character 
* class.
* 
* Title: Character Class version 1.1
* @Date: February 16, 2009
* @Author: Nicole Waldrum and Jef Statham
* 
* 
* Milestone2 
* @Date: March 1, 2009
* @updated by: Nicole Waldrum
* Made character an abstract class as it doesn't actually implement anything and will just be 
* overridden by the Ghost and PacMan classes
* 
* Milestone 3
* @Date: March 11, 2009
* @updated: Nicole Waldrum
* 
* Deleted the variable personality and to get/return because it was not necessary.
* 
* Jef's notes: changed setPosition to abstract and return type to boolean.
* 
*/
import java.util.Observer;


public abstract class Character implements Observer {
	
	/**
	 * the name of each character
	 */
	protected String name;
	/**
	 * provides the information of whether the character is dead or alive
	 */
	private boolean alive;
	/**
	 * The map where all the characters exist
	 */
	protected Map map;
	/**
	 * gives the current map in use for the game to each character 
	 * @param m is the current map in use
	 */
	public Character(Map m){
		this.map = m;
	}
	/**
	 * gets the name of the character
	 * @return character name
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the alive status of the character
	 * @param alive
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	/**
	 * checks the boolean state of alive
	 * @return whether ghost is alive
	 */
	public boolean isAlive() {
		return alive;
	}

}
