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
	 * sets the corner location for ambusher
	 */
	private final Coordinate Corner;
	/**
	 * tracks whether or not the ghost is scared
	 */
	private boolean scared;
	/**
	 * Default Constructor, creates the Ambusher ghost
	 */
	public Ambusher(Map m) {
		super(m); // imports the map
		this.name = NAME;
		path = new GhostPath(NAME, map); // sets the new ghost path
		setScared(false); //ghost is not scared
		Corner = new Coordinate(0, map.getSize() - 1, 0);// gets ambushers corner
	}
	/**
	 * updates the Ambusher class for each move
	 * 
	 * @param o
	 * @param arg
	 *  is pacman's position
	 */
	public void update(Observable o, Object arg) {
		path = new GhostPath(NAME,map);
		movetoPacMan((Coordinate)arg);
	}
	@Override
	public void movetoPacMan(Coordinate P) {
		path = new GhostPath(NAME,map);
		map.setAmbusher(path.AStarSearch(P).getPosition());
	}
	@Override
	public void movetoPrison(Coordinate p) {
		// TODO Auto-generated method stub

	}
	/**
	 * sets whether or not the ghost is scared from PacMan eating PowerPellet
	 * @param scared true or false
	 */
	public void setScared(boolean scared) {
		this.scared = scared;
	}
	/**
	 * returns whether or not the ghost is scared
	 * @return scared status of ghost
	 */
	public boolean isScared() {
		return scared;
	}
	/**
	 * Returns the respective corner that Ambusher runs to when scared or in
	 * scatter mode
	 * 
	 * @return Corner for ambusher
	 */
	public Coordinate ambusherCorner() {
		return Corner;
	}

}
