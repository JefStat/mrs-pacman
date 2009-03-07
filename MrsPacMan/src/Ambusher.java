import java.awt.Point;
import java.util.Observable;
/*
 * This Ambusher class is the pink ghost, whose behaviour is speedy.
 * This ghost is released from the ghost prison after the chaser moves
 * out of the way of the ghost prison at the start of the game.
 * The Ambushers takes a more roundabout route to PacMan which is deadly.
 * The respective corner is the top left of the screen.
 * 
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 * 
 * Milestone 3
 * Date: March 7th, 2009
 * Author: Jen Kasun and Nicole Waldrum
 * 
 * Implemented all the methods for Ambusher.
 */
public class Ambusher extends Ghost {
	private final int AMBUSHER = 1;
	private final String NAME = "Pinky";
	private final Coordinate[][] map;
	private final Coordinate[][] STARTINGPOINT = map[0][Map.MAX].getAmbusherStart();
	private final Ghost pinky;
	private final Coordinate CORNER = new Coordinate(0, Map.MAX, map[0][Map.MAX].getIdentity());
	
	/*
	 * Default Constructor
	 */
	public Ambusher(){
		String name = NAME;
		Ghost pinky = new Ghost();
		pinky.runAway(CORNER);
				
	}
	//Moves Ambusher towards PacMan in the appropriate path
	public void movetoPacMan(Coordinate p){
		if(Map.getSize()/4<=(Math.sqrt(GhostPath.pathDistanceEstimate(pinky.getPosition(), p, pinky)))){
			
		}
	}
	//Returns the respective corner that this ghost goes to
	public Coordinate ambusherCorner(){
		return CORNER;
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
