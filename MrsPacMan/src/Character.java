import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Character implements ActionListener {
	private final int CHASER = 0;
	private final int AMBUSHER = 1;
	private final int FICKLE = 2;
	private final int STUPID = 3;
	private final int PACMAN = 4;
	
	private Point position;
	private String name;
	private boolean incarcerated;
	private boolean scared;
	private boolean scatter;
	private int personality;
	
	
	public void Ghost(int p){
		
	}
	
	public void movetoPacMan(PacMan P){
		
	}
	
	public void movetoPrison(Point p){
		
	}
	
	public void runAway(PacMan p){
		
	}
	
	public void actionPerformed(ActionEvent arg0) {

	}

}
