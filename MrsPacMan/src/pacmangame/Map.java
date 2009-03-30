package pacmangame;

/**
 * This class controls the size of the map and also feed into coordinate to 
 * know what is occurring in the map at any given time.
 * 
 * Title: Map Class version 1.1
 * @Date: February 16, 2009
 * @Author: Nicole Waldrum and Jef Statham
 * @Milestone 2: WRITTEN/MODIFIED by: Nahim Nasser
 * @Updated: Function bodies added
 * 
 * Milestone 3
 * @Date: March 7th, 2009
 * @Author: Jen Kasun and Nicole Waldrum
 * 
 * Created default size MAX so that these values could be used in the character classes to send ghosts
 * to their respective corners.  Also, modified the Map() constructor so that it worked properly as it
 * was commented out.  When attempting to create chaser is was realized that this ghost starts outisde
 * the prison unlike the rest of the ghosts.
 * 
 * Jef's notes: removed the static from setSize add getter and setter for identity, in various ways.
 * added Coordinates for every ghost, pac man. Possible bugs when importing maps is initialising ghosts
 * pac man and checking there is a prison all the variables. 
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

@SuppressWarnings("unused")
public class Map {
	/**
	 * sets a constant default maximum for map
	 */
	public final static int MAX = 20;
	/**
	 * keeps track of the size of map
	 */
	private int size;
	/**
	 * keeps track of the current level of the map
	 */
	private Coordinate[][] level;
	/**
	 * keeps track of the remaining pacdots
	 */
	private int NUMBEROFPACDOTS = 0;
	/**
	 * contains the prison coordinate
	 */
	private Coordinate prison;
	/**
	 * contains the coordinate where pacman is
	 */
	private Coordinate pacMan;
	/**
	 * contains the coordinate where powerpellet is
	 */
	private Coordinate powerpellet;
	/**
	 */
	private Coordinate ambusher;

	public Coordinate getPowerpellet() {
		return powerpellet;
	}

	private Coordinate stupid;
	private Coordinate fickle;
	private Coordinate chaser;
	private String OperationStatus;
	
	public String getOperationStatus() {
		return OperationStatus;
	}

	/**
	 * Default constructor making the map the Defaultsize x Defaultsize Will
	 * create a default map, with a border of walls
	 */
	public Map() {
		this(MAX);
	}

	/**
	 * creates a map of the size that the player wants
	 * 
	 * @param s
	 *            is the size of the map
	 */
	public Map(int s) {
		level = new Coordinate[s][s];
		this.setSize(s);
		int i, j;
		/**
		 * Initialization of all coordinates to empty space
		 */
		for (i = 0; i < s; i++) {
			for (j = 0; j < s; j++) {
				level[i][j] = new Coordinate(i, j, 0);
			}
		}

		/**
		 * Loop to create a border
		 */
		for (i = 0; i < s; i++) {
			level[s - 1][i].setIdentity(Coordinate.WALL); // Right wall created
			level[0][i].setIdentity(Coordinate.WALL); // Left wall created
			level[i][0].setIdentity(Coordinate.WALL);// Bottom wall created
			level[i][s - 1].setIdentity(Coordinate.WALL); // Top wall created
		}

		/**
		 * Fill all non walls with a pacdot, and counts all pacdots inserted
		 */
		for (i = 0; i < s; i++) {
			for (j = 0; j < s; j++) {
				if (level[i][j].getIdentity() != Coordinate.WALL) {
					level[i][j].setIdentity(Coordinate.PACDOT);
					NUMBEROFPACDOTS++;
				}
			}
		}
		/**
		 * temporary default starting point and prison
		 */
		level[5][5].setIdentity(Coordinate.PRISON);
		setPrison(level[5][5]);
		NUMBEROFPACDOTS--;
		// create a starting point for chaser
		level[5][4].setIdentity(Coordinate.EMPTY);
		NUMBEROFPACDOTS--;
		this.setChaser(level[5][4]);
		// create pacmans starting point
		level[1][1].setIdentity(Coordinate.EMPTY);
		setPacMan(level[1][1]);
		NUMBEROFPACDOTS--;
		// DEFAULT PLACE FOR POWERPELLET
		level[2][2].setIdentity(Coordinate.POWERPELLET);
		NUMBEROFPACDOTS--;
		// create a starting point for ambusher, fickle stupid
		this.fickle = new Coordinate(5, 5, 0);
		this.ambusher = new Coordinate(5, 5, 0);
		this.stupid = new Coordinate(5, 5, 0);

	}

	/**
	 * Returns the width/length of the map
	 * 
	 * @return map size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Returns the number of pacdots within the map
	 * 
	 * @return pellets left before level completes
	 */
	public int getPacdots() {
		return NUMBEROFPACDOTS;
	}

	/**
	 * sets the prison location for ghost
	 * 
	 * @param prison
	 *            the prison to set
	 */
	private void setPrison(Coordinate prison) {
		this.prison = prison;
	}

	/**
	 * returns the prison location for ghost
	 * 
	 * @return the prison
	 */
	public Coordinate getPrison() {
		return prison;
	}

	/**
	 * This method sets the prisoner for Chaser as this ghost starts outside the
	 * prison at the front of the prison
	 * 
	 * @param chaser
	 *            location in front of prison
	 */
	public void setChaser(Coordinate chaser) {
		this.chaser = chaser;
	}

	/**
	 * This method returns the prisoner for Chaser as this ghost starts outside
	 * the prison at the front of the prison
	 * 
	 * @return start location
	 */
	public Coordinate getChaser() {
		return chaser;

	}

	/**
	 * method sets where pacman starts on the map at the beginning of the game
	 * and after PacMan dies and a new round begins
	 * 
	 * @param pacManStart
	 *            the pacManStart to set
	 */
	public void setPacMan(Coordinate pacMan) {
		this.pacMan = pacMan;
	}

	/**
	 * returns the location of pacmans start at the beginning of the game and
	 * starting new rounds after PacMan dies
	 * 
	 * @return PacMan location for starting game/level
	 */
	public Coordinate getPacMan() {
		return pacMan;
	}

	/**
	 * returns the start location for stupid
	 * 
	 * @return stupid location
	 */
	public Coordinate getStupid() {
		return stupid;
	}

	/**
	 * sets stupid's location for the start of the game
	 * 
	 * @param stupid
	 *            start location
	 */
	public void setStupid(Coordinate stupid) {
		this.stupid = stupid;
	}

	/**
	 * returns the start location for fickle
	 * 
	 * @return fickle location
	 */
	public Coordinate getFickle() {
		return fickle;
	}

	/**
	 * sets fickle's location for the start of the game
	 * 
	 * @param fickle
	 *            start location
	 */
	public void setFickle(Coordinate fickle) {
		this.fickle = fickle;
	}

	/**
	 * returns the start location for ambusher
	 * 
	 * @return ambusher location
	 */
	public Coordinate getAmbusher() {
		return ambusher;
	}

	/**
	 * sets ambusher's location for the start of the game
	 * 
	 * @param ambusher
	 *            start location
	 */
	public void setAmbusher(Coordinate ambusher) {
		this.ambusher = ambusher;
	}

	/**
	 * Prints the map in a specified GUI
	 * 
	 * @param f
	 *            is the frame for the map gui
	 */
	public void printMap(MapGUI f) {
		String strLevel = "\n";
		int track = 0;
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				strLevel += level[j][i].getIdentity() + " ";
				track++;
				// after row has been printed, track will skip a line and then
				// reset
				if (track == getSize()) {
					strLevel += "\n";
					track = 0;
				}
			}
		}
	}

	/**
	 * This will import a map Incomplete implementation of import map
	 */
	public void ImportMap(String filename) throws Exception {
		File file = new java.io.File(filename);
		int track = 0;
		// Scanner input = new Scanner(file);
		// create a scanner for input
		Scanner input = new java.util.Scanner(file);
		Integer integer = Integer.parseInt(input.next());
		this.setSize(integer.intValue());
		// a while loop that makes the table
		this.NUMBEROFPACDOTS = 0;
		while (input.hasNext()) {
			for (int i = 0; i < getSize(); i++) {
				for (int j = 0; j < getSize(); j++) {
					integer = Integer.parseInt(input.next());
					if (integer.intValue() == Coordinate.PACDOT) {
						NUMBEROFPACDOTS++;
					}
					if (integer.intValue() == Coordinate.PRISON) {
						this.prison = level[j][i];
					}
					if (integer.intValue() == Coordinate.EMPTY) {
						this.pacMan = level[j][i];
					}
					level[j][i].setIdentity(integer.intValue());
					track++;
				}
			}
		}
		input.close();
	}

	/**
	 * Exports the map to filename.txt in the root directory.
	 * 
	 * @param filename
	 *            is where the file exports to
	 * @throws exception
	 */
	public void ExportMap(String filename) throws Exception {
		java.io.File output = new java.io.File(filename);
		java.io.PrintWriter outfile = new java.io.PrintWriter(output);
		int track = 0;
		outfile.println(getSize());
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				outfile.print(level[j][i].getIdentity() + " ");
				track++;
				// after row has been printed, track will skip a line and then
				// reset
				if (track == getSize()) {
					outfile.println("");
					track = 0;
				}
			}
		}
		outfile.close();

	}

	/**
	 * XML file export creates a file with the toXML string
	 */
	public void exportXML(String filename) {
		if (validateMap(this)) {
			FileOutputStream output;
			PrintStream p;
			try {
				output = new FileOutputStream(filename + ".xml");
				p = new PrintStream(output);
				p.print(this.toXML());
				output.close();
				p.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			OperationStatus = "SUCCESSFUL EXPORT TO " + filename +".xml";
		} else {
			OperationStatus = "MAP VALIDATION FAILED, UNABLE TO EXPORT";
		}
	}

	/**
	 * sets the map size
	 * 
	 * @param size
	 *            is the size of the map to be set
	 */
	private void setSize(int size) {
		this.size = size;
	}

	public void refreshPacdots() {
		NUMBEROFPACDOTS = 0;
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				if (level[j][i].getIdentity() == Coordinate.PACDOT) {
					NUMBEROFPACDOTS++;
				}
			}
		}
	}

	/**
	 * Get an identity from map location int x and y returns -1 if out of bounds
	 * 
	 * @param x
	 *            is the x point of the coordinate
	 * @param y
	 *            is the y point of the coordinate
	 * @return -1 if x or y are out of bounds otherwise identity at location x y
	 */
	public int getIdentity(int x, int y) {
		if ((x >= this.getSize()) || (y >= this.getSize())
				|| ((x < 0) || (y < 0)))
			return -1;

		return level[x][y].getIdentity();
	}

	/**
	 * Allows you to check the identity of your coordinate object if it is the
	 * same as the point on the map.
	 * 
	 * @param p
	 *            is the currenly coordinate
	 * @return -1 if p is out of bounds otherwise identity at location p
	 */
	public int getIdentity(Coordinate p) {
		if ((p.getX() >= this.getSize()) || (p.getY() >= this.getSize())
				|| ((p.getX() < 0) || (p.getY() < 0)))
			return -1;

		return level[(int) p.getX()][(int) p.getY()].getIdentity();
	}

	/**
	 * Will set identity to empty if is a pacdot
	 * 
	 * @param p
	 *            is the coordinate location
	 * @return true if position is changed
	 */
	public boolean setIdentity(Coordinate p) {
		if ((getIdentity(p) > -1) && (getIdentity(p) == Coordinate.PACDOT)) {
			level[(int) p.getX()][(int) p.getY()].setIdentity(Coordinate.EMPTY);
			NUMBEROFPACDOTS--;
			return true;
		}
		return false;
	}

	public void changeIdentity(int x, int y, int identity) {
		level[x][y].setIdentity(identity);
	}

	/**
	 * Convert the map object to an xml document
	 * 
	 * @return the XML string ready to be output to a file
	 */
	public String toXML() {
		String map = "<Map size=" + this.getSize() + ">\n" + "\t<Identities>";
		for (int i = 0; i < this.getSize(); i++) {
			map += "\t\t";
			for (int j = 0; j < this.getSize(); j++) {
				map += this.getIdentity(i, j);
			}
			map += "\n";
		}
		map += "\t</Identities>";

		// converts the toXML of each character into a string split at the new
		// line to insert the extra tab
		// for more complete formatting in the XML save file.
		String[] pacman = new PacMan(this).toXML().split("\\n");
		for (int i = 0; i < pacman.length; i++) {
			map += "\t" + pacman[i] + "\n";
		}
		String[] ambusher = new Ambusher(this).toXML().split("\\n");
		for (int i = 0; i < ambusher.length; i++) {
			map += "\t" + ambusher[i] + "\n";
		}
		String[] chaser = new Chaser(this).toXML().split("\\n");
		for (int i = 0; i < chaser.length; i++) {
			map += "\t" + chaser[i] + "\n";
		}
		String[] fickle = new Fickle(this).toXML().split("\\n");
		for (int i = 0; i < fickle.length; i++) {
			map += "\t" + fickle[i] + "\n";
		}
		String[] stupid = new Stupid(this).toXML().split("\\n");
		for (int i = 0; i < stupid.length; i++) {
			map += "\t" + stupid[i] + "\n";
		}
		map += "</Map>\n";
		return map;
	}

	/**
	 * Set the map level to a Coordinate matrix will run a level validate on the
	 * matrix first in next revision.
	 * 
	 * @param level2
	 *            a square matrix that is a valid level
	 */
	public void setLevel(Coordinate[][] level2) {
		// TODO Auto-generated method stub
		level = level2;
	}

	/**
	 * Validates that a given matrix of Coordinate is a valid level following
	 * the following rules.
	 * 
	 * 1. the map is surrounded by 4 walls. 2. no pacdot is unreachable. ie
	 * inclosed in walls. 3. it has a prison.
	 * 
	 * The method may fix the matrix to include any of the missing points or it
	 * may return false if one of the rules fails.
	 * 
	 * @return true if level meets the rules false otherwise.
	 */
	private boolean validateLevel(Coordinate[][] level2, int size) {
		boolean hasPrison = false;
		boolean isBounded = false;
		boolean hasStart = false;

		// TEST FOR BOUNDING WALLS
		for (int i = 0; i < size; i++) {
			if (level2[size - 1][i].getIdentity() != Coordinate.WALL)
				return false; // Right wall test
			if (level2[0][i].getIdentity() != Coordinate.WALL)
				return false; // Left wall test
			if (level2[i][0].getIdentity() != Coordinate.WALL)
				return false; // Bottom wall test
			if (level2[i][size - 1].getIdentity() != Coordinate.WALL)
				return false; // Top wall test
		}
		isBounded = true;

		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				if (level2[j][i].getIdentity() == Coordinate.PRISON) {
					hasPrison = true;
				}
				if (level2[j][i].getIdentity() == Coordinate.EMPTY) {
					hasStart = true;
				}
				if (level2[j][i].getIdentity() == Coordinate.PACDOT) {
					if (level2[j + 1][i].getIdentity() == Coordinate.WALL
							&& level2[j - 1][i].getIdentity() == Coordinate.WALL
							&& level2[j][i + 1].getIdentity() == Coordinate.WALL
							&& level2[j][i - 1].getIdentity() == Coordinate.WALL)
						return false;
				}
			}
		}

		if (hasPrison == true && isBounded == true && hasStart == true)
			return true;
		else
			return false;
	}

	/**
	 * Validates that a given matrix of Coordinate is a valid level following
	 * the following rules.
	 * 
	 * 1. the map is surrounded by 4 walls. 2. no pacdot is unreachable. ie
	 * inclosed in walls. 3. it has a prison. 4. the level is square. 5. all
	 * ghosts and pacman have a starting position.
	 * 
	 * The method may fix the matrix to include any of the missing points or it
	 * may return false if one of the rules fails.
	 * 
	 * @return true if level meets the rules false otherwise.
	 */
	public boolean validateMap(Map m) {
		if (m.validateLevel(m.level, m.size) == true)
			return true;
		else
			return false;
	}
}