import java.awt.Point;
import java.awt.Point;
/*
 * This Chaser class is the red ghost, whose behaviour is a shadow.
 * This character starts outside of the ghost prison at the start
 * of the game. 
 * The Chaser will take the shortest route to PacMan and follows.
 * Chaser will also speed up after a certain number of pellets are 
 * eaten by PacMan, this number decreases as levels increase.
 * The respective corner is the top right of the screen.
 * 
 * Title: Chaser Class version 1.1
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 */

public class Chaser extends Ghost{
	
	private final String NAME = "CLYDE";
	private final Point CORNER = new Point(Max,Max);
	
	/*
	 * Default Constructor
	 */
	public Chaser(){
				
	}
	
	public void movetoPacMan(PacMan p){
		
	}
	
}
