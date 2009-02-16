import java.awt.Point;
/*
 * This class establishes what positions are current for each player.  In addition
 * to this there are only 5 set cases for what items can be on the map.  The space on
 * the map is either empty, a wall, a PacMan pellet, a power pellet, or fruit.  When
 * all of these items are gone then the level is considered completed.
 * 
 * Title: Coorindate Class version 1.1
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 */

public class Coordinate {
	
	private final int EMPTY = 0;
	private final int WALL = 1;
	private final int PACDOT = 2;
	private final int POWERPELLET = 3;
	private final int CHEERIES = 4;
	
	private Point position; 
	private int identity;
	
	/*
	 * Default constructor sets an identiy to a map point p
	 */
	public Coordinate(Point p){
		
	}
	
	/*
	 * returns the identiy of point p on the map
	 */
	public int GetIdentity(Point p){
		return -1;
	}
	
}
