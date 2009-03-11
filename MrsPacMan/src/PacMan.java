/**
* PacMan is the user and starts at the bottom center of the screen.
* PacMan is equal distance away from two power pellets but always 
* starts out facing the left side of the screen and starts to move 
* in that direction unless the user changes the direction.
* 
* He starts out with three lives but loses a life everytime a ghost
* is touched.  Lives can be gained with each 10,000 points.
* 
* Title: PacMan Class version 1.1
* @Date: February 16, 2009
* @Author: Nicole Waldrum and Jef Statham
* 
* Milestone 3
* @Date: March 7th, 2009
* @Author: Jen Kasun and Nicole Waldrum and Jef Statham
* 
* Update partial done removed PacMan(Coordinate p) only the map should
* contain the starting point for pacman. Added comments to update for 
* how it should possibly be developped.
* 
*/
import java.util.Observable;

public class PacMan extends Character {

	private static final String PACMANNAME = "PacMan";
	private final int DEFAULTLIVES = 3;
	private Coordinate STARTINGPOINT = map.getPacManStart();
	private final int PACMAN = 4;
	private static Coordinate position;
	private int livesLeft;
	
	/**
	 * Creates a new PacMan object
	 */
	public PacMan(){
		name = PACMANNAME;
		livesLeft = DEFAULTLIVES;
		position = STARTINGPOINT;
	}
	
	/**
	 * Used for ghosts to find pacman.
	 * @return Coordinate of pacman
	 */
	public static Coordinate getPosition(){
		return position;
	}
	
	/**
	 * used to teleport pacman back to start when dead why is this public?
	 * should also check lives before doing so.
	 * @param p
	 */
	public static void setPosition(Coordinate p){
		position = p;
	}
	
	/**
	 * not yet implemented 
	 * 
	 * Need to get identity at coordinate p and check it
	 * possibly check to see if movement is more then one point.. ie avoid
	 * teleporting pacman
	 * 
	 * @param p
	 * @return true if pacman can move to selected coordinate
	 */
	public boolean checkMovement(Coordinate p) {
		return false;
	}
	/**
	 * Update will move pacMan or remove lives if he is caught
	 * 	@Override
	 */
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Coordinate) {
			if (checkMovement((Coordinate)arg1)) {
				position = (Coordinate)arg1;
				//check for pacdot now? what if move to ghost should pacman observe himself?
				//also set identity should this be an action event? or should map observe all characters
				//other idea is to have a refreshgui() to reload the changed identity.
			}
		}
	}
}
