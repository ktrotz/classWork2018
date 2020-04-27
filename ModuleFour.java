
/* The program should operate as follows:
    1. Start, and prompt the user for the name of the data file from which to read the instructions.
     
    2. Open the data file and read in the instructions, line by line
  
    3. Follow the instructions on each line, being sure to check for errors in the applicable cases.
       The values in the add instructions are integers.
    
    4. The program should exit either when the Exit (X) instruction is seen, or the end of the file is detected. 
	
	Source: Starting Out with Java: From Control Structures through Data Structures, 3rd Edition by Gaddis and Muganda
   		    Chapters 4.10, 20.1, 20.2
   		   
    Done by: Kimberley Trotz
    Date: 12/01/17              */


package classWork;
import java.util.Scanner;  // Needed for Scanner class
import java.io.*;          // Needed for File class and IOException

public class ModuleFour 
{
	private class Node
	{
		int value;
		Node next;
		

		//Constructors of class Node
		Node(int val, Node n) //add to start
		{ 
			value = val;
			next = n;
		}

		Node(int val) //add to end
		{
			value = val;
			next = null;
		}
	}
	
	
	
	/*Out of class Node and back to class ModuleFour*/
	
	private Node head;	
	private Node last;	


	//Constructor
	public ModuleFour()
	{
		head = null;
		last = null;        
	}

	

	//Points first element to null
	public boolean isEmpty()
	{        
		return head == null;       
	}
	

	//Add to start of list
	public void addHead(int index, int e)
	{	
		if (index == 0)
		{
			//New element added to start
			head = new Node(e, head); 
			
		
			if (last == null)
				last = head; //if list has only one element
			 
			return;
		}
	}
	

	//Adds to end of list 
	public void addLast(int e)
	{
		if (isEmpty()) 
		{
			head = new Node(e);
			last = head;
		}

		else
		{
			last.next = new Node(e); //add to end of existing list
			last = last.next;
		}      
	}

	
	//Remove first element
	public int removeHead(int index)
	{		
		int element = 0;  //return value  
		
		if(isEmpty())
		{
			System.out.println("List is empty");
			return -1;
		}

		if (index == 0)
		{
			element = head.value; //stores value before removal
			
			head = head.next;

			if (head == null)
				last = null; 
		}
		
		return element; //returns removed element 
	}  


	//Remove last element
	public int removeLast(int e)
	{
		int element;

		if (isEmpty()) 
		{
			System.out.println("List is empty");
			return -1;
		}


		else
		{
			//Find the predecessor of last and point it to null
			Node pred = head;

			while (pred.next != null && pred.next != last)
			{
				pred = pred.next;
			}

			element = pred.next.value;

			pred.next = pred.next.next;

			if(pred.next == null)
				last = pred;
			
			return element;
		}    
		
		
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




	public static void main(String[] args) throws IOException
	{
		String filename;

		Scanner input = new Scanner(System.in);

		//Get the file's name
		System.out.print("\n\nPlease enter the path and name for the input file:  ");
		filename = input.nextLine();
		
		
		//Find and open the file onto console
		File file = new File(filename);

		if (!file.exists())
		{
			System.out.println("The file " + filename + " is not found.");
			System.exit(0);
		}
		
		System.out.println("\nUsing the file " + filename + " for input.");

		Scanner inputFile = new Scanner(file);

		ModuleFour linkedList = new ModuleFour();
		
		
		int I = 1; //initialize count
		
		//Read file and follow instructions
		while (inputFile.hasNext())
		{					
			//Read line by line
			char c = inputFile.next().charAt(0);
			int i = inputFile.nextInt();

			
			//Initialize
			if(c == 'I') //if (count == 1)
			{
				if(I > 1)
				{	
					System.out.println("\nProcessing " + c);
					System.out.println("Can not initialize more than once.");
				}

				if(I == 1)
				{
					System.out.println("\nProcessing " + c);

					linkedList.isEmpty();
					System.out.println("The list has been initialized.");
				}

				I++;
			}
			

			//Add Beginning
			if(c == 'B')
			{
				System.out.println("\nProcessing " + c);

				linkedList.addHead(0, i);
				System.out.println("Added the value " + i + " to a node at the beginning of the list.");
			}


			//Add End
			if(c == 'C')
			{
				System.out.println("\nProcessing " + c);

				linkedList.addLast(i);
				System.out.println("Added the value " + i + " to a node at the end of the list.");
			}


			//Traverse
			if(c == 'T')
			{
				System.out.println("\nProcessing " + c);
				
				System.out.print("Traversing the list and it contains the following values: ");
				linkedList.print();
				
				System.out.println();
			}
			
			
			//Remove Beginning
			if(c == 'R')
			{
				System.out.println("\nProcessing " + c);
				
				int n = linkedList.removeHead(0);
				
				if(n == -1)
					continue;
				
				System.out.println("Removed the node with value " + i + " from the beginning of the list.");
			}
			
			
			//Remove End
			if(c == 'S')
			{
				System.out.println("\nProcessing " + c);
				
				int n = linkedList.removeLast(0);
				
				if (n == -1)
					continue;
				
				System.out.println("Removed the node with value " + i + " from the end of the list.");
			}
	
			
			//Exit
			if(c == 'X')
			{
				System.out.println("\nProcessing " + c);
				
				System.out.println("Exiting...");
				inputFile.close(); //close file
				System.exit(0);
			}
		}
	}
}


