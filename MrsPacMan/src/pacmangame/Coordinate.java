package pacmangame;
import java.awt.Point;
/**
 * This class establishes what positions are current for each player.  In addition
 * to this there are only 5 set cases for what items can be on the map.  The space on
 * the map is either empty, a wall, a PacMan pellet, a power pellet, or fruit.  When
 * all of these items are gone then the level is considered completed.
 * 
 * Title: Coorindate Class version 1.1
 * @Date: February 16, 2009
 * @Author: Nicole Waldrum and Jef Statham
 * @Milestone 2: WRITTEN/MODIFIED by Nahim Nasser
 * @Updates: Functions added and modified
 */

@SuppressWarnings("serial")
public class Coordinate extends Point{
	/**
	 * this constant is empty space, after pacman has eaten what was there
	 */
	public final static int EMPTY = 0;
	/**
	 * this constant is a wall
	 */
	public final static int WALL = 1;
	/**
	 * this constant is the dot that pacman eats
	 */
	public final static int PACDOT = 2;
	/**
	 * this constant is the dot that when eaten makes ghost scared and scatter
	 */
	public final static int POWERPELLET = 3;
	/**
	 * this constant is fruit, when eaten it will give bonous points to pacman
	 */
	public final static int FRUIT = 4;
	/**
	 * this constant is the prison, so pacman cannot enter there but ghosts can
	 */
	public final static int PRISON = 5;
	/**
	 * this variable checks again each constant
	 */
	private int identity;
	
	/**
	 * Default constructor sets an identity to a map point p
	 * @param x is the x coordinate of the point
	 * @param y is the y coordinate of the point
	 * @param identity gives the identity of the coordinate
	 */
	public Coordinate(int x, int y, int identity){
		super(x,y);
		this.identity = identity;
	}
	/**
	 * returns the identity of point p on the map
	 * @return identity is the current item set to a coordinate
	 */
	public int getIdentity(){
		return identity;
	}
	/**
	 * returns the identity that is found at point x so that the character knows what they have landed on
	 * @param x is the item set to a coordinate
	 */
	public void setIdentity(int x){
		if (x < 6){
			this.identity = x;
		}
		else{
			this.identity = -1;
		}
	}
	/**
	 * This isEqual method overrides so that the test method properly works.
	 * Checks whether or not two points are equal then checks if the identity is equal
	 * @param obj is the corrdinate
	 */
	public boolean equals(Object obj) {
		return ( this.getX() == ((Coordinate)obj).getX() && this.getY() == ((Coordinate)obj).getY());
	}
	
}
