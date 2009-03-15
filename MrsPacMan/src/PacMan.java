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
	 * sets the default lives
	 */
	private final int DEFAULTLIVES = 3;
	/**
	 * keeps track of pacman's lives left
	 */
	private int livesLeft;
	/**
	 * Creates a new PacMan object
	 * @param m is the current map in use
	 */
	public PacMan(Map m){
		super(m); //the current map in use
		name = PACMANNAME; //sets pacman's name
		livesLeft = DEFAULTLIVES; //sets the default lives
		position = map.getPacMan(); //gets pacmans starting position
		setAlive(true);
	}
	
	/**
	 * Sets pacman's position to start if it was dead and re-animates pacman.
	 * Otherwise will change pacman's position if checkmovement returns true. 
	 * @param p pacman's start position
	 * @return true if movement was changed
	 */
	public boolean setPosition(Coordinate p){
		if ((this.isAlive())&&(checkMovement(p))){
			position = p;
			map.setPacMan(p);
			return true;
		} else if (!(this.isAlive())){
			if (this.livesLeft > 0) {
				this.setAlive(true);
				position = map.getPacMan();
				return true;
			} 
			return false;
			
		}
		return false;
	}
	
	/**
	 * check to see if movement is more then one point.. ie avoid
	 * teleporting pacman this is useless you can set the position 
	 * through point because it's a mutable object. 
	 * {@link Point.Translate()}
	 * 
	 * @param p pacman's location
	 * @return true if pacman can move to selected coordinate
	 */
	public boolean checkMovement(Coordinate p) {
		double x = p.getX() - position.getX(); 
		double y = p.getY() - position.getY();
		if ((map.getIdentity(p) == Coordinate.WALL)||(map.getIdentity(p) == Coordinate.PRISON)){
			return false;
		} if ((1 > Math.abs(x))||(1 > Math.abs(y))){
			return false;
		}
		return true;
	}
	/**
	 * Update will move pacMan or remove lives if he is caught
	 * @param arg0
	 * @param arg1
	 */
	public void update(Observable arg0, Object arg1) {
		int identity =	map.getIdentity(this.getPosition());
		if (identity == Coordinate.PACDOT){
			map.setIdentity(this.getPosition());
		}
	}

	/**
	 * returns the current position of pacman
	 * @return current position
	 */
	public Coordinate getPosition() {
		return position;
	}
}
