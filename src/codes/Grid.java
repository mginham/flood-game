package codes;

public class Grid {

	private int dimension;
	private static Node first;
	
	public Grid(int dimension) {
		this.dimension = dimension;
		
		if(dimension == 1)
			first = new Node();
		else if(dimension <= 0)
			first = null;
		else {
			first = new Node();
			
			Node temp;
			Node columnMarker = first;
			Node rowMarker = first;
			
			for(int x = 0; x < dimension-1; x++) {
				temp = new Node();
				
				columnMarker.setRight(temp);
				temp.setLeft(columnMarker);
				
				columnMarker = temp;
			}
			
			for(int x = 0; x < dimension-1; x++) {
				temp = new Node();
				rowMarker.setDown(temp);
				temp.setUp(rowMarker);
				
				rowMarker = temp;
				columnMarker = rowMarker;
				
				for(int y = 0; y < dimension-1; y++) {
					temp = new Node();
					
					columnMarker.setRight(temp);
					temp.setLeft(columnMarker);
					temp.setUp(temp.getLeft().getUp().getRight());
					temp.getUp().setDown(temp);
					
					columnMarker = temp;
				}
			}
		}
	} // end constructor
	
	public void display() {
		Node temp = first;
		Node rowMarker = first;
		
		while(temp != null) { // down
			while(temp != null) { // across
				if(temp.getData() > 99)
					System.out.print(temp.getData() + " ");
				else if(temp.getData() > 9)
					System.out.print(temp.getData() + "  ");
				else
					System.out.print(temp.getData() + "   ");
				
				temp = temp.getRight();
			}
			
			System.out.println();
			rowMarker = rowMarker.getDown();
			temp = rowMarker;
		}
		
		System.out.println("=====================================");
	} // end display
	
	public static void floodInitiate(int userInput) {
		Node temp = first;
		
		flood(userInput, temp);
	} // end flood
	
	public static void flood(int userInput, Node location) {
		Node temp = location;
		int originalData = temp.getData();
		
		if(temp != null) {
			temp.setData(userInput);
			
			if(temp.getUp() != null && temp.getUp().getData() == originalData) {
				flood(userInput, temp.getUp());
			}
			if(temp.getDown() != null && temp.getDown().getData() == originalData) {
				flood(userInput, temp.getDown());
			}
			if(temp.getLeft() != null && temp.getLeft().getData() == originalData) {
				flood(userInput, temp.getLeft());
			}
			if(temp.getRight() != null && temp.getRight().getData() == originalData) {
				flood(userInput, temp.getRight());
			}
		}
	} // end flood
	
} // end class Grid
