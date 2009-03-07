import java.awt.Point;
import java.util.Observable;
/*
 * This Stupid class is the orange ghost, whose behaviour is pokey.
 * This ghost is released from the ghost prison last.
 * Stupid has random movements hence the characters name.
 * The respective corner is the bottom left of the screen.
 * 
 * Title: Stupid Class version 1.1
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 * 
 * Milestone 3
 * Date: March 7th, 2009
 * Author: Jen Kasun and Nicole Waldrum
 * 
 * Implemented all the methods for Stupid.
 */

public class Stupid extends Ghost {
	private final int STUPID = 3;
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
	//Moves Stupid towards PacMan as per the defined personality
	public void movetoPacMan(Coordinate p){
		if(Map.getSize()/4<=(Math.sqrt(GhostPath.pathDistanceEstimate(clyde.getPosition(), p, clyde)))){
			
		}
	}
	//Returns the cornere that Stupis goes to
	public Coordinate stupidCorner(){
		return CORNER;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
