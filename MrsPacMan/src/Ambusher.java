import java.util.Observable;

/**
 * This Ambusher class is the pink ghost, whose behaviour is speedy. This ghost
 * is released from the ghost prison after the chaser moves out of the way of
 * the ghost prison at the start of the game. The Ambusher takes a more
 * roundabout route to PacMan which is deadly. The Ambusher corner is the top
 * left of the screen.
 * 
 * @Date: February 16, 2009
 * @Author: Nicole Waldrum and Jef Statham
 * 
 *          Milestone 3
 * @Date: March 7th, 2009 / March 12, 2009
 * @Author: Jen Kasun and Nicole Waldrum / Jef Statham
 * 
 *          Implemented all the methods for Ambusher. / Refactored the Ambusher
 *          code to make it less smelly and more coherent and readable.
 */
public class Ambusher extends Character implements Ghost {
	/**
	 * creates the name for ambusher
	 */
	private final String NAME = "Pinky";
	/**
	 * The path that ambusher will follow in order to get to PacMan
	 */
	private GhostPath path;
	/**
	 * Default Constructor, creates the Ambusher ghost
	 */
	public Ambusher(Map m) {
		super(m); // imports the map
		path = new GhostPath(NAME, map); // sets the new ghost path
	}
	/**
	 * updates the Ambusher class for each move
	 * 
	 * @param o
	 * @param arg
	 *            is pacman's position
	 */
	public void update(Observable o, Object arg) {
		System.out.println((Coordinate) arg);
		path = new GhostPath(NAME, map);
		map.setAmbusher(path.AStarSearch((Coordinate) arg).getPosition());
	}
	@Override
	public void movetoPacMan(Coordinate P) {
		// TODO Auto-generated method stub

	}
	@Override
	public void movetoPrison(Coordinate p) {
		// TODO Auto-generated method stub

	}

}
