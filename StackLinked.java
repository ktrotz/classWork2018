/* The following code consists of Stacks implemented by Linked lists.
 * The Linked Stack class will have a field "top" that points to the item at the top of the stack not the space.
 * Top also serves as the head of the list.
 */

package classWork;
import java.util.EmptyStackException;

public class StackLinked
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

	
	/*Out of class Node and into class StackLinked*/
	
	private Node top = null;  // Top of the stack

	
	//Checks if stack is empty
	public boolean empty()
	{
		return top == null; //true
	}

	
	
	//Adds value to stack to end
	public void push(String s)
	{
		top = new Node(s, top); //top points to s
	}

	
	
	//Removes value from stack and returns it
	public String pop()
	{
		if (empty())
			throw new EmptyStackException();
		
		else
		{            
			String retValue = top.value;
			top = top.next; //points top variable to .next value, deleting the previous top 
			
			return retValue;
		}         
	} 

	
	
	//Returns top value of stack
	public String peek()
	{
		if (empty())
			throw new EmptyStackException();
		
		else
			return top.value;
	}

	
	
	//Computes string representation of the list
	public String toString()
	{
		StringBuilder sBuilder = new StringBuilder();
		Node p = top;
		while (p != null)
		{
			sBuilder.append(p.value);            
			p = p.next;
			if (p != null)
				sBuilder.append("\n");
		}
		return sBuilder.toString();
	}


public static void main(String[ ] args)   
{
	StackLinked stack = new StackLinked();
	
	System.out.println("Pushing: Amy Bob Chuck");
	System.out.println("Contents of Stack:");
	
	stack.push("Amy");
	stack.push("Bob");
	stack.push("Chuck");
	
	System.out.println(stack); 
	
	String name = stack.pop();
	System.out.println("Popped: " + name);
	
	System.out.println("Contents of Stack:");
	System.out.println(stack);        
}    
}

