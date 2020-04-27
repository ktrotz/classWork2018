package classWork;

public class LinkedList2 
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
			//Call the other (sister) constructor.
			this(val, null);            
		}
	}

	
	/*Out of class Node and back to class LinkedList1*/
	
	private Node head;	
	private Node last;	


	//Constructor
	public LinkedList2()
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

		Node p = head; //Node p points to first element of list

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
			head = new Node(e);
			last = head;
		}

		else
		{
			//Add to end of existing list
			last.next = new Node(e);
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
			head = new Node(e, head); //head is successor
			
			
			if (last == null)
				last = head; //if list has only one element
			 
			return;
		}
		
		//Predecessor
		Node pred = head; 
		
		//Loops through and points to predecessor of position "index"
		for (int k = 1; k <= index - 1; k++)   //it ends at index-1 so pred.next wouldn't point to the index value
		{ 									   //if it started at 0 it would give adding to start as an option
			pred = pred.next;           
		}
		
		pred.next = new Node(e, pred.next);  //e becomes pred.next and successor is previous pred.next

		if (pred.next.next == null)
			last = pred.next;         
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

		
		String element;  //return value  
		
		
		if (index == 0)
		{
			element = head.value; //stores value before removal
			head = head.next;
			
			if (head == null)
				last = null;             
		}
		
		
		else
		{   //If position >= 1 then predecessor must be found
			
			Node pred = head;

			for (int k = 1; k <= index -1; k++) //it ends at index-1 so pred.next wouldn't point to the index value
			{
				pred = pred.next;
			}

			element = pred.next.value; //stores value before removal

			pred.next = pred.next.next;  

			if (pred.next == null)
				last = pred;              
		}
		
		return element; //returns removed element 
	}  

	/**
	        The remove method removes an element.
	        @param element The element to remove.
	        @return true if the remove succeeded, 
	        false otherwise.
	 */

	public boolean remove(String element)
	{
		if (isEmpty()) 
			return false;      
		
		
		if (element.equals(head.value)) //If element = head
		{
			// Removal of first item in the list
			head = head.next;
			
			if (head == null)
				last = null;  
			
			return true;
		}

		
		// Find the predecessor of the element to remove
		Node pred = head;
		
		while (pred.next != null && !pred.next.value.equals(element))
		{
			pred = pred.next;
		}

		// pred.next == null OR pred.next.value is element
		if (pred.next == null)
			return false;

		// pred.next.value  is element
		pred.next = pred.next.next;    

		// Check if pred is now last
		if (pred.next == null)
			last = pred;

		return true;       
	}

	public static void main(String [] args)
	{
		LinkedList2 ll = new LinkedList2();
		ll.add("Amy");
		ll.add("Bob");
		ll.add(0, "Al");
		ll.add(2, "Beth");
		ll.add(4, "Carol");
		System.out.println("The members of the list are:");
		System.out.print(ll);
	}
}

