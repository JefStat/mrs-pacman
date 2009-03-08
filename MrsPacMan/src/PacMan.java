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
* 
* Milestone 3
* Date: March 7th, 2009
* Author: Jen Kasun and Nicole Waldrum
* 
* Implemented all the methods in PacMan
* 
*/
import java.awt.event.ActionEvent;
import java.util.Observable;

public class PacMan extends Character {

	private static final String PACMANNAME = "PacMan";
	private final int DEFAULTLIVES = 3;
	private Coordinate STARTINGPOINT = map.getPacManStart();
	private final int PACMAN = 4;
	private static Coordinate position;
	private int livesLeft;
	
	/*
	 * This creates a default position for PacMan
	 */
	public PacMan(){
		name = PACMANNAME;
		livesLeft = DEFAULTLIVES;
		position = STARTINGPOINT;
	}
	
	/*
	 * Constructor to pick the starting point p of PacMan
	 */
	public PacMan(Coordinate p){
		position = p;
		name = PACMANNAME;
		livesLeft = DEFAULTLIVES;
	}
	public static Coordinate getPosition(){
		return position;
		
	}
	
	public static void setPosition(Coordinate p){
		position = p;
	}
	public void actionPerformed(ActionEvent arg0){
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
