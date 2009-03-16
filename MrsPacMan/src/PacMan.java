/**
* PacMan is the user and starts at the bottom centre of the screen.
* PacMan is equal distance away from two power pellets but always 
* starts out facing the left side of the screen and starts to move 
* in that direction unless the user changes the direction.
* 
* He starts out with three lives but loses a life every time a ghost
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
* Update partially done removed PacMan(Coordinate p) only the map should
* contain the starting point for pacman. Added comments to update for 
* how it should possibly be developed.
* 
* Jef's notes: removed starting point, character constant.
* 
*/
import java.util.Observable;

public class PacMan extends Character {
	/**
	 * creates the name of pacman
	 */
	private static final String PACMANNAME = "PacMan";	
	/**
	 * Creates a new PacMan object
	 * @param m is the current map in use
	 */
	public PacMan(Map m){
		super(m); //the current map in use
		name = PACMANNAME; //sets pacman's name
		setAlive(true);
	}
	/**
	 * Update will move pacMan or remove lives if he is caught
	 * @param arg0
	 * @param arg1
	 */
	public void update(Observable arg0, Object arg1) {
		int identity =	map.getIdentity(map.getPacMan());
		//this updates the map to remove the pacdot at pacmans location
		if (identity == Coordinate.PACDOT){
			map.setIdentity(map.getPacMan());	
		}
		// the following kills pac man when he lands on a ghost
		if ((map.getAmbusher().equals(map.getPacMan()))||(map.getChaser().equals(map.getPacMan()))||(map.getFickle().equals(map.getPacMan()))||(map.getStupid().equals(map.getPacMan()))){
			this.setAlive(false);
		}
	}
}
