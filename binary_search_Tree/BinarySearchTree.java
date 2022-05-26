package binary_search_tree;

import java.util.Scanner;

public class BinarySearchTree{
	static class Node{
		int keyValue;     //data value
		Node parentNode; //points to the parent node.
		Node leftNode;   //points to the left child.
		Node rightNode;  //points to the right child.
		
		public Node(int data){
			this.keyValue=data;
			this.parentNode=null;
			this.leftNode=null;
			this.rightNode=null;
		}

	}

	static Node root;   //root of the tree.

	public BinarySearchTree(){
		root=null;
	}

	//function to find specific data elements in the tree.
	public static Node findValue(int data){
		// root number
		Node top=root;
		Node prevNum=null;
		
		while(top!=null){
			prevNum=top;
			
			// find the number according to the sequence of the tree values
			if(top.keyValue==data){
				return prevNum;
			}
			// if the data is less than the node, search from the left node
			if(top.keyValue>data){
				top=top.leftNode;
			}
			// if the data is more than the node, search from the right node
			else{
				top=top.rightNode;
			}
		}
		return prevNum;
	}

	//function to add elements in the tree.
	public static void addValue(int data){
		// to preview the insertion of data
		System.out.println("Inserting data : " + data);
		Node node = new Node(data);
		Node selectedNode = findValue(data);
		if(selectedNode==null){
			root=node;
			return;
		}
	
		node.parentNode=selectedNode;
		// if the new node is more than the root, it will move to the right node
		if(node.keyValue>selectedNode.keyValue){
			selectedNode.rightNode=node;
		}
		else{
			// if the new node is less than the root, it will move to the left node
			selectedNode.leftNode=node;
		}
	}


	//function to find the next greater element from the given data value.
	public static Node nextValue(int data){
		System.out.println("Find Next of : " + data);
		if(root==null){
			return null;
		}
		
		Node node = findValue(data);
		if(node.rightNode!=null){
			return leftDecesdant(node.rightNode);
		}
		else{
			return rightAncestor(node);
		}
	}

	//function to find leftmost node.
	private static Node leftDecesdant(Node node){
		Node top=node;
		while(top.leftNode!=null){
			top=top.leftNode;
		}
		return top;
	}

	//function to find the parent node with data value greater than the given node data value.	
	private static Node rightAncestor(Node node){
		Node top=node.parentNode;
		while(top!=null){
			if(top.keyValue>node.keyValue){
				break;
			}
			top=top.parentNode;
		}
		if(top==null){
			System.out.println("Max Element");
			return node;
		}
		else{
			return top;
		}
	}
	
	// function to remove a node from the tree
	protected static Node removeValue(int data){
		// preview of what to remove
		System.out.println("Remove : " + data);
		// find the node
		Node node = findValue(data);
		// if there is no node on the right side of the tree
		if(node.rightNode==null){
			if(root==node){
				root=node.leftNode;
				return node;
			}
			if(node.parentNode.leftNode==node){
				node.parentNode.leftNode=node.leftNode;
			}
			else{
				node.parentNode.rightNode=node.leftNode;
			}
			return node;
		}
		// move the the left side of the tree
		else{
			Node top = nextValue(data);
			node.keyValue=top.keyValue;
			if(top.parentNode.leftNode==top){
				top.parentNode.leftNode=top.rightNode;
			}
			if(top.parentNode.rightNode==top){
				top.parentNode.rightNode=top.rightNode;
			}
		}
		return node;
	}

	//function to find the max data value in the tree.
	// find the most right node in the tree
	public static Node maxNumber(){
		if(root==null){
			return null;
		}
		Node top=root;
		while(top.rightNode!=null){
			top=top.rightNode;
		}
		return top;
	}

	//function to find the min data value in the tree.
	// find the most left node in the tree
	public static Node minNumber(){
		if(root==null){
			return null;
		}
		Node top = root;
		while(top.leftNode!=null){
			top=top.leftNode;
		}
		return top;
	}

	//function for InOrder Traversal of the tree.
	private static void inorderTraversal(Node rootNode){
		if(rootNode==null){
			return;
		}
		// the formula for inorder is left, node, and right
		inorderTraversal(rootNode.leftNode);
		System.out.print(rootNode.keyValue + " ");
		inorderTraversal(rootNode.rightNode);
	}

	//function for PreOrder Traversal of the tree.
	private static void preorderTraversal(Node rootNode){
		if(rootNode==null){
			return;
		}
		// the formula for preorder is node, left, and right
		System.out.print(rootNode.keyValue + " " );
		preorderTraversal(rootNode.leftNode);
		preorderTraversal(rootNode.rightNode);
	}

	//function for  PostOrder Traversal of the Tree.
	private static void postorderTraversal(Node rootNode){
		if(rootNode==null){
			return;
		}
		// the formula for postorder is left, right and node
		postorderTraversal(rootNode.leftNode);
		postorderTraversal(rootNode.rightNode);
		System.out.print(rootNode.keyValue + " ");
	}

	//function to display the tree.
	public static void display(){
		System.out.println();
		System.out.println("Inorder Traversal:");
		inorderTraversal(root);

		System.out.println();
		System.out.println("\nPreOrder Traversal:");
		preorderTraversal(root);

		System.out.println();
		System.out.println("\nPostOrder Traversal:");
		postorderTraversal(root);

		System.out.println("\n");
	}

}

		

		
		
			
			

			
			

		
		






























							