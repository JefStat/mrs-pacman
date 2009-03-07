import java.awt.Point;
import java.util.Observable;
/*
 * This Stupid class is the orange ghost, whose behaviour is pokey.
 * This ghost is released from the ghost prison last.
 * Stupid has random movements hence the characters name.
 * The respective corner is the bottom left of the screen.
 * 
 * Title: Stupid Class version 1.1
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 * 
 * Milestone 3
 * Date: March 7th, 2009
 * Author: Jen Kasun and Nicole Waldrum
 * 
 * Implemented all the methods for Stupid.
 */

public class Stupid extends Ghost {
	private final int STUPID = 3;
	private final String NAME = "CLYDE";
	private final Coordinate[][] map;
	private final Ghost clyde;
	private final Coordinate CORNER = new Coordinate(0,0, map[0][0].getIdentity());
	
	/*
	 * Default Constructor
	 */
	public Stupid(){
		String name = NAME;
		Ghost clyde = new Ghost();
		clyde.runAway(CORNER);
				
	}
	//Moves Stupid towards PacMan as per the defined personality
	public void movetoPacMan(Coordinate p){
		bool a = true;
		while(a){
			Random r = new Random();
			int options = r.nextInt();
			options = options % 8;
			int x1 = inky.getPostion().x;
			int y1 = inky.getPostion().y;
			switch (options) {
			  case 0: 
			    if((map.[x-1][y+1].getIdentity()==1)||(map.[x-1][y+1].getIdentity()==5)){
			    }
			    else{
			    	Coordinate endpoint = new Coordinate(x-1, y+1, map.[x-1][y+1].getIdentity())
			    	clyde.setPostion(endpoint);
			    	onPath=true:
			    	a=false;
			    }
			    break;
			  case 1: 
				    if((map.[x][y+1].getIdentity()==1)||(map.[x][y+1].getIdentity()==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x, y+1, map.[x][y+1].getIdentity());
				    	clyde.setPostion(endpoint);
				    	onPath=true;
				    	a=false;
				    }
				    break;
			  case 2: 
				    if((map.[x+1][y+1].getIdentity()==1)||(map.[x+1][y+1].getIdentity()==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x+1, y+1, map.[x+1][y+1].getIdentity());
				    	clyde.setPostion(endpoint);
				    	onPath=true;
				    	a=false;
				    }
				    break;
			  case 3: 
				    if((map.[x+1][y].getIdentity()==1)||(map.[x+1][y].getIdentity()==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x+1, y, map.[x+1][y].getIdentity());
				    	clyde.setPostion(endpoint);
				    	onPath=true;
				    	a=false;
				    }
				    break;
			  case 4: 
				    if((map.[x+1][y-1].getIdentity()==1)||(map.[x+1][y-1].getIdentity()==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x+1, y-1, map.[x+1][y-1].getIdentity());
				    	clyde.setPostion(endpoint);
				    	onPath=true;
				    	a=false;
				    }
				    break;
			  case 5: 
				    if((map.[x][y-1].getIdentity()==1)||(map.[x][y-1].getIdentity()==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x, y-1, map.[x][y-1].getIdentity());
				    	clyde.setPostion(endpoint);
				    	onPath=true;
				    	a=false;
				    }
				    break;
			  case 6: 
				    if((map.[x-1][y-1].getIdentity()==1)||(map.[x-1][y-1].getIdentity()==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x-1, y-1, map.[x-1][y-1].getIdentity());
				    	clyde.setPostion(endpoint);
				    	onPath=true;
				    	a=false;
				    }
				    break;
			  case 7: 
				    if((map.[x-1][y].getIdentity()==1)||(map.[x-1][y].getIdentity()==5)){
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x-1, y, map.[x-1][y].getIdentity());
				    	clyde.setPostion(endpoint);
				    	onPath=true;
				    	a=false;
				    }
				    break;
			}
	}
		
	//Returns the cornere that Stupis goes to
	public Coordinate stupidCorner(){
		return CORNER;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
