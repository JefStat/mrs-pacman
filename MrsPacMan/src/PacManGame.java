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
	public PacMan myPacGirl;

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
		/**
		 * Creates a default map of MAX
		 */
		map = m;
		
		myPacGirl = new PacMan(m);
		this.addObserver(myPacGirl); 
		this.addObserver(new Ambusher(m));
		this.addObserver(new Fickle(m));
		this.addObserver(new Stupid(m));
		this.addObserver(new Chaser(m));
		
		startGame();

	}

	/**
	 * This returns the current map that pacman is using
	 * 
	 * @return the map
	 */
	public Coordinate[][] getMap() {
		return map.getMap();
	}
	
	public Map getMap(int i){
		return map;
	}

	/**
	 * Opens the Starting dialog for the game with choices to close or start a new game.
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

		String[] movementOptions = { "Up\n", "Left", "Down", "Right","Exit" };
		final int UP = 0;
		final int LEFT = 1;
		final int DOWN = 2;
		final int RIGHT = 3;
		final int EXIT = 4;

		if ((choice == -1)) { // possibly need an assert or throwing and
								// exception or make the window unable to be
								// closed with red x aka unable to throw a -1
								// also consider user crashing option dialog crt
								// alt del
			return false;
		}

		switch (choice) { // possibly smelly, suggestions welcome

		case NEWGAME: { // display map wait for user input
			MapGUI f = new MapGUI(GAMETITLE);// creates a MapGUI
			f.setMap(map); // prints the MapGUI
			f.buildGUI();
			do {
				int move = JOptionPane.showOptionDialog(null,
						"Select direction", "Movement Box",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, movementOptions,
						movementOptions[0]);

				switch (move) {
				case UP: {
					myPacGirl.setPosition(new Coordinate((int)myPacGirl.getPosition().getX(), (int)myPacGirl.getPosition().getY() + 1, Coordinate.EMPTY));
					this.setChanged();
					notifyObservers(myPacGirl.getPosition());
					f.updateGUI(this);
				}
					break;
				case LEFT: {
					myPacGirl.setPosition((new Coordinate((int)myPacGirl.getPosition().getX() - 1, (int)myPacGirl.getPosition().getY(), Coordinate.EMPTY)));
					this.setChanged();
					notifyObservers(myPacGirl.getPosition());
					f.updateGUI(this);
				}
					break;
				case DOWN: {
					myPacGirl.setPosition((new Coordinate((int)myPacGirl.getPosition().getX(), (int)myPacGirl.getPosition().getY() - 1, Coordinate.EMPTY)));
					this.setChanged();
					notifyObservers(myPacGirl.getPosition());
					f.updateGUI(this);
				}
					break;
				case RIGHT:{
					myPacGirl.setPosition((new Coordinate((int)myPacGirl.getPosition().getX() + 1, (int)myPacGirl.getPosition().getY(), Coordinate.EMPTY)));
					this.setChanged();
					notifyObservers(myPacGirl.getPosition());
					f.updateGUI(this);
				}
					break;
				case EXIT:{
					return true;
				}
					
			}
				} while ((myPacGirl.isAlive()) && (map.getPacdots() >= 0));
			return true;
			}
		/*
		 * This case may be obsolete and removed otherwise will be implemented
		 */
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

	public Coordinate whereInTheMapIsPacman(){
		return myPacGirl.getPosition();
	}
	
	public static void main(String[] args) {
		new PacManGame();
	}
}