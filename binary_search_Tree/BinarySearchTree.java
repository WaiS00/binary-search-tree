//Program to implement BinarySearchTree.
package binary_search_tree;

import java.util.Scanner;

public class BinarySearchTree{
	static class Node{
		int key;     //data value
		Node parent; //points to the parent node.
		Node left;   //points to the right child.
		Node right;  //points to the left child.
		
		public Node(int data){
			this.key=data;
			this.parent=null;
			this.left=null;
			this.right=null;
		}

	}

	static Node root;   //root of the tree.

	public BinarySearchTree(){
		root=null;
	}

	//function to find specific data elements in the tree.
	public static Node find(int data){
		// root number
		Node temp=root;
		Node prev=null;
		
		while(temp!=null){
			prev=temp;
			
			// find the number according to the sequence of the tree values
			if(temp.key==data){
				return prev;
			}
			// if the data is less than the node, search from the left node
			if(temp.key>data){
				temp=temp.left;
			}
			// if the data is more than the node, search from the right node
			else{
				temp=temp.right;
			}
		}
		return prev;
	}

	//function to add elements in the tree.
	public static void add(int data){
		// to preview the insertion of data
		System.out.println("Inserting data : " + data);
		Node node = new Node(data);
		Node positionNode = find(data);
		if(positionNode==null){
			root=node;
			return;
		}
	
		node.parent=positionNode;
		// if the new node is more than the root, it will move to the right node
		if(node.key>positionNode.key){
			positionNode.right=node;
		}
		else{
		// if the new node is less than the root, it will move to the left node
			positionNode.left=node;
		}
	}


	//function to find the next greater element from the given data value.
	public static Node next(int data){
		System.out.println("Find Next of : " + data);
		if(root==null){
			return null;
		}
		
		Node node = find(data);
		if(node.right!=null){
			return leftDecesdant(node.right);
		}
		else{
			return rightAncestor(node);
		}
	}

	//function to find leftmost node.
	private static Node leftDecesdant(Node node){
		Node temp=node;
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp;
	}

	//function to find the parent node with data value greater than the given node data value.	
	private static Node rightAncestor(Node node){
		Node temp=node.parent;
		while(temp!=null){
			if(temp.key>node.key){
				break;
			}
			temp=temp.parent;
		}
		if(temp==null){
			System.out.println("Max Element");
			return node;
		}
		else{
			return temp;
		}
	}
	
	// function to remove a node from the tree
	protected static Node remove(int data){
		// preview of what to remove
		System.out.println("Remove : " + data);
		// find the node
		Node node = find(data);
		// if there is no node on the right side of the tree
		if(node.right==null){
			if(root==node){
				root=node.left;
				return node;
			}
			if(node.parent.left==node){
				node.parent.left=node.left;
			}
			else{
				node.parent.right=node.left;
			}
			return node;
		}
		// move the the left side of the tree
		else{
			Node temp = next(data);
			node.key=temp.key;
			if(temp.parent.left==temp){
				temp.parent.left=temp.right;
			}
			if(temp.parent.right==temp){
				temp.parent.right=temp.right;
			}
		}
		return node;
	}

	//function to find the max data value in the tree.
	// find the most right node in the tree
	public static Node maxNode(){
		if(root==null){
			return null;
		}
		Node temp=root;
		while(temp.right!=null){
			temp=temp.right;
		}
		return temp;
	}

	//function to find the min data value in the tree.
	// find the most left node in the tree
	public static Node minNode(){
		if(root==null){
			return null;
		}
		Node temp = root;
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp;
	}

	//function for InOrder Traversal of the tree.
	private static void inorderTraversal(Node rootNode){
		if(rootNode==null){
			return;
		}
		// the formula for inorder is left, node, and right
		inorderTraversal(rootNode.left);
		System.out.print(rootNode.key + " ");
		inorderTraversal(rootNode.right);
	}

	//function for PreOrder Traversal of the tree.
	private static void preorderTraversal(Node rootNode){
		if(rootNode==null){
			return;
		}
		// the formula for preorder is node, left, and right
		System.out.print(rootNode.key + " " );
		preorderTraversal(rootNode.left);
		preorderTraversal(rootNode.right);
	}

	//function for  PostOrder Traversal of the Tree.
	private static void postorderTraversal(Node rootNode){
		if(rootNode==null){
			return;
		}
		// the formula for postorder is left, right and node
		postorderTraversal(rootNode.left);
		postorderTraversal(rootNode.right);
		System.out.print(rootNode.key + " ");
	}

	//function to display the tree.
	public static void display(){
		System.out.println();
		System.out.println("Inorder Traversal");
		inorderTraversal(root);

		System.out.println();
		System.out.println("\nPreOrder Traversal");
		preorderTraversal(root);

		System.out.println();
		System.out.println("\nPostOrder Traversal");
		postorderTraversal(root);

		System.out.println();
	}

}

		

		
		
			
			

			
			

		
		






























							