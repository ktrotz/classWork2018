package classWork;

public class IntBubbleSort2 
{
	public static void main(String[] args)
	  { 
	    int array[] = {23, 10, 5, 14, 15}; 
	    
	    System.out.print("\nOriginal array: ");
		for(int x: array) //scans through each element of array
		{
			System.out.print(x + " ");
		}
	    
	    bubbleSort(array);
	    
	    System.out.print("\nSorted Array: ");
	    
	    for(int index = 0; index <= array.length - 1; index++)
	    {
	       System.out.print(array[index] + " ");
	    }
	  }
	  
	  public static void bubbleSort(int[] array)
	  {
	    int lastPos; //Position of last element
	    int index; 
	    int temp; //Used to swap element
	    int comp = 0;
	    int swap = 0;
	    
	    for(lastPos = array.length - 1; lastPos >= 0; lastPos--) //lastPos = array.length - 1; lastPos >= 0; lastPos--
	    {
	      for(index = 0; index <= lastPos - 1; index++) //stops when index = lastPos -1 instead of lastPos because 
	      {                                            //index and index + 1 must be swap later.
	        comp++;
	        
	        //Compare elements
	        if(array[index] > array[index + 1]) 
	        {
	          swap++;
	          
	          
	          //Swap values
	          temp = array[index]; //temp holds value 
	          array[index] = array[index + 1]; //first element assigned second value
	          array[index + 1] = temp; //second element assigned first value */
	        }
	      }
	    }

	    
	    System.out.println("\nComparisons: " + comp);
		System.out.println("Swaps: " + swap);
	    
	  }
	  
}
