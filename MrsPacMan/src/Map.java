/*
 * This class controls the size of the map and also feed into coordinate to 
 * know what is occurring in the map at any given time.
 * 
 * Title: Map Class version 1.1
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 * Milestone 2: WRITTEN/MODIFIED by: Nahim Nasser
 * Updated: Function bodies added
 */
import java.util.Scanner;
import java.io.*;
import java.lang.Integer;

public class Map {
	
	//private final int DEFAULTSIZE = 30;
	private int size;
	Coordinate[][] level;
	private int NUMBEROFPACDOTS = 0;
	// need to be initialized and getters made.
	private Coordinate prison;
	private Coordinate pacManStart;
	
	/*
	 * Default constructor making the map the Defaultsize x Defaultsize
	 * Will create a default map, with a border of walls
	 */
	//public Map(){
	//	Map(DEFAULTSIZE);
	//}

	/*
	 * constructor to make a map s x s size
	 */
	public Map(int s){
		level = new Coordinate[s][s];
		this.size = s;
		
		//Initialization of all coordinates to empty space
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
	public int getSize(){return size;}
	
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
	 * Prints the map in console - Row by Row
	 */
	public void printMap(){
		int track = 0;
		for(int i = 0; i < size; i++){
			   for(int j = 0; j < size; j++){
				   System.out.print(level[j][i].getIdentity() + " ");
				   track++;
				   //after row has been printed, track will skip a line and then reset
				   if (track == size) {
					   System.out.println("");
					   track = 0;
				   }
			     }
			   }
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
        this.size = integer.intValue();
      //a while loop that makes the table
        this.NUMBEROFPACDOTS = 0;      
         while(input.hasNext()){
				for(int i = 0; i < size; i++){
					   for(int j = 0; j < size; j++){
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
						outfile.println(size);
						for(int i = 0; i < size; i++){
							   for(int j = 0; j < size; j++){
								   outfile.print(level[j][i].getIdentity() + " ");
								   track++;
								   //after row has been printed, track will skip a line and then reset
								   if (track == size) {
									   outfile.println("");
									   track = 0;
								   }
							     }
							   }
						outfile.close();

	 }


}