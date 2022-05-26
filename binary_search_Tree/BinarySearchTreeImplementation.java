package binary_search_tree;
import java.util.Scanner;  // Import the Scanner class

public class BinarySearchTreeImplementation extends BinarySearchTree{
		public static void main(String [] args){
			BinarySearchTree tree = new BinarySearchTree();

			// loop to scan 10 numbers
			for (int i = 0; i < 10; i++) {
				Scanner myObj = new Scanner(System.in);
				System.out.println("\nEnter Int");
				int number = myObj.nextInt();  
				tree.add(number);
			}
	
			tree.display();
	
			System.out.println();

			// method to show maximum value in the tree
			Node maxNode = tree.maxNode();
			System.out.println("Max value : " + maxNode.key);

			// method to show minimum value in the tree
			Node minNode = tree.minNode();
			System.out.println("Min value : " + minNode.key);
			
			Scanner myObj = new Scanner(System.in);
			
			// Scan to find the selected value
			System.out.println("\nEnter an integer to check does it exist: ");
			int number = myObj.nextInt();  
			//find number in the tree
			Node node1 = tree.find(number);

			if(number == node1.key){
				// if number that is entered == the node number from the tree, it will display that the number exist in the tree
				System.out.println("The number " + node1.key + " exist in the tree");
			}
			else{
				// if number that is entered != the node number from the tree, it will display that the number does not exist in the tree
				System.out.println("The number " + number +" does not exist in the tree");
			}

			// scan for user input on what number to delete from tree
			Scanner myObj1 = new Scanner(System.in);
			System.out.println("\nEnter Int to delete from the tree");
			int number2 = myObj1.nextInt();  
			// find the value in the tree
			Node del1 = tree.find(number2);

			// if number that is entered is in the tree, it will remove the value and display the tree after the deletion of value
			if(number2 == del1.key){
				tree.remove(number2);
				System.out.println(del1.key);
				tree.display();
			}
			else{
				// number does not exist in the tree
				System.out.println("The number " + number2 +" does not exist in the tree");	
			}

			}
		}
	
