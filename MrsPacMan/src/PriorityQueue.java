import java.util.Vector;

public class PriorityQueue {
	Vector queue = new Vector();
    
    public Node pop() {
        Node node = (Node)queue.elementAt(0);
        queue.removeElement(node);
        return node;
    }
    
    public void add(Node node) {
        if(queue.size() == 0) {
            queue.addElement(node);
        } else {
            int i;
            for(i = 0; i < q.size(); i++) {
                Node holder = (Node)queue.elementAt(i);
                if(holder.f >= node.f) {
                    queue.insertElementAt(node, i);
                    break;
                }
            }
            if(i == queue.size()) {
                queue.addElement(node);
            }
        }
    }
    
    public boolean contains(Node node) {
        return queue.contains(node);
    }
    
    public void remove(Node node) {
        queue.removeElement(node);
    }
    
    public int size() {
        return queue.size();
    }

}
