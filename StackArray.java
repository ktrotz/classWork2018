/* The following code consist of Stacks implemented by arrays.
   A stack is a collection of items that allows addition and removal of items in a last-in-first-out manner.
   Variable "top" becomes the space of the next value to be added. */

package classWork;
import java.util.EmptyStackException;


public class StackArray
{
	private int[] s; //holds stack elements
	private int top; //pointer to next space

	
	//Constructor
	public StackArray (int capacity)
	{
		s = new int[capacity]; //assigns array a size
		top = 0;
	}

	
	//Checks if stack is empty
	public boolean empty() 
	{ 
		return top == 0; //true
	}

	
	
	//Adds value to stack
	public void push(int x) 
	{
		if (top == s.length)  
			throw new StackOverflowError(); //StackOverFlowException
		
		else
		{
			s[top] = x;
			top ++;   //moves up to next space        
		}         
	}

	
	
	//Removes and returns element from stack top
	public int pop()
	{
		if (empty())
			throw new EmptyStackException();
		
		else
		{
			top--; //moves down to value ////////
			return s[top];
		}
	}


	
	//Returns value at top of stack
	int peek()
	{
		if (empty())
			throw new EmptyStackException();
		
		else
		{
			return s[top-1];
		}
	}



public static void main(String [] arg)
{
	StackArray stack = new StackArray(5);
	
	System.out.println("Pushing 10 20 onto the stack.");
	
	stack.push(10);
	stack.push(20);
	
	System.out.println("Value at top of the stack is " + stack.peek());
	
	System.out.println("Popping and printing all values:");
	
	while (!stack.empty())
		System.out.print(stack.pop() + " ");            
}
}