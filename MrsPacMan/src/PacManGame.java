import java.awt.Point;
import java.util.ArrayList;
/*
 * Group Awesomeness Legendary PacManGame 
 *  
 * This is a turn-based PacMan Game that will work like the original PacMan
 * Game created in Japan with modifications made according to the professors 
 * specifications.  
 * 
 * The team creating this game consists for 4 students: Jen Kasun, Nahim Nasser,
 * Jef Statham and Nicole Waldrum.  Occasionally MrsPacMan may come up as a file
 * name since this group contains the only two girls in the class and they continually
 * feel the need to make themselves known in passive-aggressive ways.
 * 
 * Title: PacManGame Class version 1.1
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 */


public class PacManGame {

	private final int CHARS = 5;
	private final long FREELIFE = 10000; 
	
	private long score;
	private ArrayList Characters;
	private ArrayList Map;
	
	/*
	 * Default constructor with a default map
	 */
	
	public PacManGame(){
		
	}
	
	/*
	 * Constructor for loading a custom map
	 */
	public PacManGame(ArrayList M){
		
	}
	
	/*
	 * Checking the map if coordinate p is a valid move
	 * 
	 * return true if valid false otherwise
	 */
	public boolean CheckMovement(Point p){
		return false;	
	}
	
	/*
	 * Updates all the characters to a valid movement input
	 */
	public void notify(Object o){
		
	}
}
