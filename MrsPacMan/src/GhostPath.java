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
 */
public class GhostPath{
	/** 
	 * default one
	 */
	static int typicalPath; 
	Hashtable open;
    Hashtable closed;
    /**
     * creates the map
     */
    Coordinate[][] map2;
    /**
     * the identity of the item avoiding
     */
    int[] identity;
    /**
     * The start and goal coordinates that are necessary to determine the location
     */
    Coordinate startPosition, goalPosition;
    /**
     * Creates the default constructor to find the shortest path
     */
    public GhostPath(Ghost g,Map m) {
        map2 = m.getMap();
        startPosition = m.getPacManStart(); // this may not be valid.. do you want were pac man is at the point of call or where he is in the game state?
        goalPosition = g.getPosition();
        open = new Hashtable(map2.length * map2[0].length);
        closed = new Hashtable(map2.length * map2[0].length);
        typicalPath = getTypicalPath(new Coordinate(0,0, map2[0][0].getIdentity()), new Coordinate((map2.length - 1), (map2[0].length - 1), (map2[map2.length - 1][ map2[0].length - 1].getIdentity())));
    }
    
    /**
     * Determines the cost of the path that will be taken
     * @param start
     * @param goal
     * @return path to be taken
     */
    public static double pathDistanceEstimate(Coordinate start, Coordinate goal) {
            int dx = Math.abs(goal.x - start.x);
            int dy = Math.abs(goal.y - start.y);
        
            return typicalPath * (dx + dy);
    }

    /**
     * Checks the cost that it would to take the shortest path
     * @param node
     * @param newNode
     * @param p
     * @return distance to traverse
     */
    private double traverseDistance(Node node, Node newNode, Coordinate p) {
        if(p == null ) { // default agent
            Coordinate position1 = node.position, position2 = newNode.position;
            int dx = Math.abs(position1.x - position2.x), dy = Math.abs(position1.y - position2.y);
            return 01.*(dx + dy - 1);
        } else {
        	return 1;
        }
    }

    /**
     * Finds the typical path that could be taken
     * @param startPosition
     * @param goalPosition
     * @return path to be taken
     */
    private int getTypicalPath(Coordinate startPosition, Coordinate goalPosition){
        int left = Math.min(startPosition.x, goalPosition.x);
        int top = Math.min(startPosition.y, goalPosition.y);
        int right = Math.max(startPosition.x, goalPosition.x);
        int bottom = Math.max(startPosition.y, goalPosition.y);
        
        int count = 0;
        for(int i = left; i <= right; i++) {
            for(int j = top; j <= bottom; j++) {
                Coordinate value = map2[i][j];
               if((value.getIdentity() != Coordinate.EMPTY ||value.getIdentity() != Coordinate.PACDOT|| value.getIdentity() != Coordinate.FRUIT ||value.getIdentity() != Coordinate.POWERPELLET)){
                    count++;
                }
            }
        }
        
        return count;
    }
  
    /**
     * Determines the shortest path to the goal
     * @param p
     * @return shortest path to goal
     */
    public Node AStarSearch(Coordinate p) {
    
        PriorityQueue openQueue = new PriorityQueue();
        
        /**
         *  initialise a start node
         */
        Node startNode = new Node(startPosition, 0, pathDistanceEstimate(startPosition, goalPosition), null);
                
        openQueue.add(startNode);
        open.put(startNode.position, startNode);
        
        /**
         *  process the list until success or failure
         */
        while(openQueue.size() > 0) {
        
            Node newNode = (Node) openQueue.pop();
            open.remove(newNode.position);
         /**
          *  if at a goal, we're done
          */
            if(newNode.position.equals(goalPosition)) {
            	solve(newNode);
            	return (Node)newNode;
            } else {
                Vector <Node> neighbours = getNeighbours(newNode);
                for(int i = 0; i < neighbours.size(); i++) {
                    Node newNode1 = (Node)neighbours.elementAt(i);
                    double newDistanceEstimate = pathDistanceEstimate(newNode1.position, goalPosition);
                    double newDistance = newNode.h + traverseDistance(newNode, newNode1, p);
                    double newTotal = newDistance + newDistanceEstimate;
                                       
                    Coordinate nnPosition = newNode1.position;
                    Node holderO, holderC;
                    holderO = (Node)open.get(nnPosition);
                    holderC = (Node)closed.get(nnPosition);
                    if(holderO != null && holderO.f <= newTotal) {
                        continue;
                    } else if(holderC != null && holderC.f <= newTotal) {
                        continue;
                    } else {
                        // store the new or improved info
                        newNode1.parent = newNode;
                        newNode1.h = newDistance;
                        newNode1.g = newDistanceEstimate;
                        newNode1.f = newNode1.h + newNode1.g;
                        if(closed.get(nnPosition) != null) {
                            closed.remove(nnPosition);
                        }
                        Node check = (Node)open.get(nnPosition);
                        if(check != null) {
                            openQueue.remove(check);
                            open.remove(nnPosition);
                        }
                        openQueue.add(newNode1);
                        open.put(nnPosition, newNode1);
                        solve(newNode1);
                        return (Node)newNode1;
                        
                    } 
                    /**
                     *  now done with node
                     */
                }
                closed.put(newNode.position, newNode);
      
            }
        }
        return null; 
        /**
         *  failure            
         */
      }
    
	/**
	 * Checks the items next to Ghost to determine what the shortest path is
	 * @param node
	 * @return neighbours path of ghost
	 */
	private Vector <Node> getNeighbours(Node node) {
		Coordinate nodePosition = node.position;
		Vector <Node> neighbours = new Vector<Node>();
		addConditional(neighbours, nodePosition, -1, 0);
		addConditional(neighbours, nodePosition, 0, -1);
		addConditional(neighbours, nodePosition, 0, 1);
		addConditional(neighbours, nodePosition, 1, 0);
		addConditional(neighbours, nodePosition, 1, 1);
		addConditional(neighbours, nodePosition, -1, -1);
		addConditional(neighbours, nodePosition, -1, 1);
		addConditional(neighbours, nodePosition, 1, -1);
    
		return neighbours;
	}
	/**
	 * Creates a list of the shortest paths based on the numbers calculated from PacMan
	 * @param addTo
	 * @param position
	 * @param x
	 * @param y
	 */
	private void addConditional(Vector <Node> addTo, Coordinate position, int x, int y) {
        int newX = position.x + x, newY = position.y + y;
        if(newX < 0 || newX >= map2.length) {
            return;
        }
        if(newY < 0 || newY >= map2[0].length) {
            return;
        }

        if(map2[newX][newY].getIdentity() == Coordinate.WALL) {
            return;
        }
        
        Node newNode = new Node(new Coordinate(newX, newY,map2[newX][newY].getIdentity()), 0, 0, null);
        addTo.addElement(newNode);
    }

    /**
     * adds the elements to the node from PacMan to Ghost to make the shortest path
     * @param node
     * @return shortest path with all elements taken into account
     */
    private Vector <Node> solve(Node node) {
        Vector <Node> solution = new Vector<Node>();        
        solution.addElement(node);
        while(node.parent != null) {
            solution.insertElementAt(node.parent, 0);
            node = node.parent;
        }
        
        return solution;
    }
    
}