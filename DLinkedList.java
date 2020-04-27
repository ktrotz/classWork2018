/* The following code is Doubly Linked. A doubly linked list makes it easy to move from any
 * node to its successor or predecessor. 
 * 
 * A singly linked list is circularly linked if the successor of the last node is the first.
 * A doubly linked list is circularly linked if the successor of the last node is the first,
 * and the predecessor of the first node is the last.  */

package classWork;

public class DLinkedList
{
	/**
	       The Node class stores a list element
	        and a reference to the next node.
	 */
	
	private class Node
	{
		String value; //value of a list element
		Node next;   //next node in the list
		Node prev;   //previous element in the list

		
		//Constructors of class Node
		Node(String val, Node n, Node p)
		{
			value = val;
			next = n;
			prev = p;
		}

		Node(String val)
		{
			// Just call the other (sister) constructor
			this(val, null, null);            
		}
	}
	
	
	/* Out of class Node and back to class DLinkedList*/

	private Node head;
	private Node last;


	//Constructor
	public DLinkedList()
	{
		head = null;
		last = null;        
	}
	

	//Points first element to null
	public boolean isEmpty()
	{        
		return head == null;
	}

	
	
	//Returns size of list
	public int size()
	{
		int count = 0;
		
		Node p = head; //p points to first element of list
		
		while (p != null)
		{
			count ++;
			p = p.next;
		}
		
		return count;
	}

	
	
	//Adds to end of list
	public void add(String e)
	{
		if (isEmpty()) 
		{
			last = new Node(e);
			head = last;
		}
		
		else
		{
			//Add to end of existing list
			last.next = new Node(e, null, last); //(value, next, prev)
			last = last.next;         
		}      
	}

	
	
	//Adds element 'e' to position 'index'
	public void add(int index, String e)
	{
		if (index < 0  || index > size()) 
		{
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}

		
		if (index == 0)
		{
			//New element added to start
			Node p = head;  //old first
			
			head = new Node(e, p, null); //(value, next, prev)
			
			
			if (p != null)
				p.prev = head; //the concept is understood but always remember to assign it with code  
			
			if (last == null)
				last = head; //if list only has one element
			
			return;
		}
		
		//Predecessor
		Node pred = head;
		
		//Loops through and points to predecessor of position "index"
		for (int k = 1; k <= index - 1; k++)    //it starts on 1 so pred.next wouldn't point to the index value   
		{										//if it started at 0 it would give adding to start as an option
			pred = pred.next;           
		}

		
		Node succ = pred.next; //successor of "pred" which is actually position "index"
		
		Node middle = new Node(e, succ, pred); //remember succ and pred are pointers to previous values
		
		pred.next = middle; //the concept is understood but always remember to assign it with code  
		
		
		//If successor now points to nothing
		if (succ == null)             
			last = middle;   
		
		else            
			succ.prev = middle;                     
	}


	
	//Computes string representation of the list
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		//Use p to walk down the linked list
		Node p = head;
		
		while (p != null)
		{
			sb.append(p.value + "\n"); //updates value of sb
			p = p.next;
		}      
		
		return sb.toString(); 
	}
	
	

	//Removes element at position "index"
	public String remove(int index)
	{
		if (index < 0 || index >= size())  
		{
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}            

		
		//Locate the node targeted for removal
		Node target = head;  
		
		for (int k = 1; k <= index; k++) //points target to "index" 
			target = target.next;

		String element = target.value;	//element to return
		
		
		//Point before removal
		Node pred = target.prev;      
		Node succ = target.next; 
		

		//Points predecessor to successor
		if (pred == null)    
			head = succ; //only head has no prev so it now points to target.next
		
		else
			pred.next = succ; 
		
		
		//Points successor to predecessor
		if (succ == null)
			last = pred; //only last has no succ 
		
		else
			succ.prev = pred;

		return element;        
	}

	/**
	       The remove method removes an element from the list.
	        @param element The element to remove.
	        @return true if the element was removed, false otherwise.
	 */

	public boolean remove(String element)
	{
		if (isEmpty()) 
			return false;      

		// Locate the node targeted for removal
		Node target = head;  
		
		while (target != null && !element.equals(target.value))
			target = target.next;

		if (target == null)
			return false;       

		Node pred = target.prev;        // Node before the target
		Node succ = target.next;        // Node after the target

		// Route forward and back pointers around
		// the node to be removed
		if (pred == null)       
			head = succ;
		else
			pred.next = succ;

		if (succ == null)
			last = pred;
		else
			succ.prev = pred;      

		return true;       
	}

	public static void main(String [] args)
	{
		DLinkedList ll = new DLinkedList();
		ll.add("Amy");
		ll.add("Bob");
		ll.add(0, "Al");
		ll.add(2, "Beth");
		ll.add(4, "Carol");
		System.out.println("The elements of the list are:");
		System.out.println(ll);
	}
} 

