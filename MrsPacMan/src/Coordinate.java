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
 * Milestone 2: WRITTEN/MODIFIED by Nahim Nasser
 * Updates: Functions added and modified
 */

@SuppressWarnings("serial")
public class Coordinate extends Point{
	
	public final static int EMPTY = 0;
	public final static int WALL = 1;
	public final static int PACDOT = 2;
	public final static int POWERPELLET = 3;
	public final static int CHEERIES = 4;
	public final static int PRISON = 5;
	
	private int identity;
	
	/*
	 * Default constructor sets an identiy to a map point p
	 */
	public Coordinate(int x, int y, int identity){
		super(x,y);
		this.identity = identity;
	}
	/*
	 * returns the identiy of point p on the map
	 */
	public int getIdentity(){
		return identity;
	}
	
	public void setIdentity(int x){
		this.identity = x;
	}
	
}
