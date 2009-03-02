import java.awt.Point;
import java.math.*;

public class GhostPath {
	private Coordinate p;
	//finds the position of the ghost
	public void GhostPath(Ghost ghost){
			p = ghost.getPosition();
			Coordinate x = p.getx();
			Coordinate y = p.gety();
	}
	//checks to see if the coordinates of x and y are the same
	public boolean SamePoint(Coordinate p){
		if (x == y){
			return true;
		}
		else{
			return false;
		}
	}
	//estimates the distance to PacMan
	public float PacManDistance(PacMan P){
		float xd = fabs(float((float)x - (float)P.getPosition(getx())));
		float yd = fabs(float((float)y - (float)P.getPosition(gety())));
		return xd + yd;
	}
	public boolean PacManFound(PacMan P){
		if (x == P.getPosition(getx()) && y == P.getPosition(gety())){
			return true;
		}
		return false;
	}
	boolean GetPacMan()
	
}