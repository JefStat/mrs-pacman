import java.awt.Point;
import java.math.*;
import java.util.Observable;
import java.util.random
/*
 * This Fickle class is the blue ghost, whose behaviour is bashful.
 * Released third out of the ghost pen after Chaser and Ambusher are off.
 * Fickle will move about the board randomly but may follow if close to PacMan.
 * The respective corner is the bottom right of the screen.
 * 
 * Title: Fickle Class version 1.1
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 * 
 * Milestone 3
 * Date: March 7th, 2009
 * Author: Jen Kasun and Nicole Waldrum
 * 
 * Implemented all the methods for Fickle.
 */


public class Fickle extends Ghost{
	private final int FICKLE = 2;
	private final String NAME = "Inky";
	private final Coordinate[][] map;
	private final Ghost inky;
	private final Coordinate CORNER = new Coordinate(Map.MAX,0, map[Map.MAX][0].getIdentity());
	private static bool onPath;
	
	/*
	 * Default Constructor
	 */
	public Fickle(){
		String name = NAME;
		Ghost inky = new Ghost();
		inky.runAway(CORNER);
		onPath = false;
	}
	//Moves Fickle towards PacMan as the defined personality indicates
	public void movetoPacMan(Coordinate p){
		if(Map.getSize()/4<=(Math.sqrt(GhostPath.pathDistanceEstimate(inky.getPosition(), p, inky)))){
			inky.setPosition(inky.AStarSearch(p));
			}
		else{
			if(onPath){
				//will write in a few minutes
			}
			else{
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
					    	inky.setPostion(endpoint);
					    	onPath=true:
					    	a=false;
					    }
					    break;
					  case 1: 
						    if((map.[x][y+1].getIdentity()==1)||(map.[x][y+1].getIdentity()==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x, y+1, map.[x][y+1].getIdentity());
						    	inky.setPostion(endpoint);
						    	onPath=true;
						    	a=false;
						    }
						    break;
					  case 2: 
						    if((map.[x+1][y+1].getIdentity()==1)||(map.[x+1][y+1].getIdentity()==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x+1, y+1, map.[x+1][y+1].getIdentity());
						    	inky.setPostion(endpoint);
						    	onPath=true;
						    	a=false;
						    }
						    break;
					  case 3: 
						    if((map.[x+1][y].getIdentity()==1)||(map.[x+1][y].getIdentity()==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x+1, y, map.[x+1][y].getIdentity());
						    	inky.setPostion(endpoint);
						    	onPath=true;
						    	a=false;
						    }
						    break;
					  case 4: 
						    if((map.[x+1][y-1].getIdentity()==1)||(map.[x+1][y-1].getIdentity()==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x+1, y-1, map.[x+1][y-1].getIdentity());
						    	inky.setPostion(endpoint);
						    	onPath=true;
						    	a=false;
						    }
						    break;
					  case 5: 
						    if((map.[x][y-1].getIdentity()==1)||(map.[x][y-1].getIdentity()==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x, y-1, map.[x][y-1].getIdentity());
						    	inky.setPostion(endpoint);
						    	onPath=true;
						    	a=false;
						    }
						    break;
					  case 6: 
						    if((map.[x-1][y-1].getIdentity()==1)||(map.[x-1][y-1].getIdentity()==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x-1, y-1, map.[x-1][y-1].getIdentity());
						    	inky.setPostion(endpoint);
						    	onPath=true;
						    	a=false;
						    }
						    break;
					  case 7: 
						    if((map.[x-1][y].getIdentity()==1)||(map.[x-1][y].getIdentity()==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x-1, y, map.[x-1][y].getIdentity());
						    	inky.setPostion(endpoint);
						    	onPath=true;
						    	a=false;
						    }
						    break;

			}
			
		}
		
	}
	//Returns the corner that Fickle runs to
	public Coordinate fickleCorner(){
		return CORNER;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
