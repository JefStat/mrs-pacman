package pacmangame;
import java.util.Observable;

/**
 * This Ambusher class is the pink ghost, whose behaviour is speedy. This ghost
 * is released from the ghost prison after the chaser moves out of the way of
 * the ghost prison at the start of the game. The Ambusher takes a more
 * roundabout route to PacMan which is deadly. The Ambusher corner is the top
 * left of the screen.
 * 
 * @Date: February 16, 2009
 * @Author: Nicole Waldrum and Jef Statham
 * 
 * Milestone 3
 * @Date: March 7th, 2009 / March 12, 2009
 * @Author: Jen Kasun and Nicole Waldrum / Jef Statham
 * 
 * Implemented all the methods for Ambusher. / Refactored the Ambusher
 * code to make it less smelly and more coherent and readable.
 * 
 * Milestone 4
 * @Date: March 29th, 2009
 * @Author: Nicole Waldrum
 * 
 * Deleted the Corner method as update will move Ambusher to its corner if scared is true.  Removed
 * Prison method, as will just reinitialize the ghosts when it dies.
 */
public class Ambusher extends Character implements Ghost {
	/**
	 * creates the name for ambusher
	 */
	private final String NAME = "Pinky";
	/**
	 * sets the corner location for ambusher
	 */
	private Coordinate Corner = new Coordinate(0, map.getSize() - 2, map.getIdentity(0, map.getSize()-2));
	/**
	 * counts the number of turns
	 */
	private int turns = 0;
	/**
	 * Default Constructor, creates the Ambusher ghost
	 */
	public Ambusher(Map m) {
		super(m); // imports the map
		this.name = NAME;
		m.setScared(false);
	}
	/**
	 * updates the Ambusher class for each move based on PacMan's movement and whether or not
	 * scared is true.
	 * @param o
	 * @param arg
	 *  is pacman's position
	 */
	public void update(Observable o, Object arg) {
		if (turns ==2){
			turns = 0;
		}
		else if (map.getAmbusher() == map.getPrison()){
			turns++;
		}
		if (map.isScared() && map.getAmbusher() != map.getPrison()){
			Coordinate whereImGoing = GhostPath.AStarSearch(map, map.getAmbusher(), Corner);
			map.setAmbusher(whereImGoing);
		}
		else if (map.isScared() == false){
			movetoPacMan(((NotifierObject)arg).getC());
		}
	}
	/**
	 * moves the ghost towards PacMan's position
	 */
	public void movetoPacMan(Coordinate P) {
		Coordinate whereImGoing = GhostPath.AStarSearch(map, map.getAmbusher(), map.getPacMan());
		map.setAmbusher(whereImGoing);
	}
	/**
	 * toXML convert any character into it's XML object
	 */
	public String toXML(){
		String c = 
			"<Character>\n" +
			"\t<Name>"+this.name+"</Name>\n" +
			"\t<Coordinate>"+map.getAmbusher().toString()+"</Coordinate>\n" +
			"</Character>\n";
		return c;
	}

}
