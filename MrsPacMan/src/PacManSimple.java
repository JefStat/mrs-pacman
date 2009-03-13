import java.util.Observable;
import java.util.Observer;

public class PacManSimple extends PacManGame implements Observer{
	/**
	 * sets the default lives
	 */
	private final int DEFAULTLIVES = 3;
	/**
	 * keeps track of pacman's position
	 */
	private Coordinate position;
	/**
	 * keeps track of pacman's lives left
	 */
	private int livesLeft;
	//following item are for testing purposes
	private boolean alive;
	public boolean isAlive(){
		return alive;
	}
	public void setAlive(boolean alive){
		this.alive = alive;
	}
	public Coordinate getPosition(){
		return position;
	}
	// end testing purposes
	
	/**
	 * Creates a new PacMan object
	 */
	public PacManSimple(){
		livesLeft = DEFAULTLIVES;
		position = getMap(1).getPacManStart();
	}
	
	/**
	 * Sets pacman's position to start if it was dead and re-animates pacman.
	 * Otherwise will change pacman's position if checkmovement returns true. 
	 * @param p
	 * @return true if movement was changed
	 */
	public boolean setPosition(Coordinate p){
		if ((this.isAlive())&&(checkMovement(p))){
			position = p;
			return true;
		} else if (!(this.isAlive())){
			if (this.livesLeft > 0) {
				this.setAlive(true);
				position = map.getPacManStart();
				return true;
			} 
			return false;
			
		}
		return false;
	}
	
	/**
	 * check to see if movement is more then one point.. ie avoid
	 * teleporting pacman this is useless you can set the position 
	 * through point because it's a mutable object. 
	 * {@link Point.Translate()}
	 * 
	 * @param p
	 * @return true if pacman can move to selected coordinate
	 */
	public boolean checkMovement(Coordinate p) {
		double x = p.getX() - position.getX(); 
		double y = p.getY() - position.getY();
		if ((map.getIdentity(p) == Coordinate.WALL)||(map.getIdentity(p) == Coordinate.PRISON)){
			return false;
		} if ((1 > Math.abs(x))||(1 > Math.abs(y))){
			return false;
		}
		return true;
	}
	/**
	 * Update will move pacMan or remove lives if he is caught
	 * 	@Override
	 */
	public void update(Observable arg0, Object arg1) {
		int identity =	map.getIdentity(this.getPosition());
		if (identity == Coordinate.PACDOT){
			map.setIdentity(this.getPosition());
		}
	}
}
