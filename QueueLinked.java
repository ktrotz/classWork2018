package classWork;
import java.util.EmptyStackException;

public class QueueLinked 
{
	private class Node
	{
		String value;
		Node next;
		
		//Constructor
		Node(String val, Node n)
		{
			value = val; 
			next = n;
		}       
	}

	/* Out of class Node and into class QueueLinked */
	
	private Node front = null; 
	private Node rear = null;                                     

	
	
	//Adds value to end of queue
	public void enqueue(String s)
	{
		/* "Rear" moves up when adding an item but points to value and not space. */
		
		if (rear != null)
		{
			rear.next = new Node(s, null);
			rear = rear.next;
		}
		
		else
		{
			rear = new Node(s, null);
			front = rear;  //if queue was empty
		}
	}

	
	
	//Check if queue is empty
	public boolean empty()
	{
		return front == null;
	}

	
	
	//Returns value at front of queue
	public String peek()
	{
		if (empty())
			throw new EmptyStackException(); //EmptyQueueException
		
		else
			return front.value;        
	}

	
	
	//Removes and returns value at front 
	public String dequeue()
	{
		/* "Front" moves up when removing an item. */
		
		if (empty()) 
			throw new EmptyStackException(); //EmptyQueueException
		
		else
		{
			String value = front.value;
			
			front = front.next; //points front to next
			
			if (front == null) 
				rear = null;   
			
			return value;
		}
	}

	

	//Computes string representation of the list
	public String toString()
	{
		StringBuilder sBuilder = new StringBuilder();

		// Walk down the list and append all values
		Node p = front;
		while (p != null)
		{
			sBuilder.append(p.value + " ");
			p = p.next;
		}
		return sBuilder.toString();        
	}



	public static void main(String [] args)
	{
		QueueLinked queue = new QueueLinked();

		// Add 4 names
		String [ ] names = {"Alfonso", "Bob", "Carol", "Deborah"};
		System.out.println("Adding names: ");
		
		for (String s : names)
		{
			System.out.print(s + " ");
			queue.enqueue(s);         
		}

		System.out.println("\nState of queue is: ");
		System.out.println(queue);

		// Remove 2 names
		System.out.println("Removing 2 names.");
		queue.dequeue(); queue.dequeue();
		
		System.out.println("State of queue is: ");
		System.out.println(queue);

		// Add another name
		System.out.println("Adding the name Elaine:");
		queue.enqueue("Elaine");
		
		System.out.println("State of queue is: ");
		System.out.println(queue);      
	}
}
