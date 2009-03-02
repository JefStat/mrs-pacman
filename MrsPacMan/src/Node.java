
public class Node {
	Coordinate position;
    double h;
    double g;
    double f;
    Node parent;
    
    //creates a constructor node
    public Node(){
    	super();
    }
    public boolean equals(Object o) {
        if(o instanceof Node) {
            return position.equals(((Node) o).position);
        } else {
            return false;
        }
    }

}
