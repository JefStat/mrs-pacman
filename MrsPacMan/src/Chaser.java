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
 */

public class Chaser extends Ghost{
	
	private final String NAME = "CLYDE";
	private final Coordinate[][] map;
	private final Ghost inky;
	private final Coordinate CORNER = new Coordinate(Map.MAX, Map.MAX, map[Map.MAX][Map.MAX].getIdentity());
	
	/*
	 * Default Constructor
	 */
	public Chaser(){
		String name = NAME;
		Ghost clyde = new Ghost();
		clyde.runAway(CORNER);	
	}
	
	public void movetoPacMan(Coordinate p){
		if(Map.getSize()/4<=(Math.sqrt(GhostPath.pathDistanceEstimate(inky.getPosition(), p, inky))){
			
		}
	}
	public Coordinate chaserCorner(){
		return CORNER;
	}
	
}
