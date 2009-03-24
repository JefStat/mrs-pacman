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
	
	public Coordinate getC() {
		return c;
	}

	public void setC(Coordinate c) {
		this.c = c;
	}

	public Map getM() {
		return m;
	}

	public void setM(Map m) {
		this.m = m;
	}

	private Coordinate c;
	private Map m;
	private int i;
	
	
	public  NotifierObject(Coordinate c, Map m, int i) {
		this.setC(c);
		this.setM(m);
		this.setI(i);
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getI() {
		return i;
	}


}
