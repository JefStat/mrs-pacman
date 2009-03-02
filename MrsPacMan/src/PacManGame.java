import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
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


/*
 * Class PacManGame
 * 
 * PacMan game runs the rules set for pacman currently accepting user input and notifying
 * the other elements of the game that the user has taken an action. The class also starts
 * the game based on limited user options and has the main method for running the program. 
 */


public class PacManGame implements ActionListener {

	private final int CHARS = 4;
	private final long FREELIFE = 10000; 
	
	private boolean playersTurn;
	private long score;
	private ArrayList Characters = new ArrayList(CHARS);
	private Map map;
	
	
	/*
	 * Default constructor for a standard pac man game, 
	 * with the default pac-man map and set of standard ghosts.
	 * 
	 */
	
	public PacManGame(){
		Characters[0] = new PacMan();
		Characters[1] = new Ghost(new Coordinate(0,0));
		Characters[2] = new Ghost(new Coordinate(0,0));
		Characters[3] = new Ghost(new Coordinate(0,0));
		Characters[4] = new Ghost(new Coordinate(0,0));
		map = new Map();
		score = 0;
		playersTurn = true;
		startGame();
	}
	
	/*
	 * Constructor for loading a custom map with
	 * standard ghost set.
	 */
	public PacManGame(Map M){
		
	}
	/*
	 * Checks to see if game is ready for more input from user
	 */
	private boolean isPlayersTurn() {
	
		return playersTurn;
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

	/*
	 * 
	 */
	private void startGame(){
		String[] startGameOptions = {
				  "New Game",
				  "Load Map",
				  };
		JOptionPane Game = null;
		Game.showOptionDialog(null, "Howdy Doody!\nWhat would you like to do?", "Mrs Pac Man", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, startGameOptions, null);
		if (!(Game.getValue() == JOptionPane.UNINITIALIZED_VALUE)) {
			// Find value that is returned for each press and then create action for return value.
			System.out.println(Game.getValue());		
		}	
	}
	/*
	 * This is where the magic happens. 
	 */
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
public static void main(String[] args) {
	
}
}