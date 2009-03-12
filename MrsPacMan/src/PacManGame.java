import java.util.Observable;
import javax.swing.JOptionPane;

/**
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
 * @Date: February 16, 2009
 * @Author: Nicole Waldrum and Jef Statham
 */

/**
 * Class PacManGame
 * 
 * PacMangame runs the rules set for pacman currently accepting user input and
 * notifying the other elements of the game that the user has taken an action.
 * The class also starts the game based on limited user options and has the main
 * method for running the program.
 * 
 * @Author: Jef Statham
 * 
 *          Milestone 3
 * @Date: March 7th, 2009
 * @Author: Jen Kasun and Nicole Waldrum and Jef
 * 
 *          Changed the map to create a default map of MAX size and also changed
 *          the printMap to take a MapGUI. Basically we aligned the data in
 *          PacManGame created by Jef with the Map Class that Nahim created.
 *          
 *          Jef's notes: removed score keeping and array of characters, the corresponding
 *          getters and setters. Added a class variable for PacMan. finished the JOptionPanes for movement.
 */

public class PacManGame extends Observable {

	private static final String STARTMESSAGE = "Howdy Doody!\nWhat would you like to do?";
	private static final String GAMETITLE = "Mrs Pac Man";
	
	protected Map map;
	private PacMan myPacGirl;

	/**
	 * Default constructor for a standard pac man game, with the default pac-man
	 * map and set of standard ghosts.
	 * 
	 */

	public PacManGame() {
		this(new Map());
	}

	/**
	 * Constructor for loading a custom map with standard ghost set.
	 */
	public PacManGame(Map m) {
		myPacGirl = new PacMan();
		// this.addObserver(myPacGirl); this may not be needed
		this.addObserver(new Ambusher());
		this.addObserver(new Fickle());
		this.addObserver(new Stupid());
		this.addObserver(new Chaser());
		/**
		 * Creates a default map of MAX
		 */
		Map map = m;
		/**
		 * magic number make a final STARTING SCORE
		 */
		startGame();

	}

	/**
	 * This returns the current map that pacman is using
	 * 
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * Opens the Starting dialog for the game with choices to close
	 * 
	 * @return return true if valid selection is made false otherwise
	 */
	private boolean startGame() {
		String[] startGameOptions = { // instructions options
		"New Game", "Load Map", "Close" };
		final int NEWGAME = 0;
		final int LOADMAP = 1;
		final int CLOSE = 2;

		/**
		 * Opens a window with Title
		 */
		int choice = JOptionPane.showOptionDialog(null, STARTMESSAGE,
				GAMETITLE, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, startGameOptions,
				startGameOptions[2]);

		String[] movementOptions = { "Up\n", "Left", "Down", "Right" };
		final int UP = 0;
		final int LEFT = 1;
		final int DOWN = 2;
		final int RIGHT = 3;

		if ((choice == -1)) { // possibly need an assert or throwing and
								// exception or make the window unable to be
								// closed with red x aka unable to throw a -1
								// also consider user crashing option dialog crt
								// alt del
			return false;
		}

		switch (choice) { // possibly smelly, suggestions welcome

		case NEWGAME: { // display map wait for user input
			do {
				MapGUI f = new MapGUI("Map GUI");// creates a MapGUI
				map.printMap(f); // prints the MapGUI
				int move = JOptionPane.showOptionDialog(null,
						"Select direction", "Movement Box",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, movementOptions,
						movementOptions[0]);

				switch (move) {
				case UP: {
					myPacGirl.getPosition().translate(0, 1);
					notifyObservers(myPacGirl.getPosition());
				}
					break;
				case LEFT: {
					myPacGirl.getPosition().translate(-1, 0);
					notifyObservers(myPacGirl.getPosition());
				}
					break;
				case DOWN: {
					myPacGirl.getPosition().translate(0, -1);
					notifyObservers(myPacGirl.getPosition());
				}
					break;
				case RIGHT:
					myPacGirl.getPosition().translate(1, 0);
					notifyObservers(myPacGirl.getPosition());
					break;
				}
			} while ((myPacGirl.isAlive()) && (map.getPacdots() >= 0));
			return true;
		}
		case LOADMAP:{
			//new PacManGame(Map.importMap(fileLocation));
		}
			
			return true; // load a map functionality still to be determined.
							// Load from a text document or open a text editor
							// ect.
		case CLOSE:
			return true; // Do nothing

		}
		return false;
	}

	public static void main(String[] args) {
		new PacManGame();
	}
}