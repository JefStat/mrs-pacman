import java.util.Vector;
/**
 * This class creates a list of priority queues in order to ascertain the quickest route
 *
 * Please note that this code was taken from http://www.ipaladin.net/astar/ as Professor Esfandiari told us not to reinvent the wheel.
 * 
 * Version: Priority Queue Class 1.1
 * @Date: March 2, 2009
 * @Author: Nicole Waldrum
 */

public class PriorityQueue {
	//Creates an array of queues as type Node
	Vector <Node> queue = new Vector<Node>();
    //removes a queue from the list
    public Node pop() {
        Node node = (Node)queue.elementAt(0);
        queue.removeElement(node);
        return node;
    }
    //adds a queue to the list
    public void add(Node newNode) {
        if(queue.size() == 0) {
            queue.addElement(newNode);
        } else {
            int i;
            for(i = 0; i < queue.size(); i++) {
                Node holder = (Node)queue.elementAt(i);
                if(holder.f >= newNode.f) {
                    queue.insertElementAt(newNode, i);
                    break;
                }
            }
            if(i == queue.size()) {
                queue.addElement(newNode);
            }
        }
    }
    //Checks if the node is already contained in the queue
    public boolean contains(Node node) {
        return queue.contains(node);
    }
    //Removes the Node from the queue
    public void remove(Node node) {
        queue.removeElement(node);
    }
    //Checks the size of the priority queue list
    public int size() {
        return queue.size();
    }

}
