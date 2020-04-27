/* The smallest value in the array is located and moved to position 0.
 * Then, the next smallest value is located and moved to position 1. 
 * This process continues until all of the elements have been placed in their proper order. */

package classWork;

public class IntSelectionSort
{
	     /**
	        The selectionSort method performs a selection sort on an
	       int array. The array is sorted in ascending order.
	       @param array The array to sort.
	     */
	 
	    public static void selectionSort(int[] array)
	     {
	        int startScan;	// Starting position of the scan
	        int index;    	// To hold a subscript value
	        int minIndex; 	// Element with smallest value in the scan
	        int minValue; 	// The smallest value found in the scan
	 
	        // The outer loop iterates once for each element in the
	        // array. The startScan variable marks the position where
	        // the scan should begin.
	        for (startScan = 0; startScan < (array.length-1); startScan++)
	        {
	           // Assume the first element in the scannable area
	           // is the smallest value.
	           minIndex = startScan;
	           minValue = array[startScan];
	           
	           // Scan the array, starting at the 2nd element in
	           // the scannable area. We are looking for the smallest
	           // value in the scannable area. 
	           for(index = startScan + 1; index < array.length; index++)
	           {
	              if (array[index] < minValue)
	              {
	                 minValue = array[index];
	                minIndex = index;
	              }
	           }
	 
	           // Swap the element with the smallest value 
	           // with the first element in the scannable area.
	           array[minIndex] = array[startScan];
	           array[startScan] = minValue;
	        }
	     }
	 }
	
	     public static void main(String[] args)
	     {
	        // Create an int array with test values.
	       int[] values = { 5, 1, 3, 6, 4, 2 };
	        
	        // Display the array's contents.
	       System.out.println("Original order:");
	        for (int element : values)
	           System.out.print(element + " ");
	        
	        // Sort the array.
	       IntSelectionSorter.selectionSort(values);
	 
	        // Display the array's contents.
	       System.out.println("\nSorted order:");
	        for (int element : values)
	           System.out.print(element + " ");
	           
	        System.out.println();
	     }
	  }
}