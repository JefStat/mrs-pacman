package pacmangame;
import java.util.Observable;

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
 * Milestone 3
 * @Date: March 7th, 2009
 * @Author: Jen Kasun and Nicole Waldrum
 * 
 * Implemented all the methods for Chaser.
 * 
 * Milestone 4
 * @Date: March 29th, 2009
 * @Author: Nicole Waldrum
 * 
 * Removed the Corner method as Chaser moving to the corner will be determined
 * during the update method and whether scared is true or not.  Prison method was 
 * removed as when the ghost dies it will just be reinitialized.
 */

public class Chaser extends Character implements Ghost {
	/**
	 * defines the name of chaser
	 */
	private final String NAME = "Blinky";
	/**
	 * keeps track of the corner for blinky
	 */
	private Coordinate Corner  = new Coordinate(map.getSize() - 2, map.getSize() - 2, 0);
	/**
	 * keeps track of the number of turns
	 */
	private int turns = 0;
	/**
	 * Default Constructor
	 */
	public Chaser(Map m) {
		super(m); //gets the current map in use
		this.name = NAME; // sets the chaser name
		new GhostPath(NAME, map);
		m.setScared(false);
	}

	/**
	 * Moves Chaser towards PacMan as per the defined personality
	 * @param p takes pacMan position
	 */
	public void movetoPacMan(Coordinate p) {
		Coordinate whereImGoing = GhostPath.AStarSearch(map, map.getChaser(), map.getPacMan());
		map.setChaser(whereImGoing);
	}
	/**
	 * Chaser determines the move based on PacMan's most recent movement and whether or not
	 * scared is true.
	 */
	@Override
	public void update(Observable o, Object arg) {
		//resets turns to 0
		if (turns ==2){
			turns = 0;
		}
		//count the number of turns ghost is in prison
		else if (map.getChaser() == map.getPrison()){
			turns++;
		}
		//ghost is scared, run to corner
		if (map.isScared() && map.getChaser() != map.getPrison()){
			Coordinate whereImGoing = GhostPath.AStarSearch(map, map.getChaser(), Corner);
			map.setChaser(whereImGoing);
		}
		//ghost isn't scared, get PacMan
		else if (map.isScared() == false){
			new GhostPath(NAME,map);
			movetoPacMan(((NotifierObject)arg).getC());
		}
	} 
	/**
	 * toXML convert any character into it's XML object
	 */
	public String toXML(){
		String c = 
			"<Character>\n" +
			"\t<Name>"+this.name+"</Name>\n" +
			"\t<Coordinate>"+map.getChaser().toString()+"</Coordinate>\n" +
			"</Character>\n";
		return c;
	}
}
