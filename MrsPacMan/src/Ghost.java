import java.awt.Point;
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
 */
import java.awt.event.ActionEvent;
/*
 * This Ghost class overrides the Character Class to implement the typical characteristics of all 4 ghosts.
 * Each individual ghost will override the MoveToPacMan Class when their individual personalities are implemented.
 * 
 * Version: Ghost Class 2.3
 * Date: March 2, 2009
 * Author: Nicole Waldrum
 */

public class Ghost extends Character {
	private final int CHASER = 0;
	private final int AMBUSHER = 1;
	private final int FICKLE = 2;
	private final int STUPID = 3;
	
	private boolean incarcerated;
	private boolean scared;
	private boolean scatter;
	private Coordinate previousPosition;
	private final Coordinate STARTINGPOINT = map.getPrison();
	
	//constructor that creates an instance of ghost and ensures that everything is set to false
	public void Ghost(){
		Coordinate startPosition = setPosition(STARTINGPOINT);
		incarcerated = false;
		scared = false;
	}
	//checks PacMan's location then moves towards PacMan
	public void movetoPacMan(PacMan P){
		if (this.isAlive() == true && P.getPosition() == this.getPosition()){
			if (this.scared == true){
				this.setAlive(false);
				this.incarcerated = true;
				this.movetoPrison(p);
			}
		}
		else if(this.isAlive()== true && P.getPosition() != this.getPosition()){
			
		}
	}
	//moves the ghost to prison after they are eaten
	public void movetoPrison(Coordinate p){
		if (this.isAlive()== false){
			this.setPosition(map.getprison());
			this.setAlive(true);
			this.incarcerated = false;
			this.scared = false;
		}
	}
	//if the ghost is scared they run away from PacMan
	public void runAway(PacMan p){
		this.scared = true;
		if(this.isAlive() == true){
			this.setPosition(this.previousPosition);
		}
	}
	public void actionPerformed(ActionEvent arg0){
		
	}
}
