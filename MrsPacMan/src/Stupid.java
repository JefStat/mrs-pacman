import java.awt.Point;
/*
 * This Stupid class is the orange ghost, whose behaviour is pokey.
 * This ghost is released from the ghost prison last.
 * Stupid has random movements hence the characters name.
 * The respective corner is the bottom left of the screen.
 * 
 * Title: Stupid Class version 1.1
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 */

public class Stupid extends Ghost {
	
	private final String NAME = "CLYDE";
	private final Coordinate[][] map;
	private final Ghost clyde;
	private final Coordinate CORNER = new Coordinate(0,0, map[0][0].getIdentity());
	
	/*
	 * Default Constructor
	 */
	public Stupid(){
		String name = NAME;
		Ghost clyde = new Ghost();
		clyde.runAway(CORNER);
				
	}
	
	public void movetoPacMan(Coordinate p){
		if(Map.getSize()/4<=(Math.sqrt(GhostPath.pathDistanceEstimate(inky.getPosition(), p, inky))){
			
		}
	}
	public Coordinate stupidCorner(){
		return CORNER;
	}
	
}
