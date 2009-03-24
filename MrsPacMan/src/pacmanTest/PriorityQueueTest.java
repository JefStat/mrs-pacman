package pacmanTest;
import pacmangame.Coordinate;
import pacmangame.Node;
import pacmangame.PriorityQueue;
import junit.framework.TestCase;
/**
 * This test case checks that the PriorityQueue class is appropriately queuing up
 * the important node that the ghost will need to follow to get to PacMan
 * 
 * Milestone 3
 * @Date March 7, 2009
 * @author Nicole Waldrum
 *
 */


public class PriorityQueueTest extends TestCase {
	/**
	 * Creates an array of queues as type Node
	 */
	PriorityQueue queue = new PriorityQueue();
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	/**
	 * pops the first node on the list off
	 */
	public void testPop() {
		//creates new coordinates for the nodes
		Coordinate newCoordinate = new Coordinate(2,3,1);
		Coordinate newCoordinate1 = new Coordinate(2,3,4);
		Coordinate newCoordinate2 = new Coordinate(6,5,4);
		//creates the new nodes to be tested against
		Node newNode = new Node(newCoordinate, 1, 2, null);
		Node newNode1 = new Node(newCoordinate1, 2, 3, newNode);
		Node newNode2 = new Node(newCoordinate2, 4, 3, newNode1);
		//adds the new nodes to the priority queue
		queue.add(newNode);
		queue.add(newNode1);
		queue.add(newNode2);
		assertEquals("This should return true if popped", queue.pop(), newNode);
	}
	/**
	 * adds a new node to the priorityqueue
	 */
	public void testAdd() {
		//creates new coordinates for the nodes
		Coordinate newCoordinate = new Coordinate(2,3,1);
		Coordinate newCoordinate1 = new Coordinate(2,3,4);
		Coordinate newCoordinate2 = new Coordinate(6,5,4);
		//creates the new nodes to be tested against
		Node newNode = new Node(newCoordinate, 1, 2, null);
		Node newNode1 = new Node(newCoordinate1, 2, 3, newNode);
		Node newNode2 = new Node(newCoordinate2, 4, 3, newNode1);
		//adds a new node
		queue.add(newNode);
		queue.add(newNode1);
		queue.add(newNode2);
		assertEquals("Returns true if the new Nodes are added",  queue.size(), 3);
	}
	/**
	 * test that the priorityqueue list contains the appropriate nodes
	 */
	public void testContains() {
		//creates new coordinates for the nodes
		Coordinate newCoordinate = new Coordinate(2,3,1);
		Coordinate newCoordinate1 = new Coordinate(2,3,4);
		Coordinate newCoordinate2 = new Coordinate(6,5,4);
		//creates the new nodes to be tested against
		Node newNode = new Node(newCoordinate, 1, 2, null);
		Node newNode1 = new Node(newCoordinate1, 2, 3, newNode);
		Node newNode2 = new Node(newCoordinate2, 4, 3, newNode1);
		//adds the new nodes to the priority queue
		queue.add(newNode);
		queue.add(newNode1);
		queue.add(newNode2);
		//checks that the node is contained
		assertTrue("Returns true if the new Node is contained", queue.contains(newNode));
		assertTrue("Returns true if the new Node is contained", queue.contains(newNode1));
		assertTrue("Returns true if the new Node is contained", queue.contains(newNode2));
	}
	/**
	 * tests that the priorityqueue removes the proper nodes
	 */
	public void testRemove() {
		//creates new coordinates for the nodes
		Coordinate newCoordinate = new Coordinate(2,3,1);
		Coordinate newCoordinate1 = new Coordinate(2,3,4);
		Coordinate newCoordinate2 = new Coordinate(6,5,4);
		//creates the new nodes to be tested against
		Node newNode = new Node(newCoordinate, 1, 2, null);
		Node newNode1 = new Node(newCoordinate1, 2, 3, newNode);
		Node newNode2 = new Node(newCoordinate2, 4, 3, newNode1);
		//adds the new nodes to the priority queue
		queue.add(newNode);
		queue.add(newNode1);
		queue.add(newNode2);
		//removes the first node
		queue.remove(newNode1);
		assertFalse("Should return null for newNode1 as it was removed", queue.contains(newNode1));
	}
	/**
	 * checks the size of the node and should return the number of priorityqueues
	 */
	public void testSize() {
		//creates new coordinates for the nodes
		Coordinate newCoordinate = new Coordinate(2,3,1);
		Coordinate newCoordinate1 = new Coordinate(2,3,4);
		Coordinate newCoordinate2 = new Coordinate(6,5,4);
		//creates the new nodes to be tested against
		Node newNode = new Node(newCoordinate, 1, 2, null);
		Node newNode1 = new Node(newCoordinate1, 2, 3, newNode);
		Node newNode2 = new Node(newCoordinate2, 4, 3, newNode1);
		//adds the new nodes to the priority queue
		queue.add(newNode);
		queue.add(newNode1);
		queue.add(newNode2);
		//should return the size of the new
		assertEquals("The size of the queue should be 3", queue.size(), 3);
		queue.remove(newNode);
		assertEquals("This size of the queue should be 2 because newNode was removed", queue.size(), 2);
	}

}
