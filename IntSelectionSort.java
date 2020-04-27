/* The smallest value in the array is located and moved to position 0.
 * Then, the next smallest value is located and moved to position 1. 
 * This process continues until all of the elements have been placed in their proper order. */

package classWork;

public class IntSelectionSort
{
	public static void selectionSort(int[] array)
	{
		int startScan;	//starting position of the scan (0)
		int index;    	//hold subscript value
		int minIndex; 	//smallest position
		int minValue; 	//smallest value

		// The outer loop iterates once for each element in the	
		for (startScan = 0; startScan < (array.length-1); startScan++)
		{
			//Assume first is smallest
			minIndex = startScan;
			minValue = array[startScan];

			//Compare elements
			for(index = startScan + 1; index < array.length; index++) //scan began at 2nd element
			{
				//Find minimum
				if (array[index] < minValue)
				{
					minValue = array[index];
					minIndex = index;
				}
			}

			
			//Swap minimum value with smallest element 
			array[minIndex] = array[startScan]; 
			array[startScan] = minValue; 
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
		IntSelectionSort.selectionSort(values);

		// Display the array's contents.
		System.out.println("\nSorted order:");
		for (int element : values)
			System.out.print(element + " ");

		System.out.println();
	}
}
