package pacmangame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import javax.swing.JOptionPane;

/**
 * Group Awesomeness Legendary PacManGame 
 *  
 * This is a turn-based PacMan Game that will work like the original PacMan
 * Game created in Japan with modifications made according to the professor's 
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
 * Milestone 3
 * @Date: March 7th, 2009
 * @Author: Jen Kasun and Nicole Waldrum and Jef
 * 
 * Changed the map to create a default map of MAX size and also changed
 * the printMap to take a MapGUI. Basically we aligned the data in
 * PacManGame created by Jef with the Map Class that Nahim created.
 *          
 * Jef's notes: removed score keeping and array of characters, the corresponding
 * getters and setters. Added a class variable for PacMan. finished the JOptionPanes for movement.
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
 * Milestone 4
 * @Date: March 30th, 2009
 * 
 * implemented a keyListner. up down left right and q keys watched. this is to allow the buttons on the frame to be pressed. Also removed the frame from pac man game. Each ghost was updated to use the new Notifier object that is pass during an update.
 */

public class PacManGame extends Observable implements KeyListener{
	/**
	 * all the variables required to properly implement the KeyListener of PacManGame
	 */
	private final String STARTMESSAGE = "Welcome to PacMan!\n Make your choice.";
	private final String GAMETITLE = "Mrs Pac Man";
	public static final int UP = 0;
	public static final int LEFT = 1;
	public static final int DOWN = 2;
	public static final int RIGHT = 3;
	public static final int EXIT = 4;
	
	protected Map map;
	public PacMan myPacGirl;

	/**
	 * Default constructor for a standard pac man game, with the default pac-man
	 * map and set of standard ghosts.
	 * 
	 */

	public PacManGame() {
		this(MapGUI.importlevel("level1"));
	}

	/**
	 * Constructor for loading a custom map with standard ghost set.
	 * @param m is the current map that is created by PacManGame() constructor
	 */
	public PacManGame(Map m) {
		/**
		 * Creates a default map of MAX
		 */
		map = m;
		
		myPacGirl = new PacMan(m);
		this.addObserver(myPacGirl); 
		this.addObserver(new Ambusher(m));
		//this.addObserver(new Fickle(m));
		this.addObserver(new Stupid(m));
		this.addObserver(new Chaser(m));
		
		startGame();

	}
	
	/**
	 * gets the map that is currently in use with a set size
	 * @param i is the size of the map
	 * @return map, the size of the map
	 */
	public Map getMap(){
		return map;
	}

	/**
	 * Opens the Starting dialog for the game with choices to close or start a new game.
	 * 
	 * @return return true if valid selection is made false otherwise
	 */
	private boolean startGame() {
		String[] startGameOptions = { // instructions options
		"New Game", "Close" };
		final int NEWGAME = 0;
		final int CLOSE = 1;
		/**
		 * Opens a window with Title
		 */
		int choice = JOptionPane.showOptionDialog(null, STARTMESSAGE,
				GAMETITLE, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, startGameOptions,
				startGameOptions[1]);

		if ((choice == -1)) { // possibly need an assert or throwing and
								// exception or make the window unable to be
								// closed with red x aka unable to throw a -1
								// also consider user crashing option dialog crt
								// alt del
			return false;
		}

		switch (choice) { // possibly smelly, suggestions welcome

		case NEWGAME: { // display map wait for user input
			new MapGUI(GAMETITLE,this);// creates a MapGUI
			return true;
			}
		/**
		 * This case may be obsolete and removed otherwise will be implemented
		 */
		case CLOSE:
			return true; // Do nothing

		}
		return false;
	}
	
	public static void main(String[] args) {
		new PacManGame();
	}
	/**
	 * when the key is typed by the user
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * when the key is released by the user
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * when a key is pressed by the user
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
			int keycode = arg0.getKeyCode();
			if (map.getPacdots() == 0){
				JOptionPane.showMessageDialog(null, "You win!", "Iwinnar", JOptionPane.INFORMATION_MESSAGE);
				this.setChanged();
				notifyObservers(new NotifierObject(map.getPacMan(), map, 1));
			}else if (!(myPacGirl.isAlive())){
				JOptionPane.showMessageDialog(null, "You lost!", "FAILED", JOptionPane.INFORMATION_MESSAGE);
				this.setChanged();
				notifyObservers(new NotifierObject(map.getPacMan(), map, 1));
			}
			switch(keycode){
			case KeyEvent.VK_UP:
				if ((map.getIdentity((int)map.getPacMan().getX(), (int)map.getPacMan().getY() - 1) != Coordinate.WALL)&&(map.getIdentity((int)map.getPacMan().getX(), (int)map.getPacMan().getY() - 1) != Coordinate.PRISON)){
					map.getPacMan().translate(0, -1);
				}
				this.setChanged();
				notifyObservers(new NotifierObject(map.getPacMan(), map, 0));
				break;
			case KeyEvent.VK_DOWN:
				if ((map.getIdentity((int)map.getPacMan().getX(), (int)map.getPacMan().getY() + 1) != Coordinate.WALL) && (map.getIdentity((int)map.getPacMan().getX(), (int)map.getPacMan().getY() + 1) != Coordinate.PRISON)){
					map.getPacMan().translate(0, 1);
				}
				
				this.setChanged();
				notifyObservers(new NotifierObject(map.getPacMan(), map, 0));
				break;
			case KeyEvent.VK_LEFT:
				if ((map.getIdentity((int)map.getPacMan().getX() - 1, (int)map.getPacMan().getY()) != Coordinate.WALL) && (map.getIdentity((int)map.getPacMan().getX() - 1, (int)map.getPacMan().getY()) != Coordinate.PRISON)){
					map.getPacMan().translate(-1, 0);
				}
				
				this.setChanged();
				notifyObservers(new NotifierObject(map.getPacMan(), map, 0));
				break;
			case KeyEvent.VK_RIGHT:
				if ((map.getIdentity((int)map.getPacMan().getX() + 1, (int)map.getPacMan().getY()) != Coordinate.WALL) && (map.getIdentity((int)map.getPacMan().getX() + 1, (int)map.getPacMan().getY()) != Coordinate.PRISON) ){
					map.getPacMan().translate(1, 0);
				}
				
				this.setChanged();
				notifyObservers(new NotifierObject(map.getPacMan(), map, 0));
				break;
			case KeyEvent.VK_Q:
				this.setChanged();
				notifyObservers(new NotifierObject(map.getPacMan(), map, 1));
				break;
		}
	}
}