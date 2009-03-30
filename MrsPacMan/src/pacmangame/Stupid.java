package pacmangame;
import java.util.Observable;
import java.util.Random;
/**
 * This Stupid class is the orange ghost, whose behaviour is pokey.
 * This ghost is released from the ghost prison last.
 * Stupid has random movements hence the characters name.
 * The respective corner is the bottom left of the screen.
 * 
 * Title: Stupid Class version 1.1
 * @Date: February 16, 2009
 * @Author: Nicole Waldrum and Jef Statham
 * 
 * Milestone 3
 * @Date: March 7th, 2009
 * @Author: Jen Kasun and Nicole Waldrum
 * 
 * Implemented all the methods for Stupid.
 * 
 * Milestone 4
 * @Date March 29, 2009
 * @author Nicole Waldrum
 * 
 * Removed Corner and Prison as Ghost will move towards their corner during the update if they are scared so that
 * method was unnecessary.  Also, since PacMan dies when he runs into a ghost and this is done elsewhere, the ghosts 
 * dying when they are scared will just be re-initialized.
 */

public class Stupid extends Character implements Ghost {
	/**
	 * creates the name for stupid
	 */
	private final String NAME = "Clyde";
	/**
	 * sets the corner that stupid retreats to when in scatter or scared mode
	 */
	private Coordinate Corner = new Coordinate(0,0,map.getIdentity(0,0));
	/**
	 * keeps track of the number of turns
	 */
	private int turns = 0;
	/**
	 * Default Constructor
	 * @param m is the current map that is in use
	 */
	public Stupid(Map m){
		super(m); // current map in use
		this.name = NAME; // sets the stupid name
		m.setScared(false);
	}
	/**
	 * Moves Stupid towards PacMan as per the defined personality
	 * @param p is pacman's current location
	 */
	public void movetoPacMan(Coordinate p){
		if (map.isScared()) {
			
			
		}
		
		boolean a = true;
		while(a){
			Random r = new Random();
			int options = r.nextInt();
			options = options % 4;
			int x = (int)map.getStupid().getX();
			int y = (int)map.getStupid().getY();
			switch (options) {
			  case 0: 
				    if((map.getIdentity(x, y+1)==Coordinate.WALL)||(map.getIdentity(x, y+1)==Coordinate.PRISON)){
				    }
				    else{
				    	map.getStupid().translate(0,1);
				    	a=false;
				    }
				    break;
			  case 1: 
				    if((map.getIdentity(x+1, y)==Coordinate.WALL)||(map.getIdentity(x+1, y)==Coordinate.PRISON)){
				    }
				    else{
				    	map.getStupid().translate(1, 0);
				    	a=false;
				    }
				    break;
			  case 2: 
				    if((map.getIdentity(x, y-1)==Coordinate.WALL)||(map.getIdentity(x, y-1)==Coordinate.PRISON)){
				    }
				    else{
				    	map.getStupid().translate(0, -1);
				    	a=false;
				    }
				    break;
			  case 3: 
				    if((map.getIdentity(x-1, y)==Coordinate.WALL)||(map.getIdentity(x-1, y)==Coordinate.PRISON)){
				    }
				    else{
				    	map.getStupid().translate(-1, 0);
				    	a=false;
				    }
				    break;
			}
		}
	}
	/**
	 * Updates Stupid after PacMan has made a move so that the Stupid ghost may determine its move
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (turns == 2){
			turns = 0;
		}
		else if (map.getStupid() == map.getPrison()){
			turns++;
		}
		if (map.isScared() && map.getStupid() != map.getPrison()){
			Coordinate whereImGoing = GhostPath.AStarSearch(map, map.getStupid(), Corner);
			map.setStupid(whereImGoing);
		}
		else if (map.isScared()== false){
			this.movetoPacMan(null);
		}
		
	}
	/**
	 * toXML convert any character into it's XML object
	 */
	public String toXML(){
		String c = 
			"<Character>\n" +
			"\t<Name>"+this.name+"</Name>\n" +
			"\t<Coordinate>"+map.getStupid().toString()+"</Coordinate>\n" +
			"</Character>\n";
		return c;
	}
	
}
