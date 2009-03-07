import java.awt.Point;
import java.awt.Point;
/*
 * This Chaser class is the red ghost, whose behaviour is a shadow.
 * This character starts outside of the ghost prison at the start
 * of the game. 
 * The Chaser will take the shortest route to PacMan and follows.
 * Chaser will also speed up after a certain number of pellets are 
 * eaten by PacMan, this number decreases as levels increase.
 * The respective corner is the top right of the screen.
 * 
 * Title: Chaser Class version 1.1
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 * 
 * Milestone 3
 * Date: March 7th, 2009
 * Author: Jen Kasun and Nicole Waldrum
 * 
 * Implemented all the methods for Chaser.
 */
import java.util.Observable;

public class Chaser extends Ghost{
	private final int CHASER = 0;
	private final String NAME = "BLINKY";
	private final Coordinate[][] map;
	private final Ghost blinky;
	private final Coordinate CORNER = new Coordinate(Map.MAX, Map.MAX, map[Map.MAX][Map.MAX].getIdentity());
	
	/*
	 * Default Constructor
	 */
	public Chaser(){
		String name = NAME;
		Ghost blinky = new Ghost();
		blinky.runAway(CORNER);	
	}
	//Moves Chaser towards PacMan as per the defined personality
	public void movetoPacMan(Coordinate p){
		if(Map.getSize()/4<=(Math.sqrt(GhostPath.pathDistanceEstimate(blinky.getPosition(), p, blinky)))){
			
		}
	}
	//returns the corner that Chaser runs to.
	public Coordinate chaserCorner(){
		return CORNER;
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
