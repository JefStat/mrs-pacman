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
	private Coordinate Corner  = new Coordinate(map.getSize() - 1, map.getSize() - 1, 0);
	/**
	 * keeps track of whether or not the ghost is scared
	 */
	private boolean scared;
	/**
	 * Default Constructor
	 */
	public Chaser(Map m) {
		super(m); //gets the current map in use
		this.name = NAME; // sets the chaser name
		new GhostPath(NAME, map);
		setScared(false);
	}

	/**
	 * Moves Chaser towards PacMan as per the defined personality
	 * @param p takes pacMan position
	 */
	public void movetoPacMan(Coordinate p) {
		Coordinate whereImGoing = GhostPath.AStarSearch(map, map.getChaser(), map.getPacMan() );
		map.setChaser( whereImGoing );
	}
	/**
	 * Chaser determines the move based on PacMan's most recent movement and whether or not
	 * scared is true.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (scared){
			Coordinate whereImGoing = GhostPath.AStarSearch(map, map.getChaser(), Corner);
			map.setChaser(whereImGoing);
		}
		new GhostPath(NAME,map);
		movetoPacMan(((NotifierObject)arg).getC());
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
