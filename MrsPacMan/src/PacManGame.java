import java.awt.Point;
import java.util.ArrayList;
/*
 * Group Awesomeness Legendary PacManGame 
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
