package pacmangame;
/**
* PacMan is the user and starts at the bottom centre of the screen.
* PacMan is equal distance away from two power pellets but always 
* starts out facing the left side of the screen and starts to move 
* in that direction unless the user changes the direction.
* 
* He starts out with three lives but loses a life every time a ghost
* is touched.  Lives can be gained with each 10,000 points.
* 
* Title: PacMan Class version 1.1
* @Date: February 16, 2009
* @Author: Nicole Waldrum and Jef Statham
* 
* Milestone 3
* @Date: March 7th, 2009
* @Author: Jen Kasun and Nicole Waldrum and Jef Statham
* 
* Update partially done removed PacMan(Coordinate p) only the map should
* contain the starting point for pacman. Added comments to update for 
* how it should possibly be developed.
* 
* Jef's notes: removed starting point, character constant.
* 
* Milestone 4
* @Date: March 29th, 2009
* @Author: Nicole Waldrum
* 
* Added in conditions for PacMan should a powerpellet be eaten!
* 
*/
import java.util.Observable;

public class PacMan extends Character {
	/**
	 * creates the name of pacman
	 */
	private static final String PACMANNAME = "PacMan";
	/**
	 * keeps track of the number of turns
	 */
	private int turns = 0;
	/**
	 * Creates a new PacMan object
	 * @param m is the current map in use
	 */
	public PacMan(Map m){
		super(m); //the current map in use
		name = PACMANNAME; //sets pacman's name
		setAlive(true);
	}
	/**
	 * Update will move pacMan or remove lives if he is caught
	 * @param arg0
	 * @param arg1
	 */
	public void update(Observable arg0, Object arg1) {
		//once pacman has had five turns return scared to false
		if (turns == 5){
			map.setScared(false);
			turns = 0;
		}
		//if true then count the turns
		else if (map.isScared()){
			turns++;
		}
		int identity =	map.getIdentity(map.getPacMan());
		//this updates the map to remove the pacdot at pacmans location
		if (identity == Coordinate.PACDOT){
			map.setIdentity(map.getPacMan());	
		}
		//this updates the map to remove the powerpellet at pacmans location and sets scared
		else if (identity == Coordinate.POWERPELLET){
			map.setIdentity(map.getPacMan());
		}
		// the following kills pac man when he lands on a ghost
		if ((map.isScared() == false) && (map.getAmbusher().equals(map.getPacMan()))||(map.getChaser().equals(map.getPacMan()))||(map.getFickle().equals(map.getPacMan()))||(map.getStupid().equals(map.getPacMan()))){
			this.setAlive(false);
		}
		// the follow kills ambusher if pacman ate a powerpellet
		else if (map.isScared() == true && (map.getAmbusher().equals(map.getPacMan()))){
			map.setAmbusher(map.getPrison());
			map.setScared(false);
		}
		//the following kills chaser if pacman ate a powerpellet
		else if(map.isScared() == true && (map.getChaser().equals(map.getPacMan()))){
			map.setChaser(map.getPrison());
			map.setScared(false);
		}
		//the following kills fickle if pacman ate a powerpellet
		else if(map.isScared() == true && (map.getFickle().equals(map.getPacMan()))){
			map.setFickle(map.getPrison());
			map.setScared(false);
		}
		//the following kills stupid if pacman ate a powerpellet 
		else if(map.isScared() == true && (map.getStupid().equals(map.getPacMan()))){
			map.setStupid(map.getPrison());
			map.setScared(false);
		}
	}
	/**
	 * toXML convert any character into it's XML object
	 */
	public String toXML(){
		String c = 
			"<Character>\n" +
			"\t<Name>"+name+"</Name>\n" +
			"\t<Coordinate>"+map.getPacMan().toString()+"</Coordinate>\n" +
			"</Character>\n";
		return c;
	}
}
