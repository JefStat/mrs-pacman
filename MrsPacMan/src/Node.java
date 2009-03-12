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
 */
public class Node {
	/**
	 * The position
	 */
	Coordinate position;
	/**
	 * heuristic function, the estimate of what it will take to get to the goal
	 */
    double h;
    /**
     * sum of all the costs it took to get here
     */
    double g;
    /**
     * sum of h + g
     */
    double f;
    /**
     * the previous node from the current node
     */
    Node parent;
    
    /**
     * creates a constructor node
     * @param P
     * @param h
     * @param g
     * @param parent
     */
    public Node(Coordinate P, double h, double g, Node parent){
    	this.position = P;
        this.h = h;
        this.g = g;
        this.f = this.h + this.g;
        this.parent = parent;
    }
    /**
     * checks if the positions are equal
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
     * @return position
     */
    public Coordinate getPosition(){
    	return position;
    }

}
