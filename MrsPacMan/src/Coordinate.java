import java.awt.Point;


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
