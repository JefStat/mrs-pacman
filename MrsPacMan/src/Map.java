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
 * was commented out.  When attempting to create ambusher is was realized that this ghost starts outisde
 * the prison unlike the rest of the ghosts.
 * 
 * Jef's notes: removed the static from setSize add getter and setter for identity, in various ways.
 * 
 */
import java.util.Scanner;
import java.io.*;
import java.lang.Integer;

public class Map {
	/**
	 * sets a constant default maximum for map
	 */
	public final static int MAX = 30;
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
	 * contains the coordinate where pacman starts
	 */
	private Coordinate pacMan;
	/**
	 * contains the location where ambusher starts
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
	 * @param s
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
		level[15][15].setIdentity(Coordinate.PRISON);
		setPrison(level[15][15]);
		NUMBEROFPACDOTS--;
		//create a starting point for ambusher
		level[15][16].setIdentity(Coordinate.EMPTY);
		NUMBEROFPACDOTS--;
		this.setAmbusher(level[15][16]);
		//create pacmans starting point
		level[10][10].setIdentity(Coordinate.EMPTY);
		setPacMan(level[10][10]);
		NUMBEROFPACDOTS--;
	}
	
	/**
	 * Returns the width/length of the map
	 */
	public int getSize(){return size;}
	
	/**
	 * Returns the number of pacdots within the map
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
	 * This method sets the prisoner for Ambusher as this ghost starts outside the prison at the front of the prison
	 * @param ambusher
	 */
	public void setAmbusher(Coordinate ambusher){
		this.ambusher = ambusher;
	}
	/**
	 * This method returns the prisoner for Ambusher as this ghost starts outside the prison 
	 * at the front of the prison
	 */
	public Coordinate getAmbusher(){
		return ambusher;
		
	}

	/**
	 * @param pacManStart the pacManStart to set
	 */
	public void setPacMan(Coordinate pacMan) {
		this.pacMan = pacMan;
	}

	/**
	 * @return the pacMan
	 */
	public Coordinate getPacMan() {
		return pacMan;
	}
	
	public Coordinate getStupid() {
		return stupid;
	}
	public void setStupid(Coordinate stupid) {
		this.stupid = stupid;
	}
	public Coordinate getFickle() {
		return fickle;
	}
	public void setFickle(Coordinate fickle) {
		this.fickle = fickle;
	}
	public Coordinate getChaser() {
		return chaser;
	}
	public void setChaser(Coordinate chaser) {
		this.chaser = chaser;
	}
	/**
	 * returns map temporary for a* algorithm 
	 *possibly deprecated?
	 */
	public Coordinate[][] getMap(){
		return level;
	}
	
	/**
	 * Prints the map in a specified GUI
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
	 //what does this do for map? why can the public resize it? -jef
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * Get an identity from map location int x and y returns -1 if out of bounds
	 * @param x
	 * @param y
	 * @return -1 if x or y are out of bounds otherwise identity at location x y
	 */
	public int getIdentity(int x, int y){
		if ((x>=this.getSize())||(y>=this.getSize())||((x<0)||(y<0))) return -1;
		
		return level[x][y].getIdentity();	
	}
	/**
	 * Allows you to check the identity of your coordinate object if it is the same as the
	 * point on the map. 
	 * @param p
	 * @return -1 if p is out of bounds otherwise identity at location p
	 */
	public int getIdentity(Coordinate p){
		if ((p.getX()>=this.getSize())||(p.getY()>=this.getSize())||((p.getX()<0)||(p.getY()<0))) return -1;
		
		return level[(int)p.getX()][(int)p.getY()].getIdentity();
	}
	
	/**
	 * Will set identity to empty if is a pacdot
	 * 
	 * @param p
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
	// to lazy to implement will do if needed
	public boolean setIdentity(int x, int y){
		return false;
	}
}