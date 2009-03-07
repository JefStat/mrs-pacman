import java.awt.Point;
import java.math.*;
/*
 * This Fickle class is the blue ghost, whose behaviour is bashful.
 * Released third out of the ghost pen after Chaser and Ambusher are off.
 * Fickle will move about the board randomly but may follow if close to PacMan.
 * The respective corner is the bottom right of the screen.
 * 
 * Title: Fickle Class version 1.1
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 * 
 * Milestone 3
 * Date: March 7th, 2009
 * Author: Jen Kasun and Nicole Waldrum
 * 
 * Implemented all the methods for Fickle.
 */
import java.util.Observable;

public class Fickle extends Ghost{
	
	private final String NAME = "Inky";
	private final Coordinate[][] map;
	private final Ghost inky;
	private final Coordinate CORNER = new Coordinate(Map.MAX,0, map[Map.MAX][0].getIdentity());
	
	/*
	 * Default Constructor
	 */
	public Fickle(){
		String name = NAME;
		Ghost inky = new Ghost();
		inky.runAway(CORNER);
	}
	
	public void movetoPacMan(Coordinate p){
		if(Map.getSize()/4<=(Math.sqrt(GhostPath.pathDistanceEstimate(inky.getPosition(), p, inky)))){
			
		}
		
	}
	public Coordinate ambusherCorner(){
		return CORNER;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
