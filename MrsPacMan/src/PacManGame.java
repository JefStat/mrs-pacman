import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
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

	private static final String STARTMESSAGE = "Howdy Doody!\nWhat would you like to do?";
	private static final String GAMETITLE = "Mrs Pac Man";
	private final int CHARS = 4;
	private final long FREELIFE = 10000; 
	
	private boolean playersTurn;
	private long score;
	private ArrayList<Character> Characters = new ArrayList<Character>();
	private Map map;
	
	
	/*
	 * Default constructor for a standard pac man game, 
	 * with the default pac-man map and set of standard ghosts.
	 * 
	 */
	
	public PacManGame(){
		Characters.add(new PacMan());
		Characters.add(new Ghost());
		Characters.add(new Ghost());
		Characters.add(new Ghost());
		Characters.add(new Ghost());
		setMap(new Map(30)); 	//using magic number while waiting for implementation
		setScore(0);		//magic number make final STARTING SCORE
		playersTurn = true;
		startGame();
	}
	
	/*
	 * Constructor for loading a custom map with
	 * standard ghost set.
	 */
	public PacManGame(Map M){
		
	}
	/**
	 * @param map the map to set
	 */
	private void setMap(Map map) {
		this.map = map;
	}

	/**
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * @param score the score to set
	 */
	private void setScore(long score) {
		this.score = score;
	}

	/**
	 * @return the score
	 */
	private long getScore() {
		return score;
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
	 * Opens the Starting dialog for the game with choices to close
	 * 
	 * return true if valid selection is made false otherwise
	 */
	private boolean startGame(){
		String[] startGameOptions = {	// consider adding and instructions option
				  "New Game",
				  "Load Map",
				  "Close"
				  };
		final int NEWGAME = 0;
		final int LOADMAP = 1;
		final int CLOSE = 2;
		
		//Opens a window with Title 
		int choice = JOptionPane.showOptionDialog(null, STARTMESSAGE, GAMETITLE, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, startGameOptions, startGameOptions[2]);
		
		String[] movementOptions = {
			    "W\n",
			"S","A","D"
		};
		int move = -1;
		
		if ((choice == -1)) {		// need an assert or throwing and exception or make the window unable to be closed with red x aka unable to throw a -1 also consider user crashing option dialog crt alt del
			return false;
		}
		
		switch(choice){			//possibly smelly, suggestions welcome
		
		case NEWGAME: {
			do {
			map.printMap();
			}
			while(Characters.get(PacMan.PACMAN));
			return true; // display map wait for user input
		}
		case LOADMAP: return true; // load a map functionality still to be determined. Load from a text document or open a text editor ect.
		case CLOSE: return true;   // Do nothing
		
		}
		
			System.out.println(choice);		
	return false;
	}
	
	/*
	 * This is where the magic happens. 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
public static void main(String[] args) {
	new PacManGame();
}
}