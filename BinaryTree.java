/* A binary tree is a collection of nodes in which each node is associated with
   up to two successor nodes, respectively called the left and right child. */

package classWork;

public class BinaryTree
{
	public static class Node
	{
		/* A node in a binary tree that has no children is called a leaf. */ 

		int value;
		Node left;
		Node right;

		//Constructor for leaf nodes.
		Node(int val)
		{
			value = val;
			left = null;
			right = null;
		}

		//Constructor for non-leaf nodes (parent)
		Node(int val, Node leftChild, Node rightChild)
		{
			value = val;
			left = leftChild;
			right = rightChild;
		}
	}


	/* Inorder traversal: traverse the left subtree, process 
	       the data at the root node, and then traverse the right subtree  */

	public static void inorder(Node btree)
	{   
		/* @param btree is the root */

		if (btree != null) ////////////////////////////
		{
			inorder(btree.left);
			System.out.print(btree.value + " ");
			inorder(btree.right);
		}
	}

	public static Node root = null;
	
	public static void main(String[] args)
	{
		/* Create binary tree and traverses it. */

		//Node root = null;  //Will be root of the binary tree.

		//Root
		Node aNode = new Node(10);
		root = aNode; 
		
		//Left side
		aNode.left = new Node(20);
		
		//Right side
		Node dNode = new Node(40);
		Node cNode = new Node(30, dNode, new Node(50));
		aNode.right = cNode;
		
		//Traversal
		System.out.print("Inorder traversal is: ");
		inorder(root);
		System.out.println();
	}
}

