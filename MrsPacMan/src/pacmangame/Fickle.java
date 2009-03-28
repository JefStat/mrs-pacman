package pacmangame;
import java.util.Observable;
import java.util.Random;
/**
 * This Fickle class is the blue ghost, whose behaviour is bashful.
 * Released third out of the ghost pen after Chaser and Ambusher are off.
 * Fickle will move about the board randomly but may follow if close to PacMan.
 * The respective corner is the bottom right of the screen.
 * 
 * Title: Fickle Class version 1.1
 * @Date: February 16, 2009
 * @Author: Nicole Waldrum and Jef Statham
 * 
 * Milestone 3
 * @Date: March 7th, 2009
 * @Author: Jen Kasun and Nicole Waldrum
 * 
 * Implemented all the methods for Fickle.
 * 
 * 
 * Fickle works just because it can.
 */


public class Fickle extends Character implements Ghost{
	/**
	 * this is the official name of fickle
	 */
	private final String NAME = "Inky";
	/**
	 * this identifies the location of fickles corner when in scared or scatter mode
	 */
	private Coordinate Corner;
	/**
	 * this checks if fickle is on a path towards pacman
	 */
	private static boolean onPath;
	/**
	 * this checks the direction that fickle is moving in
	 */
	private static int direction;
	/**
	 * this is the path that fickle is on and checks the A* Algorithm for the fastest route to pacman
	 */
	//private GhostPath path;
	/**
	 * keeps track of whether or not the ghost is scared
	 */
	private boolean scared;
	/**
	 * Default Constructor
	 */
	public Fickle(Map m){
		super(m); //gets the current map
		this.name = NAME; //sets the name
		Corner = new Coordinate(map.getSize()-1,0,0);//sets the corner
		onPath = false; //is not on pacman's oath
		//path = new GhostPath(NAME, map);//creates a new ghostpath
		setScared(false); //sets ghost is not scared
	}
	
