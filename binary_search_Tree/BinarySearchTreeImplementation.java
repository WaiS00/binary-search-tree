package binary_search_Tree;
import java.util.Scanner;  // Import the Scanner class

public class BinarySearchTreeImplementation{
	public static void main(String [] args){
		BinarySearchTree tree = new BinarySearchTree();
		try{

			for (int i = 0; i < 10; i++) {
			Scanner myObj = new Scanner(System.in);
			System.out.println("\nEnter Int");
			int number = myObj.nextInt();  
			tree.add(number);
			}

			System.out.println("\nFind 10 : " + tree.findNode(10));
			
			System.out.println("\nInOrder");
			tree.display("inOrder");
			
			System.out.println("PreOrder");
			tree.display("preOrder");
			
			System.out.println("PostOrder");
			tree.display("postOrder");
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}