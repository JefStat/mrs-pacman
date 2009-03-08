import java.awt.event.ActionEvent;
import java.util.Observable;

/* 
 *  This ghost class establishes the basic behaviour which each ghost will
* inherit based on what they're  personalities are.  Each ghost has its own individual
* personality which we will attempt to incorporate in order to make the game more dynamic.
* 
* The ghost will stay on its path until it reaches an intersection at which point it will 
* turn left or right.  When PacMan eats a power pellet the ghosts will reverse directions 
* and head for their respective corners.  Once eaten by PacMan the ghost will return to their
* prison and when freed be their original colour.
* 
* The reason for the Chaser and Ambusher names are because they can attack together so the
* player should beware of the corner when there.
* 
* Title: Character Class version 1.1
* Date: February 16, 2009
* Author: Nicole Waldrum and Jef Statham
* 
* This Ghost class overrides the Character Class to implement the typical characteristics of all 4 ghosts.
* Each individual ghost will override the MoveToPacMan Class when their individual personalities are implemented.
* 
* Version: Ghost Class 2.3
* Date: March 2, 2009
* Author: Nicole Waldrum
* 
* Milestone 3
* Date: March 7th, 2009
* Author: Jen Kasun and Nicole Waldrum
* 
* Implemented all the methods for Ghost.
*/

public class Ghost extends Character {
	private static final String GHOST = "Ghost";
	private boolean incarcerated;
	private boolean scared;
	private boolean scatter;
	private static Coordinate position;
	private final Coordinate STARTINGPOINT = map.getPrison();
	private Ambusher GhostAmbusher;
	private Chaser GhostChaser;
	private Stupid GhostStupid;
	private Fickle GhostFickle;
	
	//constructor that creates an instance of ghost and ensures that everything is set to false
	public Ghost(){
		name = GHOST;
		position = STARTINGPOINT;
		setIncarcerated(false);
		scared = false;		
	}
	//checks PacMan's location then moves towards PacMan
	public void movetoPacMan(Coordinate P){
		if (this.isAlive() == true && P == this.getPosition()){
			if (this.scared == true){
				this.setAlive(false);
				this.setIncarcerated(true);
				this.movetoPrison(STARTINGPOINT);
			}
		}
		else if(this.isAlive()== true && P != this.getPosition()){
			if(this.scared == true){
				position = GhostAmbusher.ambusherCorner();
				position = GhostFickle.fickleCorner();
				position = GhostStupid.stupidCorner();
				position = GhostChaser.chaserCorner();
			}
			else if(this.scared == false){
				//GhostPath.AStarSearch(P);
			}
		}
	}
	//moves the ghost to prison after they are eaten
	public void movetoPrison(Coordinate p){
		if (this.isAlive()== false){
			this.setPosition(STARTINGPOINT);
			this.setAlive(true);
			this.setIncarcerated(false);
			this.scared = false;
			this.setScatter(false);
		}
	}
	//if the ghost is scared they run away from PacMan
	public void runAway(Coordinate p){
		this.scared = true;
		if(this.isAlive() == true){
			
		}
	}
	public void actionPerformed(ActionEvent arg0){
		
	}
	//This returns the current position of Ghost
	public static Coordinate getPosition(){
		return position;
		
	}
	//This sets the current position of a Ghost
	public static void setPosition(Coordinate p){
		position = p;
	}
	//sets whether or not the ghost is incarcerated
	public void setIncarcerated(boolean incarcerated) {
		this.incarcerated = incarcerated;
	}
	//check if the ghost is incarcerated
	public boolean isIncarcerated() {
		return incarcerated;
	}
	//sets whether or not the ghosts scatter
	public void setScatter(boolean scatter) {
		this.scatter = scatter;
	}
	// checks if the ghosts scatter
	public boolean isScatter() {
		return scatter;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