	public boolean setPosition(Coordinate p){
		int dx = (int) (p.getX() - map.getFickle().getX());
		int dy = (int) (p.getY() - map.getFickle().getY());
		map.getFickle().translate(dx, dy);
		return true;
	}
	/**
	 * Moves Fickle towards PacMan as the defined personality indicates
	 * @param p is the position of pacman currently
	 */
	public void movetoPacMan(Coordinate p){
	
		int x = (int)map.getFickle().getX();
		int y = (int)map.getFickle().getY();
		if((map.getSize()-1)/4<=(Math.sqrt(GhostPath.pathDistanceEstimate(map.getFickle(), p)))){
			Coordinate whereImGoing = GhostPath.AStarSearch(map, map.getFickle(), map.getPacMan());
			this.setPosition(whereImGoing);
			}
		else{
			if(onPath){
				switch (direction){
				case 0:
					if((map.getIdentity(x-1, y+1)==1)||(map.getIdentity(x-1, y+1)==5)){
						onPath = false;
						this.movetoPacMan(p);
				    }
					else{
						Coordinate endpoint = new Coordinate(x-1, y+1, map.getIdentity(x-1, y+1));
				    	this.setPosition(endpoint);
					}
					break;
				case 1:
					if((map.getIdentity(x, y+1)==1)||(map.getIdentity(x, y+1)==5)){
						onPath=false;
						this.movetoPacMan(p);
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x, y+1, map.getIdentity(x, y+1));
				    	this.setPosition(endpoint);
				    }
					break;
				case 2:
					if((map.getIdentity(x+1 ,y+1)==1)||(map.getIdentity(x+1 ,y+1)==5)){
						onPath=false;
						this.movetoPacMan(p);
					}
				    else{
				    	Coordinate endpoint = new Coordinate(x+1, y+1, map.getIdentity(x+1 ,y+1));
				    	this.setPosition(endpoint);
				    }
					break;
				case 3:
					if((map.getIdentity(x+1 ,y)==1)||(map.getIdentity(x+1 ,y)==5)){
						onPath=false;
						this.movetoPacMan(p);
					}
				    else{
				    	Coordinate endpoint = new Coordinate(x+1, y, map.getIdentity(x+1 ,y));
				    	this.setPosition(endpoint);
				    }
					break;
				case 4:
					if((map.getIdentity(x+1 ,y-1)==1)||(map.getIdentity(x+1 ,y-1)==5)){
						onPath=false;
						this.movetoPacMan(p);
					}
				    else{
				    	Coordinate endpoint = new Coordinate(x+1, y-1, map.getIdentity(x+1 ,y-1));
				    	this.setPosition(endpoint);
				    }
					break;
				case 5:
					if((map.getIdentity(x ,y-1)==1)||(map.getIdentity(x ,y-1)==5)){
						onPath=false;
						this.movetoPacMan(p);
					}
				    else{
				    	Coordinate endpoint = new Coordinate(x, y-1, map.getIdentity(x ,y-1));
				    	this.setPosition(endpoint);
				    }
					break;
				case 6:
					if((map.getIdentity(x-1,y-1)==1)||(map.getIdentity(x-1,y-1)==5)){
						onPath=false;
						this.movetoPacMan(p);
					}
				    else{
				    	Coordinate endpoint = new Coordinate(x-1, y-1, map.getIdentity(x-1,y-1));
				    	this.setPosition(endpoint);
				    }
				    break;
				case 7:
					if((map.getIdentity(x-1,y)==1)||(map.getIdentity(x-1,y)==5)){
						onPath=false;
						this.movetoPacMan(p);
				    }
				    else{
				    	Coordinate endpoint = new Coordinate(x-1, y, map.getIdentity(x-1,y));
				    	this.setPosition(endpoint);
				    }
					break;
				}
			}
			else{
				boolean a = true;
				while(a){
					Random r = new Random();
					int options = r.nextInt();
					options = options % 8;
					switch (options) {
					  case 0: 
					    if((map.getIdentity(x-1,y+1)==1)||(map.getIdentity(x-1,y+1)==5)){
					    }
					    else{
					    	Coordinate endpoint = new Coordinate(x-1, y+1, map.getIdentity(x-1,y+1));
					    	this.setPosition(endpoint);
					    	onPath=true;
					    	direction = 0;
					    	a=false;
					    }
					    break;
					  case 1: 
						    if((map.getIdentity(x,y+1)==1)||(map.getIdentity(x,y+1)==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x, y+1, map.getIdentity(x,y+1));
						    	this.setPosition(endpoint);
						    	onPath=true;
						    	direction =1;
						    	a=false;
						    }
						    break;
					  case 2: 
						    if((map.getIdentity(x+1,y+1)==1)||(map.getIdentity(x+1,y+1)==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x+1, y+1, map.getIdentity(x+1,y+1));
						    	this.setPosition(endpoint);
						    	onPath=true;
						    	direction =2;
						    	a=false;
						    }
						    break;
					  case 3: 
						    if((map.getIdentity(x+1,y)==1)||(map.getIdentity(x+1,y)==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x+1, y, map.getIdentity(x+1,y));
						    	this.setPosition(endpoint);
						    	onPath=true;
						    	direction =3;
						    	a=false;
						    }
						    break;
					  case 4: 
						    if((map.getIdentity(x+1,y-1)==1)||(map.getIdentity(x+1,y-1)==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x+1, y-1, map.getIdentity(x+1,y-1));
						    	this.setPosition(endpoint);
						    	onPath=true;
						    	direction =4;
						    	a=false;
						    }
						    break;
					  case 5: 
						    if((map.getIdentity(x,y-1)==1)||(map.getIdentity(x,y-1)==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x, y-1, map.getIdentity(x,y-1));
						    	this.setPosition(endpoint);
						    	onPath=true;
						    	direction =5;
						    	a=false;
						    }
						    break;
					  case 6: 
						    if((map.getIdentity(x-1,y-1)==1)||(map.getIdentity(x-1,y-1)==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x-1, y-1, map.getIdentity(x-1,y-1));
						    	this.setPosition(endpoint);
						    	onPath=true;
						    	direction =6;
						    	a=false;
						    }
						    break;
					  case 7: 
						    if((map.getIdentity(x-1,y)==1)||(map.getIdentity(x-1,y)==5)){
						    }
						    else{
						    	Coordinate endpoint = new Coordinate(x-1, y, map.getIdentity(x-1,y));
						    	this.setPosition(endpoint);
						    	onPath=true;
						    	direction =7;
						    	a=false;
						    }
						    break;
					}
				}
			}
		}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		this.movetoPacMan(((NotifierObject)arg1).getC());
		
	}

	@Override
	public void movetoPrison(Coordinate p) {
		
	}
	/**
	 * sets whether or not the ghost is scared based on PacMan eating a powerpellet
	 * @param scared
	 */
	public void setScared(boolean scared) {
		this.scared = scared;
	}
	/**
	 * returns whether or not the ghost is scared based on PacMan eating a powerpellet
	 * @return ghost status of scared
	 */
	public boolean isScared() {
		return scared;
	}
	/**
	 * Returns the corner that Fickle runs to
	 * @return fickle corner
	 */
	public Coordinate fickleCorner(){
		return Corner;
	}
	/**
	 * toXML convert any character into it's XML object
	 */
	public String toXML(){
		String c = 
			"<Character>\n" +
			"\t<Name>"+this.name+"</Name>\n" +
			"\t<Coordinate>"+map.getFickle().toString()+"</Coordinate>\n" +
			"</Character>\n";
		return c;
	}
}
