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
 *          Implemented all the methods for Ambusher. / Refactored the Ambusher code to make it less smelly and more 
 *          coherent and readable.
 */
public class Ambusher extends Ghost {
	/**
	 * creates the name for ambusher
	 */
	private final String NAME = "Pinky";
	/**
	 * sets the corner location for ambusher
	 */
	private final Coordinate Corner;
	/**
	 * The path that ambusher will follow in order to get to PacMan
	 */
	private final GhostPath path;

	/**
	 * Default Constructor, creates the Ambusher ghost
	 */
	public Ambusher(Map m) {
		super(m); //imports the map
		this.setPosition(STARTINGPOINT); // sets ambushers starting point
		setIncarcerated(false); // the ghost is not in prison
		setScared(false); // the ghost is not scared
		String name = NAME; // sets ambushers name
		Corner = new Coordinate(0, map.getSize() - 1, 0);// gets ambushers corner
		this.runAway(Corner); //moves ambusher to his corner
		path = new GhostPath(this, map); //sets the new ghost path

	}

	/**
	 * Moves Ambusher towards PacMan on the appropriate path. Given temporarily
	 * the same personality as Chaser but faster.
	 * @param takes pacman's coordinate
	 */
	public void movetoPacMan(Coordinate p) {
		this.setPosition(path.AStarSearch(p).getPosition());
		this.setPosition(path.AStarSearch(p).getPosition());

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
	/**
	 * updates the Ambusher class for each move
	 * @param o 
	 * @param arg is pacman's position
	 */
	public void update(Observable o, Object arg) {
		if ((this.isAlive() == true) // if the ghost is alive
				&& ((Coordinate) arg == this.getPosition())) { //and if pacman's position is the ghost's position
			if (this.isScared() == true) {//if the ghost is scared
				this.setAlive(false); //ghost is dead
				this.setIncarcerated(true); // ghost is imprisoned
				this.movetoPrison(STARTINGPOINT);// ghost returns to starting point
			}
		}
		if (this.isAlive() == true && (Coordinate) arg != this.getPosition()) {//if ghost is alive and not where pacman is
			if (this.isScared() == true) { // if the ghost is scared
				this.setPosition(Corner); // move to corner
			} else if (this.isScared() == false) { // if the ghost isn't scared 
				path.AStarSearch((Coordinate) arg); // move towards pacman
			}
		}
	}
}
