/* The following code consist of Queue implemented by arrays.
 * A queue is a collection of items that is accessed in a first-in-first-out fashion.*/

package classWork;
import java.util.EmptyStackException;


public class QueueArray
{
	private String[ ] q; //holds queue elements
	
	private int front; //next item to be removed
	private int rear;  //next slot to fill
	private int size;  //number of items in queue   

	
	//Constructor
	QueueArray(int capacity)
	{
		q = new String[capacity]; //assigns size of array
		
		//Positions
		front = 0; 
		rear = 0;
		
		//Number of items in queue; necessary to check if full
		size = 0;
	}

	
	
	//Returns size of array
	public int capacity()
	{
		return q.length;
	}

	
	
	//Adds to end of queue
	public void enqueue(String s)
	{
		/* "Rear" moves up when adding an item. */
		
		if (size == q.length)
			throw new StackOverflowError();  //QueueOverFlowException
		
		else
		{
			size++;
			
			q[rear] = s;
			rear++; //moves to next available slot
			
			//If rear reaches last slot then it goes to fill the first
			if (rear == q.length) 
				rear = 0;           
		}
	}

	
	
	//Return value at front of queue
	public String peek()
	{
		if (empty())
			throw new EmptyStackException(); //EmptyQueueException
		
		else
			return q[front];
	}

	
	
	//Removes and returns at front of queue
	public String dequeue()
	{
		/* "Front" moves up when removing an item. */
		
		if (empty())
			throw new EmptyStackException(); //EmptyQueueException
		
		else
		{
			size--;
			
			String value = q[front]; //store value before removal
 
			q[front] = null;   //assigns array front to null  
			front++; //front moves up
			
				
			//If front reaches last slot then it goes back to the first
			if (front == q.length)
				front = 0; 

			return value;        
		}
	}

	
	
	//Checks if queue is empty
	public boolean empty()
	{
		return size == 0;
	}

	
	
	//Computes string representation of the list
	public String toString()
	{
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("front = " + front + "; ");
		sBuilder.append("rear = " + rear + "\n");
		for (int k = 0; k < q.length; k++)
		{
			if (q[k] != null)
				sBuilder.append(k + " " + q[k]);
			else 
				sBuilder.append(k + " ?");
			if (k != q.length - 1)
				sBuilder.append("\n");
		}
		return sBuilder.toString();     
	}    

	public static void main(String [] args)
	{    
		QueueArray queue = new QueueArray(4);
		
		System.out.println("Queue has capacity " + queue.capacity());

		
		//Add 4 names
		String[ ] names = {"Alfonso", "Bob", "Carol", "Deborah"};

		System.out.println("Adding names: ");
		
		for (String s : names)
		{
			System.out.print(s + " ");
			queue.enqueue(s);         
		}
		
		System.out.println("\nState of queue is: ");
		System.out.println(queue);

		
		//Remove 2 names
		System.out.println("Removing 2 names.");
		queue.dequeue(); 
		queue.dequeue(); 
		
		System.out.println("State of queue is: ");
		System.out.println(queue);

		
		//Add a name
		System.out.println("Adding the name Elaine:");
		queue.enqueue("Elaine");
		
		System.out.println("State of queue is: ");
		System.out.println(queue);       
	}    
}
