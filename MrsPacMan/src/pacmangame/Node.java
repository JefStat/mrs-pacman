package pacmangame;
/**
 * This Node class creates a node in relation to the current position and goal position
 * 
 * Please note that this code was taken from http://www.ipaladin.net/astar/ as Professor Esfandiari told us not to reinvent the wheel.
 * 
 * Version: Node Class 1.2
 * @Date: March 2, 2009
 * @Author: Nicole Waldrum
 * 
 * Milestone 3
 * @Date: March 7, 2009
 * @Author: Jen Kasun and Nicole Waldrum
 * 
 * Refined the processes and better documented the code used in this class
 */
public class Node {
	/**
	 * The position
	 */
	public Coordinate position;
	/**
	 * heuristic function, the estimate of what it will take to get to the goal
	 */
    public double goalEstimate;
    /**
     * sum of all the costs it took to get here
     */
    public double costPath;
    /**
     * sum of goalEstimate + costPath
     */
     public double sum;
    /**
     * the previous node from the current node
     */
     Node parent;
    
    /**
     * creates a constructor node
     * @param P is pacman's coordinate
     * @param goalEstimate is the estimate distance to pacman's location
     * @param costPath estimates the cost to get to the position (i.e. is there a wall in the way)
     * @param parent
     */
    public Node(Coordinate P, double goalEstimate, double costPath, Node parent){
    	this.position = P;
        this.goalEstimate = goalEstimate;
        this.costPath = costPath;
        this.sum = this.goalEstimate + this.costPath;
        this.parent = parent;
    }
    /**
     * checks if the positions are equal
     * @param o is the location of pacman
     */
    public boolean equals(Object o) {
        if(o instanceof Node) {
            return position.equals(((Node) o).position);
        } else {
            return false;
        }
    }
    /**
     * returns the position the node
     * @return position of the node
     */
    public Coordinate getPosition(){
    	return position;
    }

}
