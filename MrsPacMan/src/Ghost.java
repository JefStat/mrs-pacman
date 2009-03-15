import java.awt.event.ActionEvent;
import java.util.Observable;

/** 
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
* @Date: February 16, 2009
* @Author: Nicole Waldrum and Jef Statham
* 
* This Ghost class overrides the Character Class to implement the typical characteristics of all 4 ghosts.
* Each individual ghost will override the MoveToPacMan Class when their individual personalities are implemented.
* 
* Version: Ghost Class 2.3
* @Date: March 2, 2009
* @Author: Nicole Waldrum
* 
* Milestone 3
* @Date: March 7th, 2009
* @Author: Jen Kasun and Nicole Waldrum
* 
* Implemented all the methods for Ghost.
*/

public abstract class Ghost extends Character {
	/**
	 * imports the current map in use
	 * @param m is the current map
	 */
	public Ghost(Map m) {
		super(m);
	}
	/**
	 * this is the path that ghost may be on
	 */
	static GhostPath path;
	/**
	 * keeps track of each ghosts incarceration
	 */
	static boolean incarcerated;
	/**
	 * keeps track if the ghost is scared
	 */
	private boolean scared;
	/**
	 * keeps track if the ghost is scattered
	 */
	private boolean scatter;
	/**
	 * keeps track of the ghosts position
	 */
	private Coordinate position;
	/**
	 * keeps all the ghost in the prison at the beginning, except for ambusher
	 */
	protected Coordinate STARTINGPOINT = map.getPrison();
	/**
	 * checks PacMan's location then moves towards PacMan
	 * @param P is pacman's current location
	 */
	public void movetoPacMan(Coordinate P){
		if (this.isAlive() == true && P == this.getPosition()){ //if the ghost is alive and where pacman is
			if (this.isScared() == true){//if the ghost is scared
				this.setAlive(false); //ghost dies
				this.setIncarcerated(true);//ghost goes to prison
				this.movetoPrison(STARTINGPOINT); //ghost moves to prison
			}
		}else if(this.isScared() == false){ //if ghost not scared
				path.AStarSearch(P);//find pacman
			}
		}
	/**
	 * moves the ghost to prison after they are eaten
	 * @param p is the location of the prison
	 */
	public void movetoPrison(Coordinate p){
		if (this.isAlive()== false){//ghost has died
			this.setPosition(STARTINGPOINT);//returns the ghost to the starting point prison
			this.setAlive(true); //returns them to life
			this.setIncarcerated(false); //ghost is no longer incarcerated
			this.setScared(false); //ghost is no longer scared
			this.setScatter(false); // ghost no longer scatters
		}
	}
	/**
	 * if the ghost is scared they run away from PacMan
	 * @param p is the location of the ghost corner
	 */
	public void runAway(Coordinate p){
		this.setScared(true);
		if(this.isAlive() == true){
			
		}
	}
	/**
	 * This returns the current position of Ghost
	 * @return current position of the ghost
	 */
	public Coordinate getPosition(){
		return position;
		
	}
	/**
	 * This sets the current position of a Ghost
	 * @param set the current location of the ghost
	 */
	public boolean setPosition(Coordinate p){
		position = p;
		return true;
	}
	/**
	 * sets whether or not the ghost is incarcerated
	 * @param incarcerated for if the ghost is in jail
	 */
	public void setIncarcerated(boolean incarcerated) {
		this.incarcerated = incarcerated;
	}
	/**
	 * check if the ghost is incarcerated
	 * @return incarcerated ghost is jailed or not
	 */
	public boolean isIncarcerated() {
		return incarcerated;
	}
	/**
	 * sets whether or not the ghosts scatter
	 * @param scatter should occur when ghosts scared
	 */
	public void setScatter(boolean scatter) {
		this.scatter = scatter;
	}
	/**
	 *  checks if the ghosts scatter
	 * @return scatter if ghost should run to corner
	 */
	public boolean isScatter() {
		return scatter;
	}
	/**
	 * sets whether or not the ghost is scared (pacman ate a powerpellet)
	 * @param scared set when pacMan eats a powerpellet
	 */
	public void setScared(boolean scared) {
		this.scared = scared;
	}
	/**
	 * returns the status of the ghost after pacman eats a powerpellet
	 * @return true when Powerpellet is eaten and false after a certain number of turns or ghost is eaten by pacman
	 */
	public boolean isScared() {
		return scared;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		this.movetoPacMan((Coordinate)arg1);
		
	}
}
