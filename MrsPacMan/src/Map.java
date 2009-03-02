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
		this.size = s;
		
		//intialization of all coordinates to empty space
		for(int i = 0; i < s; i++){
			   for(int j = 0; j < s; j++){
			      level[i][j] = new Coordinate(i,j,0);}}

		//Loop to create a border
		for (int i = 0; i<s; i++){
			level[s][i].setIdentity(Coordinate.WALL); //Right wall created
			level[0][i].setIdentity(Coordinate.WALL); //Left wall created
			level[i][0].setIdentity(Coordinate.WALL);// Bottom wall created
			level[i][s].setIdentity(Coordinate.WALL); //Top wall created
		}
		
		//Fill all non walls with a pacdot
		for(int i = 0; i < s; i++){
			   for(int j = 0; j < s; j++){
			      if (level[i][j].getIdentity() != Coordinate.WALL) {
			    	  level[i][j].setIdentity(2);
			    	  NUMBEROFPACDOTS++;}
			      }
			   }
		
	}
	public int getSize(){return size;}

}