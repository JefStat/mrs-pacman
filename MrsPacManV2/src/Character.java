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
 * Title: Character Class version 1.0
 * Date: February 15, 2009
 * Author: Nicole Waldrum
 */
public class Character extends PacManGame{

}
