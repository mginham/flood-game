package codes;

import java.util.Scanner;

public class Main {
	
	public static int errorTrap() {
		Scanner input = new Scanner(System.in);
		boolean valid = true;
		int userInput = 0;
		
		do {
			valid = true;
			
			try{
				userInput = input.nextInt();
			}
			catch(Exception e) {
				input.next();
				valid = false;
				System.out.println("Invalid input. Please try again");
			}
		} while (!valid);
		
		return userInput;
	} // end
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int userInput = 0;
		
		Grid board = new Grid(10);
		
		do {
			board.display();
			
			System.out.print("Input: ");
			userInput = errorTrap();
			System.out.println();
			
			Grid.floodInitiate(userInput);
		} while(userInput != 0);
		
		
	} // end main

} // end class Main
