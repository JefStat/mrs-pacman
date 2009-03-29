package pacmangame;
import java.util.Vector;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

/**
 * This class finds the quickest route between coordinates
 *
 * Please note that this code was taken from http://www.ipaladin.net/astar/ as Professor Esfandiari told us not to reinvent the wheel.
 * 
 * Version: Priority Queue Class 1.1
 * @Date: March 2, 2009
 * @Author: Nicole Waldrum
 * 
 * Milestone 3
 * @Date: March 7, 2009
 * @Author:Jen Kasun and Nicole Waldrum
 * 
 * Implemented GhostPath so that it worked with the code of the PacMan Game
 * 
 * Milestone 4
 * @Date: March 29th, 2009
 * @Author: Nicole Waldrum
 * 
 * After discovering that the GhostPath didn't work and many hours of contemplation
 * GhostPath was rewritten (And works).  The ghosts now find pacman (or any destination)
 * that is put in as the goal position.
 */
public class GhostPath{

    /**
     * gets the ghosts name and the map
     */
    public GhostPath(String name,Map m) {
    }
    
    /**
     * Determines the cost of the path that will be taken
     * @param start is the pacman location
     * @param goal is the ghosts location
     * @return path to be taken
     */
    public static double pathDistanceEstimate(Coordinate start, Coordinate goal) {
            int dx = Math.abs((int)goal.getX() - (int)start.getX());
            int dy = Math.abs((int)goal.getY() - (int)start.getY());
        
            return Math.sqrt( (dx*dx) + (dy*dy));
    }
  
    /**
     * Determines the shortest path to the goal
     * @param map is the current map in use
     * @param is the ghost's location
     * @param goal pacman's location
     * @return shortest path to goal
     */
    public static Coordinate AStarSearch(Map map, Coordinate start, Coordinate goal) {
    
    	PriorityQueue pq = new PriorityQueue();
    	Hashtable closed = new Hashtable();
    	//build prioqueue of nodes, insert me
    	pq.add(new Node(start, pathDistanceEstimate(start, goal), 0, null) );
    	
    	//while the queue is not empty
    	
    	while( pq.size() > 0 ) {
    	
    		//get best in queue
    	
    		Node best = pq.pop();
    		//if this is goal, find solve(thisnode), return that coord
    		if (best.position.equals(goal) ) {
    			return solve(best).position;
    		}
    		//else
    	
    		//add all valid neighbours to queue
    		Vector<Node> neighbours = getNeighbours(best, map, goal);
    		for( int i =0; i < neighbours.size(); ++i) {
    			if (!closed.contains( neighbours.elementAt(i)) ) {
    				pq.add(neighbours.elementAt(i));
    			}
    		}
    	
    		//add this node to invalid
    		closed.put(best, best);
    		
    	//start over
    	}

    	return null;    
    }
    
	/**
	 * Checks the items next to Ghost to determine what the shortest path is
	 * @param node the ghosts shortest path square
	 * @param map is the map that is currently in used
	 * @param goal is the position of PacMan
	 * @return neighbours path of ghost
	 */
	private static Vector <Node> getNeighbours(Node node, Map map, Coordinate goal) {
		Vector <Node> neighbours = new Vector<Node>();
		addConditional(map, goal, neighbours, node, -1, 0);
		addConditional(map, goal, neighbours, node, 0, -1);
		addConditional(map, goal, neighbours, node, 0, 1);
		addConditional(map, goal, neighbours, node, 1, 0);
		return neighbours;
	}
	/**
	 * Creates a list of the shortest paths based on the numbers calculated from PacMan
	 * @param map is the current map in use
	 * @param goal is PacMan's current position
	 * @param addTo, puts item on node
	 * @param position
	 * @param x location of path
	 * @param y location of path
	 */
	private static void addConditional(Map map, Coordinate goal,  Vector <Node> addTo, Node parent, int x, int y) {
        int newX = parent.position.x + x, newY = parent.position.y + y;
        if(newX < 0 || newX >= map.getSize()) {
            return;
        }
        if(newY < 0 || newY >= map.getSize()) {
            return;
        }
        if(map.getIdentity(newX,newY) == Coordinate.WALL) {
            return;
        }
        
        Coordinate newNodeCoord = new Coordinate(newX, newY, map.getIdentity(newX, newY)) ;
        double newGoalEst = pathDistanceEstimate(newNodeCoord, goal);
        Node newNode = new Node(newNodeCoord, newGoalEst, parent.costPath + 1, parent);
        addTo.addElement(newNode);
    }

    /**
     * adds the elements to the node from PacMan to Ghost to make the shortest path
     * @param node the first square taken on the shortest path
     * @return shortest path with all elements taken into account
     */
    private static Node solve(Node node) {
    	Node retVal = node;
    	
    	if( retVal.parent == null ) {
    		return retVal;
    	}
    	
        while(retVal.parent.parent != null) {
            retVal = retVal.parent;
        }
        return retVal;
    }
    
}