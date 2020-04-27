package classWork;
import java.util.EmptyStackException;

public class StackGeneric <T>
{

	private T[] s; //body of stack
	private int top; 


	//Constructor
	public StackGeneric(int capacity)
	{
		s = (T[ ]) new Object [capacity]; //assigns size of array; Object will adjust to suit type T
	}



	//Checks if stack is empty
	public boolean empty()
	{ 
		return top == 0; 
	}

	
	
	//Adds value to top of stack
	public T push(T x) 
	{
		if (top == s.length)  
			throw new StackOverflowError(); //StackOverFlowException
		
		else
		{
			s[top] = x;
			top ++;  //moves up to next space
			
			return x;
		}         
	}


	
	//Removes and returns element from top
	public T pop()
	{
		if (empty())
			throw new EmptyStackException();
		
		else
		{
			T retVal = s[top-1]; //stores value to be returned
			
			s[top-1] = null;
			top--; //moves down to available space
			
			return retVal;
		}
	}


	public static void main(String [] arg)
	{
		StackGeneric <String> stack = new StackGeneric<String>(5);
		
		stack.push("George");
		stack.push("Washington");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());        
	}   
}

