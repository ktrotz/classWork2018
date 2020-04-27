package classWork;

public class LinkedList
{
	/* The Node class represents a list node. */

	private class Node
	{
		String value;
		Node next;

		//Constructors of class Node
		Node(String val, Node n)
		{ 
			/*Is used when adding to start of list*/
			value = val;
			next = n;
		}

		Node(String val)
		{
			/*Is used when adding to end of list*/
			value = val;
			next = null;
		}
	}
	
	private Node head = null; //reference to first node in list

	
	//Constructor
	//Builds a linked list
	public LinkedList()
	{
		head = new Node("Debby");
		head.next = new Node("Elaine");
		head.next.next = new Node ("Fred");
		
		head = new Node ("Chuck", head); //(x,y) y is successor  

	
		String[ ] names = {"Bob", "Allan"};
		
 
		//Builds list: Allan Bob Chuck Debby Elaine Fred
		for (String s : names)
			head = new Node(s, head);
	} 

	
	//Traverse list and prints elements
	public void print()
	{
		Node ref = head; //reference to first element
		
		while (ref != null)
		{
			System.out.print(ref.value + " ");
			ref = ref.next;
		}    
	}

	

	//Main
	public static void main(String [] args)
	{
		LinkedList list = new LinkedList(); //class call
		
		System.out.println("The contents of the list are: ");
		list.print();
	}
}

