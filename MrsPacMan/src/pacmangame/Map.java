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
import java.util.Scanner;
import java.io.*;
import java.lang.Integer;

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
	 * contains the location where each ghost is
	 */
	private Coordinate ambusher;
	private Coordinate stupid;
	private Coordinate fickle;
	private Coordinate chaser;
	
	/**
	 * Default constructor making the map the Defaultsize x Defaultsize
	 * Will create a default map, with a border of walls
	 */
	public Map(){
		this(MAX);
	}
	/**
	 * creates a map of the size that the player wants
	 * @param s is the size of the map
	 */
	public Map(int s){
		level = new Coordinate[s][s];
		this.setSize(s);
		int i,j;
		/**
		 * Initialisation of all coordinates to empty space
		 */
		for(i = 0; i < s; i++){
			   for( j = 0; j < s; j++){
			      level[i][j] = new Coordinate(i,j,0);}}

		/**
		 * Loop to create a border
		 */
		for ( i = 0; i<s; i++){
			level[s-1][i].setIdentity(Coordinate.WALL); //Right wall created
			level[0][i].setIdentity(Coordinate.WALL); //Left wall created
			level[i][0].setIdentity(Coordinate.WALL);// Bottom wall created
			level[i][s-1].setIdentity(Coordinate.WALL); //Top wall created
		}
		
		/**
		 * Fill all non walls with a pacdot, and counts all pacdots inserted
		 */
		for( i = 0; i < s; i++){
			   for( j = 0; j < s; j++){
			      if (level[i][j].getIdentity() != Coordinate.WALL) {
			    	  level[i][j].setIdentity(Coordinate.PACDOT);
			    	  NUMBEROFPACDOTS++;}
			      }
			   }
		/**
		 * temporary default starting point and prison
		 */
		level[5][5].setIdentity(Coordinate.PRISON);
		setPrison(level[5][5]);
		NUMBEROFPACDOTS--;
		//create a starting point for chaser
		level[5][4].setIdentity(Coordinate.EMPTY);
		NUMBEROFPACDOTS--;
		this.setChaser(level[5][4]);
		//create pacmans starting point
		level[1][1].setIdentity(Coordinate.EMPTY);
		setPacMan(level[1][1]);
		NUMBEROFPACDOTS--;
		//create a starting point for ambusher, fickle stupid
		this.fickle = new Coordinate(5,5,0);
		this.ambusher = new Coordinate(5,5,0);
		this.stupid = new Coordinate(5,5,0);
		
	}
	
	/**
	 * Returns the width/length of the map
	 * @return map size
	 */
	public int getSize(){return size;}
	
	/**
	 * Returns the number of pacdots within the map
	 * @return pellets left before level completes
	 */
	public int getPacdots(){return NUMBEROFPACDOTS;}
	
	/**
	 * sets the prison location for ghost
	 * @param prison the prison to set
	 */
	private void setPrison(Coordinate prison) {
		this.prison = prison;
	}

	/**
	 * returns the prison location for ghost
	 * @return the prison
	 */
	public Coordinate getPrison() {
		return prison;
	}
	/**
	 * This method sets the prisoner for Chaser as this ghost starts outside the prison at the front of the prison
	 * @param chaser location in front of prison
	 */
	public void setChaser(Coordinate chaser){
		this.chaser = chaser;
	}
	/**
	 * This method returns the prisoner for Chaser as this ghost starts outside the prison 
	 * at the front of the prison
	 * @return start location
	 */
	public Coordinate getChaser(){
		return chaser;
		
	}

	/**
	 * method sets where pacman starts on the map at the beginning of the game and
	 * after PacMan dies and a new round begins
	 * @param pacManStart the pacManStart to set
	 */
	public void setPacMan(Coordinate pacMan) {
		this.pacMan = pacMan;
	}

	/**
	 * returns the location of pacmans start at the beginning of the game and 
	 * starting new rounds after PacMan dies
	 * @return PacMan location for starting game/level
	 */
	public Coordinate getPacMan() {
		return pacMan;
	}
	/**
	 * returns the start location for stupid
	 * @return stupid location
	 */
	public Coordinate getStupid() {
		return stupid;
	}
	/**
	 * sets stupid's location for the start of the game
	 * @param stupid start location
	 */
	public void setStupid(Coordinate stupid) {
		this.stupid = stupid;
	}
	/**
	 * returns the start location for fickle
	 * @return fickle location
	 */
	public Coordinate getFickle() {
		return fickle;
	}
	/**
	 * sets fickle's location for the start of the game
	 * @param fickle start location
	 */
	public void setFickle(Coordinate fickle) {
		this.fickle = fickle;
	}
	/**
	 * returns the start location for ambusher
	 * @return ambusher location
	 */
	public Coordinate getAmbusher() {
		return ambusher;
	}
	/**
	 * sets ambusher's location for the start of the game
	 * @param ambusher start location
	 */
	public void setAmbusher(Coordinate ambusher) {
		this.ambusher = ambusher;
	}

	/**
	 * Prints the map in a specified GUI
	 * @param f is the frame for the map gui
	 */
	public void printMap(MapGUI f){
		String strLevel = "\n";
		int track = 0;
		for(int i = 0; i < getSize(); i++){
			   for(int j = 0; j < getSize(); j++){
				   strLevel += level[j][i].getIdentity() + " ";
				   track++;
				   //after row has been printed, track will skip a line and then reset
				   if (track == getSize()) {
					   strLevel += "\n";
					   track = 0;
				   }
			     }
			   }
	}
	
	/**
	 * This will import a map
	 * Incomplete implementation of import map
	 */
	 public void ImportMap(String filename) throws Exception{
         File file = new java.io.File(filename);
         int track = 0;
      //Scanner input = new Scanner(file);
      //create  a scanner for input
         Scanner input = new java.util.Scanner(file);
         Integer integer = Integer.parseInt(input.next());
        this.setSize(integer.intValue());
      //a while loop that makes the table
        this.NUMBEROFPACDOTS = 0;      
         while(input.hasNext()){
				for(int i = 0; i < getSize(); i++){
					   for(int j = 0; j < getSize(); j++){
						   integer = Integer.parseInt(input.next());
						   if (integer.intValue() == Coordinate.PACDOT){NUMBEROFPACDOTS++;}
						   if (integer.intValue() == Coordinate.PRISON){this.prison = level[j][i];}
						   if (integer.intValue() == Coordinate.EMPTY){this.pacMan = level[j][i];}
						   level[j][i].setIdentity(integer.intValue());
						   track++;
					     }
					   }
         }
         input.close();
      }
	 
		/**
		 * Exports the map to filename.txt in the root directory.
		 * @param filename is where the file exports to
		 * @throws exception
		 */ 
	 public void ExportMap(String filename) throws Exception{
	      java.io.File output = new java.io.File(filename);
				java.io.PrintWriter outfile = new java.io.PrintWriter(output);
				int track = 0;
				outfile.println(getSize());
				for(int i = 0; i < getSize(); i++){
					   for(int j = 0; j < getSize(); j++){
						   outfile.print(level[j][i].getIdentity() + " ");
						   track++;
						   //after row has been printed, track will skip a line and then reset
						   if (track == getSize()) {
							   outfile.println("");
							   track = 0;
						   }
					     }
					   }
				outfile.close();

	 }

	 /**
	  * sets the map size
	  * @param size is the size of the map to be set
	  */
	private void setSize(int size) {
		this.size = size;
	}
	/**
	 * Get an identity from map location int x and y returns -1 if out of bounds
	 * @param x is the x point of the coordinate
	 * @param y is the y point of the coordinate
	 * @return -1 if x or y are out of bounds otherwise identity at location x y
	 */
	public int getIdentity(int x, int y){
		if ((x>=this.getSize())||(y>=this.getSize())||((x<0)||(y<0))) return -1;
		
		return level[x][y].getIdentity();	
	}
	/**
	 * Allows you to check the identity of your coordinate object if it is the same as the
	 * point on the map. 
	 * @param p is the currenly coordinate
	 * @return -1 if p is out of bounds otherwise identity at location p
	 */
	public int getIdentity(Coordinate p){
		if ((p.getX()>=this.getSize())||(p.getY()>=this.getSize())||((p.getX()<0)||(p.getY()<0))) return -1;
		
		return level[(int)p.getX()][(int)p.getY()].getIdentity();
	}
	
	/**
	 * Will set identity to empty if is a pacdot
	 * 
	 * @param p is the coordinate location
	 * @return true if position is changed
	 */
	public boolean setIdentity(Coordinate p){
		if ((getIdentity(p) > -1)&&(getIdentity(p)== Coordinate.PACDOT )){
			level[(int)p.getX()][(int)p.getY()].setIdentity(Coordinate.EMPTY);
			NUMBEROFPACDOTS--;
			return true;
		}
		return false;	
	}
	public String toXML(){
		String map = "<Map size="+this.getSize()+">\n";
		for (int i=0; i<this.getSize(); i++){
			map+="\t";
			for (int j=0; j<this.getSize(); j++){
				map += this.getIdentity(i, j);
			}
			map+="\n";
		}
		map+="</Map>\n";
		return map;
	}
}