import java.awt.Point;
import java.util.Observable;
/**
 * This Ambusher class is the pink ghost, whose behaviour is speedy.
 * This ghost is released from the ghost prison after the chaser moves
 * out of the way of the ghost prison at the start of the game.
 * The Ambushers takes a more roundabout route to PacMan which is deadly.
 * The respective corner is the top left of the screen.
 * 
 * @Date: February 16, 2009
 * @Author: Nicole Waldrum and Jef Statham
 * 
 * Milestone 3
 * @Date: March 7th, 2009
 * @Author: Jen Kasun and Nicole Waldrum
 * 
 * Implemented all the methods for Ambusher.
 */
public class Ambusher extends Ghost {
	/**
	 * Character constant for Ambusher
	 */
	private final int AMBUSHER = 1;
	/**
	 * creates the name for ambusher
	 */
	private final String NAME = "Pinky";
	/**
	 * map parameter size for ghost to know its location
	 */
	private Coordinate[][] map2;
	/**
	 * the starting point for Ambusher
	 */
	private final Coordinate STARTINGPOINT = map.getAmbusherStart();
	/**
	 * creates a ghost instance of ambusher 
	 */
	private final Ghost pinky;
	/**
	 * sets the corner location for ambusher
	 */
	private final Coordinate CORNER = new Coordinate(0, Map.MAX, map2[0][Map.MAX].getIdentity());
	/**
	 * The pather that ambusher will follow in order to get to PacMan
	 */
	private final GhostPath path;
	/**
	 * Default Constructor, creates the Ambusher ghost 
	 */
	public Ambusher(){
		String name = NAME;
		pinky = new Ghost();
		pinky.runAway(CORNER);
		path = new GhostPath(this);		
	}
	/**
	 * Moves Ambusher towards PacMan in the appropriate path 
	 * Given temporarily the same personality as chaser but faster.
	 */
	public void movetoPacMan(Coordinate p){
		pinky.setPosition(path.AStarSearch(p).getPosition());
		pinky.setPosition(path.AStarSearch(p).getPosition());
		
	}
	/**
	 * Returns the respective corner that Ambusher runs to when scared or in scatter mode
	 * @return Corner
	 */
	public Coordinate ambusherCorner(){
		return CORNER;
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
