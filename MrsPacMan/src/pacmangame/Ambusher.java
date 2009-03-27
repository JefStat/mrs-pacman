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
 *          Milestone 3
 * @Date: March 7th, 2009 / March 12, 2009
 * @Author: Jen Kasun and Nicole Waldrum / Jef Statham
 * 
 *          Implemented all the methods for Ambusher. / Refactored the Ambusher
 *          code to make it less smelly and more coherent and readable.
 */
public class Ambusher extends Character implements Ghost {
	/**
	 * creates the name for ambusher
	 */
	private final String NAME = "Pinky";
	/**
	 * sets the corner location for ambusher
	 */
	private final Coordinate Corner;
	/**
	 * tracks whether or not the ghost is scared
	 */
	private boolean scared;
	/**
	 * Default Constructor, creates the Ambusher ghost
	 */
	public Ambusher(Map m) {
		super(m); // imports the map
		this.name = NAME;
		setScared(false); //ghost is not scared
		Corner = new Coordinate(0, map.getSize() - 1, 0);// gets ambushers corner
	}
	/**
	 * updates the Ambusher class for each move
	 * 
	 * @param o
	 * @param arg
	 *  is pacman's position
	 */
	public void update(Observable o, Object arg) {
		movetoPacMan(((NotifierObject)arg).getC());
	}
	/**
	 * moves the ghost towards PacMan's position
	 */
	public void movetoPacMan(Coordinate P) {
		Coordinate whereImGoing = GhostPath.AStarSearch(map, map.getAmbusher(), map.getPacMan());
		map.setAmbusher(whereImGoing);
	}
	@Override
	public void movetoPrison(Coordinate p) {
		new Ambusher(map);

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
	/**
	 * Returns the respective corner that Ambusher runs to when scared or in
	 * scatter mode
	 * 
	 * @return Corner for ambusher
	 */
	public void ambusherCorner() {
		Coordinate whereImGoing = GhostPath.AStarSearch(map, map.getAmbusher(), Corner);
		map.setAmbusher(whereImGoing);
	}
	/**
	 * toXML convert any character into it's XML object
	 */
	public String toXML(){
		String c = 
			"<Character>\n" +
			"\t<Name>"+this.name+"</name>\n" +
			"\t<Coordinate>"+map.getAmbusher().toString()+"<Coordinate>\n" +
			"</Character>\n";
		return c;
	}

}
