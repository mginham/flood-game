package codes;

public class Node {

	private int data;
	private Node up, down, left, right;
	private static int counter;
	
	public Node() {
		counter++;
		this.data = (int)(Math.random()*6+1);
		
		up = null;
		down = null;
		left = null;
		right = null;
	} // end constructor

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getUp() {
		return up;
	}

	public void setUp(Node up) {
		this.up = up;
	}

	public Node getDown() {
		return down;
	}

	public void setDown(Node down) {
		this.down = down;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Node.counter = counter;
	}
	
} // end class Node
