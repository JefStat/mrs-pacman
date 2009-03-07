import java.util.Vector;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import sun.management.Agent;
/*
 * The GhostPath class determines the shortest path to PacMan once it is implemented in the Ghost Class
 * 
 * Please note that this code was taken from http://www.ipaladin.net/astar/ as Professor Esfandiari told us not to reinvent the wheel.
 * 
 * Version: GhostPath Class 1.1
 * Date: March 2, 2009
 * Author: Nicole Waldrum And Jef Statham
 * 
 * Milestone 3
 * 
 * Due to Nicole's previous incompetence, Jen and Nicole revisited the A* Search algorithm to restructure what had already been implemented.
 * The code originally created has key ideas necessary but did not entire apply to what was required for PacMan.  With this in mind the AStarSearch
 * was recoded to better suit the needs of PacMan.
 * 
 * Date: March 6th, 2009
 * Written/Modified: Jen Kasun and Nicole Waldrum
 */

public class GhostPath extends PacManGame{
	int typicalPath; // default one
	Hashtable open;
    Hashtable closed;
    //creates the map
    Coordinate[][] map2;
    //the identity of the item avoiding
    int[] identity;
    //The start and goal coordinates that are necessary to determine the location
    Coordinate startPosition, goalPosition;
    //Creates the default constructor to find the shortest path
    public void AStar() {
        map2 = map.getMap();
        startPosition = PacMan.getPosition();
        goalPosition = Ghost.getPosition();
        open = new Hashtable(map2.length * map2[0].length);
        closed = new Hashtable(map2.length * map2[0].length);
        typicalPath = getTypicalPath(new Coordinate(0,0, map2[0][0].getIdentity()), new Coordinate((map2.length - 1), (map2[0].length - 1), (map2[map2.length - 1][ map2[0].length - 1].getIdentity())));
    }
    
  //Determines the cost of the path that will be taken
    private double pathDistanceEstimate(Coordinate start, Coordinate goal, Character p) {
        if(p == null ) { // default agent
            int dx = Math.abs(goal.x - start.x);
            int dy = Math.abs(goal.y - start.y);
        
            return typicalPath * (dx + dy);
        } else {
            return 1;
        }
    }

//Checks the cost that it would to take the shortest path
    private double traverseDistance(Node node, Node newNode, Character p) {
        if(p == null ) { // default agent
            Coordinate position1 = node.position, position2 = newNode.position;
            int dx = Math.abs(position1.x - position2.x), dy = Math.abs(position1.y - position2.y);
            return 01.*(dx + dy - 1);
        } else {
        	return 1;
        }
    }

//Finds the typical path that could be taken
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
  
    //Determines the shortest path to the goal
    public Vector <Node> AStarSearch(Character p) {
    
        PriorityQueue openQueue = new PriorityQueue();
        
        // initialise a start node
        Node startNode = new Node(startPosition, 0, pathDistanceEstimate(startPosition, goalPosition, p), null);
                
        openQueue.add(startNode);
        open.put(startNode.position, startNode);
        
        // process the list until success or failure
        while(openQueue.size() > 0) {
        
            Node newNode = (Node) openQueue.pop();
            open.remove(newNode.position);
         // if at a goal, we're done
            if(newNode.position.equals(goalPosition)) {
                return solve(newNode);
            } else {
                Vector <Node> neighbours = getNeighbours(newNode);
                for(int i = 0; i < neighbours.size(); i++) {
                    Node newNode1 = (Node)neighbours.elementAt(i);
                    double newDistanceEstimate = pathDistanceEstimate(newNode1.position, goalPosition, p);
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
                        
                    } // now done with node
                }
                closed.put(newNode.position, newNode);
            }
        }
        return null; // failure            
      }
    
	//Checks the items next to Ghost to determine what the shortest path is
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
	//Creates a list of the shortest paths based on the numbers calculated from PacMan
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

    //adds the elements to the node from PacMan to Ghost to make the shortest path
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