import java.util.Observable;

/**
 * This Chaser class is the red ghost, whose behaviour is a shadow. This
 * character starts outside of the ghost prison at the start of the game. The
 * Chaser will take the shortest route to PacMan and follows. Chaser will also
 * speed up after a certain number of pellets are eaten by PacMan, this number
 * decreases as levels increase. The respective corner is the top right of the
 * screen.
 * 
 * Title: Chaser Class version 1.1
 * 
 * @Date: February 16, 2009
 * @Author: Nicole Waldrum and Jef Statham
 * 
 *          Milestone 3
 * @Date: March 7th, 2009
 * @Author: Jen Kasun and Nicole Waldrum
 * 
 *          Implemented all the methods for Chaser.
 */

public class Chaser extends Ghost {
	/**
	 * defines the name of chaser
	 */
	private final String NAME = "BLINKY";
	/**
	 * keeps track of the corner for blinky
	 */
	private Coordinate Corner;
	/**
	 * keeps track of the path that blinky is on
	 */
	private final GhostPath path;

	/**
	 * Default Constructor
	 */
	public Chaser(Map m) {
		super(m); //gets the current map in use
		STARTINGPOINT = map.getChaser();//gets chasers starting point
		this.setPosition(STARTINGPOINT); //sets chasers starting point
		setIncarcerated(false); // is not jailed
		setScared(false); // is not scared
		String name = NAME; // sets the chaser name
		Corner = new Coordinate(map.getSize() - 1, map.getSize() - 1, 0);//sets chasers corner location
		this.runAway(Corner); // set runaway corner to start
		path = new GhostPath(this, map); // sets the new ghost path
	}

	/**
	 * Moves Chaser towards PacMan as per the defined personality
	 * @param p takes pacMan position
	 */
	public void movetoPacMan(Coordinate p) {
		this.setPosition(path.AStarSearch(p).getPosition());
	}

	/**
	 * returns the corner that Chaser runs to.
	 * 
	 * @return chasher corner
	 */
	public Coordinate chaserCorner() {
		return Corner;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
