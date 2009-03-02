import java.awt.Point;
import java.math.*;
import java.util.Vector;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import sun.management.Agent;
import sun.org.mozilla.javascript.internal.Node;


public class GhostPath extends PacManGame{
	double typicalPath; // default one
    Hashtable open;
    Hashtable closed;
    Coordinate[][] map;
    
    int[][] grid;
    int[] costs;
    Coordinate startPosition, goalPosition;
    
    public AStar(Map, int identity[], Coordinate startPosition, Coordinate goalPosition) {
        this.map = map.getMap();
        this.identity = identity;
        this.startLoc = startPosition;
        this.goalLoc = goalPosition;
        this.typicalCost = getTypicalPath(new Coordinate(0, 0), new Coordinate(map.length - 1, map[0].length - 1));
        this.open = new Hashtable(map.length * map[0].length);
        this.closed = new Hashtable(map.length * map[0].length);
    }
    
    private double getTypicalIdentity(Coordinate startPosition, Coordinate goalPosition) {
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

    public Vector AStarSearch(Agent agent) {
    
        PriorityQueue openQueue = new PriorityQueue();
        
        // initialise a start node
        Node startNode = new Node();
        startNode.position = startPosition;
        startNode.h = 0;
        startNode.g = pathCostEstimate(startPosition, goalPosition, agent);
        startNode.f = startNode.h + startNode.g;
        startNode.parent = null;
        
        openQ.add(startNode);
        open.put(startNode.position, startNode);
        
        // process the list until success or failure
        while(openQ.size() > 0) {
        
            Node node = openQ.pop();
            open.remove(node.location);
            
            // if at a goal, we're done
            if(node.position.equals(goalPosition)) {
                return solve(node);
            } else {
                Vector neighbors = getNeighbors(node);
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
    
    private Vector getNeighbors(Node node) {
        Coordinate nodePosition = node.position;
        Vector neighbors = new Vector();
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
    
    private void addConditional(Vector addTo, Location loc, int x, int y) {
        int newX = loc.x + x, newY = loc.y + y;
        if(newX < 0 || newX >= map.length) {
            return;
        }
        if(newY < 0 || newY >= map[0].length) {
            return;
        }

        if(map[newX][newY] == map.getIdentity(4)) {
            return;
        }
        
        Node newNode = new Node();
        newNode.position = new Coordinate(newX, newY);
        addTo.addElement(newNode);
    }
    
    private double pathCostEstimate(Coordinate start, Coordinate goal, Agent agent) {
        if(agent == null ) { // default agent
            int dx = Math.abs(goal.x - start.x);
            int dy = Math.abs(goal.y - start.y);
            double diff = (double)Math.abs(dx - dy);
        
            return typicalPath * (dx + dy);
        } else {
            return 1;
        }
    }
    
    private double traverseCost(Node node, Node newNode, Agent agent) {
        if(agent == null ) { // default agent
            Coodinate position1 = node.position, position2 = newNode.position;
            int dx = Math.abs(position1.x - position2.x), dy = Math.abs(position1.y - position2.y);
            return identity[map[newNode.position.x][newNode.position.y]] + 0.1 * (dx + dy - 1);
        } else {
            return 1;
        }
    }
    
    private Vector solve(Node node) {
        Vector solution = new Vector();
        
        solution.addElement(node);
        while(node.parent != null) {
            solution.insertElementAt(node.parent, 0);
            node = node.parent;
        }
        
        return solution;
    }
	
}