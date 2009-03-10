/**
* This character class establishes the abstract outline of the characters of the PacMan game.
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
* @Updated by: Nicole Waldrum
* Made character an abstract class as it doesn't actually implement anything and will just be 
* overridden by the Ghost and PacMan classes
*/
import java.util.Observer;


public abstract class Character extends PacManGame implements Observer {
	//the point is the position of the character at any given moment
	private static Coordinate position;
	//the name of each character
	protected String name;
	//provides the information of whether the character is dead or alive
	private boolean alive;
	//provides the personality for each ghost
	protected int personality;
	//what the character is currently doing
	
	//sets the position of the character
	public static void setPosition(Coordinate p) {
		position = p;
	}
	//gets the position of the character
	public static Coordinate getPosition() {
		return position;
	}
	//gets the name of the character
	public String getName() {
		return name;
	}
	//set the alive status of the character
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	//checks the boolean state of alive
	public boolean isAlive() {
		return alive;
	}
	// sets the personality of the character
	public void setPersonality(int personality) {
		this.personality = personality;
	}
	// gets the personality of the character
	public int getPersonality() {
		return personality;
	}
}
