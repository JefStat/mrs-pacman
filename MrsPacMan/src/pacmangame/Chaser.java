package pacmangame;
import java.util.Observable;

import javax.swing.text.Position;

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

public class Chaser extends Character implements Ghost {
	/**
	 * defines the name of chaser
	 */
	private final String NAME = "Blinky";
	/**
	 * keeps track of the corner for blinky
	 */
	private Coordinate Corner;
	/**
	 * keeps track of the path that blinky is on
	 */
	private GhostPath path;
	/**
	 * keeps track of whether or not the ghost is scared
	 */
	private boolean scared;
	/**
	 * Default Constructor
	 */
	public Chaser(Map m) {
		super(m); //gets the current map in use
		this.name = NAME; // sets the chaser name
		Corner = new Coordinate(map.getSize() - 1, map.getSize() - 1, 0);//sets chasers corner location
		path = new GhostPath(NAME, map); // sets the new ghost path
		setScared(false);
	}

	/**
	 * Moves Chaser towards PacMan as per the defined personality
	 * @param p takes pacMan position
	 */
	public void movetoPacMan(Coordinate p) {
		//path = new GhostPath(NAME,map);
		Coordinate whereImGoing = GhostPath.AStarSearch(map, map.getChaser(), map.getPacMan() );
		map.setChaser( whereImGoing );
	}
	/**
	 * returns the corner that Chaser runs to.
	 * 
	 * @return chaser corner
	 */
	public Coordinate chaserCorner() {
		return Corner;
	}

	@Override
	public void update(Observable o, Object arg) {
		path = new GhostPath(NAME,map);
		movetoPacMan(((NotifierObject)arg).getC());
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
	
}
