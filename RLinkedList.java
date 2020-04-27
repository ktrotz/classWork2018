/* This is a Recursive Linked List */

package classWork;

public class RLinkedList 
{	     
	private class Node
	{
		String value;   
		Node next;      


		//Constructors of class Node
		Node(String val, Node n)
		{
			value = val;
			next = n;
		} 

		Node(String val)
		{
			//Call the other (sister) constructor
			this(val, null);            
		}
	}


	/*Out of class Node and into class RLinkedList */

	private Node head; 


	//Constructor
	public RLinkedList()
	{
		head = null;           
	}



	//Points first element to null
	public boolean isEmpty()
	{        
		return head == null;
	}


	
	//Returns size of list
	public int size()
	{       
		return size(head);   //method call 
	}

	
	private int size(Node list)
	{
		if (list == null)   
			return 0;

		else 
			return size(list.next) + 1;  //recursive call   
	}

	
	
	//Adds to end of list
	public void add(String e)
	{
		//Replace first with result of adding e to first 
		head = add(e, head); //method call
	}
	

	private Node add(String e, Node list)
	{
		if (list == null)
		{
			//Base case
			return new Node(e);
		}
		
		else
		{
			// Add e to the end of the tail and use
			// the result to replace the tail
			list.next = add(e, list.next);
			return list;
		}        
	}

	/**
	        The add method adds an element e at place index
	        in this linked list.
	        @param index The place in the list to add an element.
	        @param e The element to add this the linked list.
	        @exception IndexOutOfBoundsException When index is 
	                   out of bounds.  
	 */

	public void add(int index, String e)
	{
		// Replace first with the result of adding
		// e at index in first
		head = add(index, e, head);        
	}

	/**
	        This add method adds an element at an index in a list.
	        @param e The element to add to the list.
	        @param index The index at which to add the element.
	        @param list The list to add e to.
	        @return The list resulting from adding e.
	       @exception IndexOutOfBoundsException When index is 
	                   out of bounds.  
	 */

	private Node add(int index, String e, Node list)
	{
		if (index < 0  || index > size()) 
		{
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}         
		if (index == 0)        
			return new Node(e, list);        

		// 0 < index and index <= size so list is not empty
		// Replace the tail with result of adding e at index - 1
		// in the tail
		list.next = add(index-1, e, list.next);        
		return list;     
	}

	/**
	        The toString method computes the string
	       representation of the list.
	        @return The string representation of the linked list.
	 */

	public String toString()
	{
		StringBuilder strBuilder = new StringBuilder();

		// Use p to walk down the linked list
		Node p = head;
		while (p != null)
		{
			strBuilder.append(p.value + "\n"); 
			p = p.next;
		}      
		return strBuilder.toString(); 
	} 

	/**
	        The RemovalResult class describes the results of
	        removing a node from a linked list.
	 */

	private class RemovalResult
	{
		Node node;	// The node removed from the list
		Node list;	// The list remaining after the removal
		RemovalResult(Node remNode, Node remList)
		{
			node = remNode;
			list = remList;
		}
	}     

	/**
	        The remove method removes the element at an index.
	        @param index The index of the element to remove. 
	        @return The element removed.  
	        @exception IndexOutOfBoundsException When index is 
	                   out of bounds.     
	 */

	public String remove(int index)
	{    
		// Pass the job on to the recursive version
		RemovalResult  remRes = remove(index, head);     
		String element = remRes.node.value;  // Element to return
		head= remRes.list;                 // Remaining list
		return element;      
	}  

	/**
	        The private remove method recursively removes 
	        the node at the given index from a list.
	       @param index The position of the node to remove.
	     @param list The list from which to remove a node.
	        @return The result of removing the node from the list.
	        @exception IndexOutOfBoundsException When index is 
	                   out of bounds.  
	 */
	private RemovalResult remove(int index, Node list)
	{
		if (index < 0 || index >= size())
		{  
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}

		if (index == 0)
		{
			// Remove the first node on list
			RemovalResult remRes;
			remRes = new RemovalResult(list, list.next);
			list.next = null;
			return remRes;           
		}  

		// Recursively remove the element at index-1 in the tail
		RemovalResult remRes;
		remRes = remove(index-1, list.next);

		// Replace the tail with the results and return
		// after modifying the list part of RemovalResult
		list.next = remRes.list;    
		remRes.list = list;
		return remRes;
	}

	/**
	        The remove method removes a given 
	        element from linked list.
	 */

	public boolean remove(String e)
	{
		RemovalResult remRes;
		remRes = remove(e, head);

		// Replace the list by the results of the removal
		head = remRes.list;   
		if (remRes.node != null)
			return true;
		else 
			return false;
	}

	/**
	        The remove method recursively removes a 
	        node containing a given element from 
	        a specified list.
	        @param element The element to remove.
	        @param list The list to remove from.
	        @return the list containing
	 */

	private RemovalResult remove(String e, Node list)
	{
		if (list == null)
			return new RemovalResult(null, null);

		// Is the first node on list the target of the removal?
		if (list.value.equals(e)) 
		{
			RemovalResult remRes;
			remRes = new RemovalResult(list, list.next);
			list.next = null;
			return remRes;            
		}

		// Node to be removed is after the first node on list
		// Recursively remove it from the tail
		RemovalResult remRes;
		remRes = remove(e, list.next);

		list.next = remRes.list;
		remRes.list = list;
		return remRes;          
	}    

	public static void main(String [] args)
	{
		RLinkedList ll = new RLinkedList();
		ll.add("Amy");
		ll.add("Bob");
		ll.add(0, "Al");
		ll.add(2, "Beth");
		ll.add(4, "Carol");
		System.out.println("The members of the list are:");
		System.out.print(ll);
	}
}

