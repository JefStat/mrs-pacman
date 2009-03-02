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
		level[1][1].setIdentity(Coordinate.EMPTY);
		setPacManStart(level[1][1]);
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
	 * Prints the map in console - NEEDS TO BE IMPLEMENTED
	 */
	public void printMap(){
	}

}