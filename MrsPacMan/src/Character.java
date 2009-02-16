import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
* This character class establishes the basic behaviour which each character will
* inherit based on what they're  personalities are.  Each ghost has its own individual
* personality which we will attempt to incorporate in order to make the game more dynamic.
* 
* The ghost will stay on its path until it reaches an intersection at which point it will 
* turn left or right.  When PacMan eats a power pellet the ghosts will reverse directions 
* and head for their respective corners.  Once eaten by PacMan the ghost will return to their
* prison and when freed be their original colour.
* 
* The reason for the Chaser and Ambushers names are because they can attack together so the
* player should beware of the corner when there.
* 
* Title: Character Class version 1.1
* Date: February 16, 2009
* Author: Nicole Waldrum and Jef Statham
*/


public class Character implements ActionListener {
	private final int CHASER = 0;
	private final int AMBUSHER = 1;
	private final int FICKLE = 2;
	private final int STUPID = 3;
	private final int PACMAN = 4;
	
	private Point position;
	private String name;
	private boolean incarcerated;
	private boolean scared;
	private boolean scatter;
	private int personality;
	
	
	public void Ghost(int p){
		
	}
	
	public void movetoPacMan(PacMan P){
		
	}
	
	public void movetoPrison(Point p){
		
	}
	
	public void runAway(PacMan p){
		
	}
	
	public void actionPerformed(ActionEvent arg0) {

	}

}
