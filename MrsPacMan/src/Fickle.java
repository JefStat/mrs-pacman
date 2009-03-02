import java.awt.Point;
/*
 * This Fickle class is the blue ghost, whose behaviour is bashful.
 * Released third out of the ghost pen after Chaser and Ambusher are off.
 * Fickle will move about the board randomly but may follow if close to PacMan.
 * The respective corner is the bottom right of the screen.
 * 
 * Title: Fickle Class version 1.1
 * Date: February 16, 2009
 * Author: Nicole Waldrum and Jef Statham
 */

public class Fickle extends Ghost {
	
	private final String NAME = "Inky";
	private final Point CORNER = new Point(Max,0);
	
	/*
	 * Default Constructor
	 */
	public Fickle(){
				
	}
	
	public void movetoPacMan(PacMan p){
		
	}
	
}
