package binary_search_Tree;

import java.util.*;
public class BinarySearchTree{
	int data;   //data value
	BinarySearchTree parentNode;  //points to the parent.
	BinarySearchTree leftNode;    //points to left child.
	BinarySearchTree rightNode;   //points to right child.	 

	static int numofElements=0;   //number of elements in the Tree.
	static BinarySearchTree rootNode; //root of the tree.

	public BinarySearchTree(){
		parentNode=null;
		leftNode=null;
		rightNode=null;
	}


	//function to add elements in the Tree.	
	public void add(int number){
		System.out.println("Inserting data : " + number);
		BinarySearchTree node = new BinarySearchTree();
		node.data=number;
		
		
		if(numofElements==0){
			rootNode=node;
		}
		else{
			BinarySearchTree temp = rootNode;
			while(temp!=null){
				if(temp.data<number){
					if(temp.rightNode==null){
						temp.rightNode=node;
						node.parentNode=temp;
						break;
					}
					else{
						temp=temp.rightNode;
						continue;
					}
				}
				if(temp.data>number){
					if(temp.leftNode==null){
						temp.leftNode=node;
						node.parentNode=temp;
						break;
					}
					else{
						temp=temp.leftNode;
						continue;
					}
				}
			}
		}
		numofElements++;
	}
	
	
	//function to display the tree. Pattern can be = InOrder, PreOrder, PostOrder Traversal, Level-Order Traversal.
	public void display(String pattern) throws Exception {
		System.out.print("Tree : \n");
		if(rootNode==null){
			throw new Exception("Empty tree!");
		}
		//InOrder Traversal
		if(pattern=="inOrder"){
			inOrderDisplay(rootNode);
			System.out.println("\n");
		}
		else{
			//PreOrder Traversal.
			if(pattern=="preOrder"){
				preOrderDisplay(rootNode);
				System.out.println("\n");
			}
			else{
				//PostOrder Traversal.
				postOrderDisplay(rootNode);
				System.out.println("\n");
			}
		}
	}				

	//function for InOrder Traversal of Tree.
	private BinarySearchTree inOrderDisplay(BinarySearchTree root){
		if(root==null){
			return root;
		}
		inOrderDisplay(root.leftNode);
		System.out.print(root.data + " ");
		inOrderDisplay(root.rightNode);
		return root;
	}

	//function for PreOrder Traversal of the Tree.
	private BinarySearchTree preOrderDisplay(BinarySearchTree root){
		if(root==null){
			return root;
		}
		System.out.print(root.data + " ");
		inOrderDisplay(root.leftNode);
		inOrderDisplay(root.rightNode);
		return root;
	}

	//function for PostOrder Traversal of the Tree.
	private BinarySearchTree postOrderDisplay(BinarySearchTree root){
		if(root==null){
			return root;
		}
		inOrderDisplay(root.leftNode);
		inOrderDisplay(root.rightNode);
		System.out.print(root.data + " ");
		return root;
	}

	//function to find specific data in the Tree.
	public boolean findNode(int number)throws Exception{
		if(rootNode==null){
			throw new Exception("Empty tree!");
		}
		BinarySearchTree temp = rootNode;
		boolean result=false;
		while(temp!=null){
			if(temp.data==number){
				result=true;
				break;
			}
			if(temp.data>number){
				temp=temp.leftNode;
				continue;
			}
			if(temp.data<number){
				temp=temp.rightNode;
				continue;
			}
		}
		if(result==false){
			return false;
		}
		else{
			return true;
		}
	}
}
		
	
