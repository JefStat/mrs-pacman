import java.awt.Point;
import java.awt.Point;
/*
 * This Ambusher class is the pink ghost, whose behaviour is speedy.
 * This ghost is released from the ghost prison after the chaser moves
 * out of the way of the ghost prison at the start of the game.
 * The Ambushers takes a more roundabout route to PacMan which is deadly.
 * The respective corner is the top left of the screen.
 * 
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 */
public class Ambusher extends Ghost {
	
	private final String NAME = "Pinky";
	private final Coordinate CORNER = new Point(0,Max);
	
	/*
	 * Default Constructor
	 */
	public Ambusher(){
				
	}
	
	public void movetoPacMan(PacMan p){
		
	}
	
}
