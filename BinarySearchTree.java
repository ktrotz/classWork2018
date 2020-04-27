package classWork;

public class BinarySearchTree extends BinaryTree
{
	/* This class represents the result of removing   
	    a node from a binary tree. */
	
	private class RemovalResult
	{
		Node node;    //removed node
		Node tree;    //remaining tree

		//Constructor
		RemovalResult(Node node, Node tree)
		{
			this.node = node;
			this.tree = tree;
		}
	}


	
	//Adds value to search tree
	public boolean add(int x)
	{
		root = add(x, root); //call to private recursive method
		
		return true;
	}
	
		
	private Node add(int x, Node bstree)
	{
		/* @param bstree is the root of the tree */
		
		if (bstree == null)
			return new Node(x); //add root
		
		//Left subtree	
		if (x < bstree.value)		
			bstree.left = add(x, bstree.left); //add x and replace current left with result
		
		//Right subtree
		else
			bstree.right = add(x, bstree.right); //add x and replace current right with result
		
		return bstree; //return to add(int)
	}
	
	
	
	//Checks to see if value is in tree
	public boolean contains(int x)
	{
		return contains(x, root); //call to private recursive method
	}

	
	private boolean contains(int x, Node bstree)
	{
		/* @param x: search value
		 * @param bstree: root including subtrees */
		
		if (bstree == null)
			return false;
		
		if (x == bstree.value)
			return true; //returns root value
		
		//Left subtree
		if (x < bstree.value)
			return contains(x, bstree.left); //recursively look through left 
		
		//Right subtree
		else
			return contains(x, bstree.right); //recursively looks through right
	}
	
	

	//Removes a value from the tree
	public boolean remove(int x)
	{
		RemovalResult result = remove(root, x);  //call private method below
		
		if (result == null)
			return false; //not found
		
		else
			root = result.tree; //updates tree
			return true;
	}
	
	
	//Removes and returns value x and the resulting tree to method above
	private RemovalResult remove(Node bTree, int x)
	{
		if (bTree == null)
			return null; //not found
		
		
		//Left subtree
		if (x < bTree.value)
		{
			RemovalResult result = remove(bTree.left, x); //recursive search
			
			if (result == null)
				return null; //not found
			
			bTree.left = result.tree; //updates left
			result.tree = bTree; //updates root
			
			return result; //returns root and tree
		}
		
		
		//Right subtree
		if (x > bTree.value)
		{
			RemovalResult result = remove(bTree.right, x); //recursive call
			
			if (result == null)
				return null; //not found
			
			bTree.right = result.tree; //updates right
			result.tree = bTree; //updates root
			
			return result; //returns root and tree
		}
		
		
		/* The return values after here are returned to their recursive calls above */
		
		//If value x is the root and is a leaf
		if (bTree.right == null && bTree.left == null)
		{
			return new RemovalResult(bTree, null); //removes root
		}

		
		//If value x is root and had two children
		if (bTree.right != null && bTree.left != null)
		{			
			//Remove largest in left subtree
			RemovalResult remResult = removeLargest(bTree.left);
			
			//Make largest the root
			Node newRoot = remResult.node; 
			
			newRoot.left = remResult.tree; //left take result of bTree.left
			newRoot.right = bTree.right; //right remains same

			
			//Return new tree
			bTree.left = null;
			bTree.right = null;
			
			return new RemovalResult(bTree, newRoot); //newRoot becomes new bTree
		}
		
		
		//If x has one child
		Node node = bTree;
		Node tree;
		
		if (bTree.left != null)
			tree = bTree.left; 
		
		else
			tree = bTree.right;
		
		
		node.left = null;
		node.right = null;
		
		return new RemovalResult(node, tree); //moves the child "tree" to the parent "node" position
	}

	
	
	//Removes the largest node of the tree
	private RemovalResult removeLargest(Node bTree)
	{
		if (bTree == null)
			return null; //not found
		

		if (bTree.right == null)
		{
			/* Root is the largest */
			
			Node tree = bTree.left;
			
			bTree.left = null;
			
			return new RemovalResult(bTree, tree);
		}
		
		
		else
		{
			/*Largest node is the node on the farthest right */
			
			RemovalResult remResult = removeLargest(bTree.right); //searches
			
			bTree.right = remResult.tree; //updates right
			remResult.tree = bTree; //updates root
			
			return remResult; //returns root and tree 
		}
	}
}


