package binary_search_tree;
import java.util.Scanner;  // Import the Scanner class

public class BinarySearchTreeImplementation extends BinarySearchTree{
		public static void main(String [] args){
			BinarySearchTree tree = new BinarySearchTree();
			for (int i = 0; i < 10; i++) {
				Scanner myObj = new Scanner(System.in);
				System.out.println("\nEnter Int");
				int number = myObj.nextInt();  
				tree.add(number);
			}
	
			tree.display();
	
			System.out.println();
			Node maxNode = tree.maxNode();
			System.out.println("Max value : " + maxNode.key);
			Node minNode = tree.minNode();
			System.out.println("Min value : " + minNode.key);
			
			Scanner myObj = new Scanner(System.in);
			System.out.println("\nEnter Int");
			int number = myObj.nextInt();  
			Node node1 = tree.find(number);

			if(number == node1.key){
				System.out.println("The number" + node1.key + "exist");
			}
			else{
				System.out.println("The number " + number +" does not exist");
			}

			

		}
	}
