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
 */

public class Stupid extends Ghost {
	/**
	 * creates the name for stupid
	 */
	private final String NAME = "CLYDE";
	/**
	 * sets the corner that stupid retreats to when in scatter or scared mode
	 */
	private Coordinate Corner;
	
	/**
	 * Default Constructor
	 * @param m is the current map that is in use
	 */
	public Stupid(Map m){
		super(m); // current map in use
		String name = NAME; // sets the stupid name
		Corner = new Coordinate(0,0,m.getIdentity(0,0)); //sets the corner for stupid
		this.runAway(Corner);// set runAway for corner
		this.setPosition(STARTINGPOINT);//sets position as starting point
		setIncarcerated(false);//sets incarcerated to false
		setScared(false);//sets scared to false
	}
	/**
	 * Moves Stupid towards PacMan as per the defined personality
	 * @param p is pacman's current location
	 */
	public void movetoPacMan(Coordinate p){
		boolean a = true;
		while(a){
			Random r = new Random();
			int options = r.nextInt();
			options = options % 8;
			int x = (int)this.getPosition().getX();
			int y = (int)this.getPosition().getY();
			switch (options) {
			  case 0: 
			    if((map.getIdentity(x-1, y+1)==1)||(map.getIdentity(x-1, y+1)==5)){
			    }
			    else{
			    	Coordinate endpoint = new Coordinate(x-1, y+1, map.getIdentity(x-1, y+1));
			    	this.setPosition(endpoint);
			    	a=false;
			    }
			    break;
			  case 1: 
				    if((map.getIdentity(x, y+1)==1)||(map.getIdentity(x, y+1)==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x, y+1, map.getIdentity(x, y+1));
				    	this.setPosition(endpoint);
				    	a=false;
				    }
				    break;
			  case 2: 
				    if((map.getIdentity(x+1, y+1)==1)||(map.getIdentity(x+1, y+1)==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x+1, y+1, map.getIdentity(x+1, y+1));
				    	this.setPosition(endpoint);
				    	a=false;
				    }
				    break;
			  case 3: 
				    if((map.getIdentity(x+1, y)==1)||(map.getIdentity(x+1, y)==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x+1, y, map.getIdentity(x+1, y));
				    	this.setPosition(endpoint);
				    	a=false;
				    }
				    break;
			  case 4: 
				    if((map.getIdentity(x+1, y-1)==1)||(map.getIdentity(x+1, y-1)==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x+1, y-1, map.getIdentity(x+1, y-1));
				    	this.setPosition(endpoint);
				    	a=false;
				    }
				    break;
			  case 5: 
				    if((map.getIdentity(x, y-1)==1)||(map.getIdentity(x, y-1)==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x, y-1, map.getIdentity(x, y-1));
				    	this.setPosition(endpoint);
				    	a=false;
				    }
				    break;
			  case 6: 
				    if((map.getIdentity(x-1, y-1)==1)||(map.getIdentity(x-1, y-1)==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x-1, y-1, map.getIdentity(x-1, y-1));
				    	this.setPosition(endpoint);
				    	a=false;
				    }
				    break;
			  case 7: 
				    if((map.getIdentity(x-1, y)==1)||(map.getIdentity(x-1, y)==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x-1, y, map.getIdentity(x-1, y));
				    	this.setPosition(endpoint);
				    	a=false;
				    }
				    break;
			}
		}
	}
		
	/**
	 * Returns the corner that Stupid goes to
	 * @return stupid corner
	 */
	public Coordinate stupidCorner(){
		return Corner;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
