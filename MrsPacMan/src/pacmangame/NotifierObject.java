package pacmangame;


/**
 * The class that contains the references passed when an object is notified
 * 
 * @author jef
 * @date March 30th, 2009
 * 
 * Created this class to pass multiple types of information so each observer could act accordingly.
 *
 */
public class NotifierObject {
	/**
	 * gets the current coordinate
	 * @return c is the coordinate location
	 */
	public Coordinate getC() {
		return c;
	}
	/**
	 * sets the location of the coordinate
	 * @param c a coordinate location
	 */
	public void setC(Coordinate c) {
		this.c = c;
	}
	/**
	 * gets the current map
	 * @return m, the current map
	 */
	public Map getM() {
		return m;
	}
	/**
	 * sets the current map
	 * @param m, the current map
	 */
	public void setM(Map m) {
		this.m = m;
	}
	//coordinate variable
	private Coordinate c;
	//map variable
	private Map m;
	//integer variable
	private int i;
	
	/**
	 * this sets all three of the parameters passed into this method
	 * @param c is a coordinate
	 * @param m is the map
	 * @param i is an integer
	 */
	public  NotifierObject(Coordinate c, Map m, int i) {
		this.setC(c);
		this.setM(m);
		this.setI(i);
	}
	/**
	 * sets the integer value
	 * @param i, is an integer
	 */
	public void setI(int i) {
		this.i = i;
	}
	/**
	 * returns an integer value
	 * @return integer value i
	 */
	public int getI() {
		return i;
	}


}
