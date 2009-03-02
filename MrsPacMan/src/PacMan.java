import java.awt.Point;
/*
* PacMan is the user and starts at the bottom center of the screen.
* PacMan is equal distance away from two power pellets but always 
* starts out facing the left side of the screen and starts to move 
* in that direction unless the user changes the direction.
* 
* He starts out with three lives but loses a life everytime a ghost
* is touched.  Lives can be gained with each 10,000 points.
* 
* Title: PacMan Class version 1.1
 * Date: February 16, 2009
* Author: Nicole Waldrum and Jef Statham
*/
import java.awt.event.ActionEvent;

public class PacMan extends Character {

	private final int DEFAULTLIVES = 3;
	private final Coordinate STARTINGPOINT = new Point();
	private final int PACMAN = 4;

	private int livesLeft;
	
	/*
	 * This creates a default position for PacMan
	 */
	public PacMan(){
			
	}
	
	/*
	 * Constructor to pick the starting point p of PacMan
	 */
	public PacMan(Coordinate p){
		
	}
	
	public void actionPerformed(ActionEvent arg0){
		
	}
}
