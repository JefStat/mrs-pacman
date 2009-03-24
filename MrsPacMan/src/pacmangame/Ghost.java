package pacmangame;
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
* 
* Jef's notes: Made ghost an Interface.
*/

public interface Ghost {
	/**
	 * checks PacMan's location then moves towards PacMan
	 * @param P is pacman's current location
	 */
	public void movetoPacMan(Coordinate P);
	/**
	 * moves the ghost to prison after they are eaten
	 * @param p is the location of the prison
	 */
	public void movetoPrison(Coordinate p);
}
