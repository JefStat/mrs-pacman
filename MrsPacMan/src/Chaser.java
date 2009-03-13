import java.awt.Point;
import java.util.Observable;
/**
 * This Chaser class is the red ghost, whose behaviour is a shadow.
 * This character starts outside of the ghost prison at the start
 * of the game. 
 * The Chaser will take the shortest route to PacMan and follows.
 * Chaser will also speed up after a certain number of pellets are 
 * eaten by PacMan, this number decreases as levels increase.
 * The respective corner is the top right of the screen.
 * 
 * Title: Chaser Class version 1.1
 * @Date: February 16, 2009
 * @Author: Nicole Waldrum and Jef Statham
 * 
 * Milestone 3
 * @Date: March 7th, 2009
 * @Author: Jen Kasun and Nicole Waldrum
 * 
 * Implemented all the methods for Chaser.
 */


public class Chaser extends Ghost{
	/**
	 * defines the chaser constant for character
	 */
	private final int CHASER = 0;
	/**
	 * defines the name of chaser
	 */
	private final String NAME = "BLINKY";
	/**
	 * keeps track of the map coordinates
	 */
	private Coordinate[][] map;
	/**
	 * creates an instance of blinky
	 */
	private final Ghost blinky;
	/**
	 * keeps track of the corner for blinky
	 */
	private final Coordinate CORNER = new Coordinate(Map.MAX, Map.MAX, map[Map.MAX][Map.MAX].getIdentity());
	/**
	 * keeps track of the path that blinky is on
	 */
	private final GhostPath path;
	/**
	 * Default Constructor
	 */
	public Chaser(){
		String name = NAME;
		blinky = new Ghost();
		blinky.runAway(CORNER);
		path = new GhostPath(this);
	}
	/**
	 * Moves Chaser towards PacMan as per the defined personality
	 */
	public void movetoPacMan(Coordinate p){
		blinky.setPosition(path.AStarSearch(p).getPosition());
	}
	/**
	 * returns the corner that Chaser runs to.
	 * @return chasher corner
	 */
	public Coordinate chaserCorner(){
		return CORNER;
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
