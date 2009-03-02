import java.util.Vector;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import sun.management.Agent;
/*
 * The GhostPath class determines the shortest path to PacMan once it is implemented in the Ghost Class
 * 
 * Please note that this code was taken from http://www.ipaladin.net/astar/ as Professor Esfandiari 
 * 
 * Version: GhostPath Class 1.1
 * Date: March 2, 2009
 * Author: Nicole Waldrum And Jef Statham
 */

public class GhostPath extends PacManGame{
	double typicalPath; // default one
    Hashtable open;
    Hashtable closed;
    //creates the map
    Coordinate[][] map;
    //the identity of the item avoiding
    int[] identity;
    //The start and goal coordinates that are necessary to determine the location
    Coordinate startPosition, goalPosition;
    //Creates the default constructor to find the shortest path
    public void AStar(Map map2, int identity[], Coordinate startPosition, Coordinate goalPosition) {
        this.map = map2.getMap();
        this.identity = identity;
        this.startPosition = startPosition;
        this.goalPosition = goalPosition;
        this.typicalPath = getTypicalPath(new Coordinate(0,0, map[0][0].getIdentity()), new Coordinate(map.length - 1, map[0].length - 1, map[map.length - 1][ map[0].length - 1].getIdentity()));
        this.open = new Hashtable(map.length * map[0].length);
        this.closed = new Hashtable(map.length * map[0].length);
    }
    //Finds the typical path that could be taken
    private double getTypicalPath(Coordinate startPosition, Coordinate goalPosition) {
        int left = Math.min(startPosition.x, goalPosition.x);
        int top = Math.min(startPosition.y, goalPosition.y);
        int right = Math.max(startPosition.x, goalPosition.x);
        int bottom = Math.max(startPosition.y, goalPosition.y);
        
        int count = 0;
        for(int i = left; i <= right; i++) {
            for(int j = top; j <= bottom; j++) {
                Coordinate value = map[i][j];
               if(value.getIdentity() != Coordinate.EMPTY) {
                    count++;
                }
            }
        }
        
        return (double)count / 1.1;
    }
    //Determines the shortest path to the goal
    public Vector <Node> AStarSearch(Agent agent) {
    
        PriorityQueue openQueue = new PriorityQueue();
        
        // initialise a start node
        Node startNode = new Node(startPosition, 0, pathCostEstimate(startPosition, goalPosition, agent), null);
                
        openQueue.add(startNode);
        open.put(startNode.position, startNode);
        
        // process the list until success or failure
        while(openQueue.size() > 0) {
        
            Node node = (Node) openQueue.pop();
            open.remove(node.position);
            
            // if at a goal, we're done
            if(node.position.equals(goalPosition)) {
                return solve(node);
            } else {
                Vector <Node> neighbors = getNeighbors(node);
                for(int i = 0; i < neighbors.size(); i++) {
                    Node newNode = (Node)neighbors.elementAt(i);
                    double newCostEstimate = pathCostEstimate(newNode.position, goalPosition, agent);
                    double newCost = node.h + traverseCost(node, newNode, agent);
                    double newTotal = newCost + newCostEstimate;
                    
                    Coordinate nnPosition = newNode.position;
                    Node holderO, holderC;
                    holderO = (Node)open.get(nnPosition);
                    holderC = (Node)closed.get(nnPosition);
                    if(holderO != null && holderO.f <= newTotal) {
                        continue;
                    } else if(holderC != null && holderC.f <= newTotal) {
                        continue;
                    } else {
                        // store the new or improved info
                        newNode.parent = node;
                        newNode.h = newCost;
                        newNode.g = newCostEstimate;
                        newNode.f = newNode.h + newNode.g;
                        if(closed.get(nnPosition) != null) {
                            closed.remove(nnPosition);
                        }
                        Node check = (Node)open.get(nnPosition);
                        if(check != null) {
                            openQueue.remove(check);
                            open.remove(nnPosition);
                        }
                        openQueue.add(newNode);
                        open.put(nnPosition, newNode);
                        
                    } // now done with node
                }
                closed.put(node.position, node);
            }
        }
        return null; // failure
    }
    //Checks the items to determine what the shortest path is
    private Vector <Node> getNeighbors(Node node) {
        Coordinate nodePosition = node.position;
        Vector <Node> neighbors = new Vector<Node>();
        addConditional(neighbors, nodePosition, -1, 0);
        addConditional(neighbors, nodePosition, 0, -1);
        addConditional(neighbors, nodePosition, 0, 1);
        addConditional(neighbors, nodePosition, 1, 0);
        addConditional(neighbors, nodePosition, 1, 1);
        addConditional(neighbors, nodePosition, -1, -1);
        addConditional(neighbors, nodePosition, -1, 1);
        addConditional(neighbors, nodePosition, 1, -1);
        
        return neighbors;
    }
    //Creates a list of alternative paths to see what the shortest is
    private void addConditional(Vector <Node> addTo, Coordinate position, int x, int y) {
        int newX = position.x + x, newY = position.y + y;
        if(newX < 0 || newX >= map.length) {
            return;
        }
        if(newY < 0 || newY >= map[0].length) {
            return;
        }

        if(map[newX][newY].getIdentity() == Coordinate.WALL) {
            return;
        }
        
        Node newNode = new Node(new Coordinate(newX, newY,map[newX][newY].getIdentity()), 0, 0, null);
        addTo.addElement(newNode);
    }
    //Determines the cost of the path that will be taken
    private double pathCostEstimate(Coordinate start, Coordinate goal, Agent agent) {
        if(agent == null ) { // default agent
            int dx = Math.abs(goal.x - start.x);
            int dy = Math.abs(goal.y - start.y);
        
            return typicalPath * (dx + dy);
        } else {
            return 1;
        }
    }
    //Checks the cost that it would to take the shortest path
    private double traverseCost(Node node, Node newNode, Agent agent) {
        if(agent == null ) { // default agent
            Coordinate position1 = node.position, position2 = newNode.position;
            int dx = Math.abs(position1.x - position2.x), dy = Math.abs(position1.y - position2.y);
            return 0.1 * (dx + dy - 1);
        } else {
            return 1;
        }
    }
    //adds the elements to the node to make the shortest path
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