/*
 * This class controls the size of the map and also feed into coordinate to 
 * know what is occurring in the map at any given time.
 * 
 * Title: Map Class version 1.1
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 * Milestone 2: WRITTEN/MODIFIED by: Nahim Nasser
 * Updated: Function bodies added
 * 
 * Milestone 3
 * Date: March 7th, 2009
 * Author: Jen Kasun and Nicole Waldrum
 * 
 * Created default size MAX so that these values could be used in the character classes to send ghosts
 * to their respective corners.  Also, modified the Map() constructor so that it worked properly as it
 * was commented out.  When attempting to create ambusher is was realized that this ghost starts outisde
 * the prison unlike the rest of the ghosts.
 * 
 */
import java.util.Scanner;
import java.io.*;
import java.lang.Integer;

public class Map {
	
	static int MAX = 30;
	private static int size;
	Coordinate[][] level;
	private int NUMBEROFPACDOTS = 0;
	// need to be initialised and getters made.
	private Coordinate prison;
	private Coordinate pacManStart;
	private Coordinate ambusherStart;
	
	/*
	 * constructor to make a map s x s size
	 */
	@SuppressWarnings("deprecation")
	
	//---------------TEST-----------------------
	public static void main(String[] args) {
		Map x = new Map(30);
		MapGUI f = new MapGUI("Map GUI");
		f.setSize(800,600);
		f.changeText("TEST" +"\n" +"next");
		f.show();
		x.printMap(f);
	}
	//---------------TEST-----------------------
	
	/*
	 * Default constructor making the map the Defaultsize x Defaultsize
	 * Will create a default map, with a border of walls
	 */
	public Map(){
		this(MAX);
	}
	
	public Map(int s){
		level = new Coordinate[s][s];
		Map.setSize(s);
		
		//Initialisation of all coordinates to empty space
		for(int i = 0; i < s; i++){
			   for(int j = 0; j < s; j++){
			      level[i][j] = new Coordinate(i,j,0);}}

		//Loop to create a border
		for (int i = 0; i<s; i++){
			level[s-1][i].setIdentity(Coordinate.WALL); //Right wall created
			level[0][i].setIdentity(Coordinate.WALL); //Left wall created
			level[i][0].setIdentity(Coordinate.WALL);// Bottom wall created
			level[i][s-1].setIdentity(Coordinate.WALL); //Top wall created
		}
		
		//Fill all non walls with a pacdot, and counts all pacdots inserted
		for(int i = 0; i < s; i++){
			   for(int j = 0; j < s; j++){
			      if (level[i][j].getIdentity() != Coordinate.WALL) {
			    	  level[i][j].setIdentity(Coordinate.PACDOT);
			    	  NUMBEROFPACDOTS++;}
			      }
			   }
		//temporary default starting point and prison
		level[15][15].setIdentity(Coordinate.PRISON);
		setPrison(level[15][15]);
		NUMBEROFPACDOTS--;
		level[1][1].setIdentity(Coordinate.EMPTY);
		setPacManStart(level[1][1]);
		NUMBEROFPACDOTS--;
	}
	
	/*
	 * Returns the width/length of the map
	 */
	public static int getSize(){return size;}
	
	/*
	 * Returns the number of pacdots within the map
	 */
	public int getPacdots(){return NUMBEROFPACDOTS;}
	
	/**
	 * @param prison the prison to set
	 */
	private void setPrison(Coordinate prison) {
		this.prison = prison;
	}

	/**
	 * @return the prison
	 */
	public Coordinate getPrison() {
		return prison;
	}
	//This method sets the prisoner for Ambusher as this ghost starts outside the prison 
	//at the front of the prison
	private void setAmbusherStart(Coordinate ambusherStart){
		this.ambusherStart = ambusherStart;
	}
	//This method returns the prisoner for Ambusher as this ghost starts outside the prison 
	//at the front of the prison
	public Coordinate getAmbusherStart(){
		return ambusherStart;
		
	}

	/**
	 * @param pacManStart the pacManStart to set
	 */
	private void setPacManStart(Coordinate pacManStart) {
		this.pacManStart = pacManStart;
	}

	/**
	 * @return the pacManStart
	 */
	public Coordinate getPacManStart() {
		return pacManStart;
	}
	
	/*
	 * returns map temporary for a* algorithm
	 */
	public Coordinate[][] getMap(){
		return level;
	}
	
	/*
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
		f.changeText(strLevel);
	}
	
	/*
	 * Incomplete implementation of import map
	 */
	 public void ImportMap(String filename) throws Exception{
         File file = new java.io.File(filename);
         int track = 0;
      //Scanner input = new Scanner(file);
      //create  a scanner for input
         Scanner input = new java.util.Scanner(file);
         Integer integer = Integer.parseInt(input.next());
        Map.setSize(integer.intValue());
      //a while loop that makes the table
        this.NUMBEROFPACDOTS = 0;      
         while(input.hasNext()){
				for(int i = 0; i < getSize(); i++){
					   for(int j = 0; j < getSize(); j++){
						   integer = Integer.parseInt(input.next());
						   if (integer.intValue() == Coordinate.PACDOT){NUMBEROFPACDOTS++;}
						   if (integer.intValue() == Coordinate.PRISON){this.prison = level[j][i];}
						   if (integer.intValue() == Coordinate.EMPTY){this.pacManStart = level[j][i];}
						   level[j][i].setIdentity(integer.intValue());
						   track++;
					     }
					   }
         }
         input.close();
      }
	 
		/*
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

	public static void setSize(int size) {
		Map.size = size;
	}
}