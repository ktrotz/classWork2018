
package classWork;
import java.lang.Comparable;

public class GenericBubbleSortEx
{
	public static void main(String[] args) 
	{
		//Generic arrays defined
		Integer[] intArray = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		Double[] doubleArray = {3.4, 1.3, -22.1, 14.8, 6.0, 2.3, 12.2};
		String[] stringArray = {"Tom", "Susan", "Kim"};

		// Sort the arrays
		bubbleSort(intArray);
		bubbleSort(doubleArray);
		bubbleSort(stringArray);

		//Print the arrays
		printList(intArray);
		printList(stringArray);
		printList(doubleArray);


	}

	public static <E extends Comparable<E>> void bubbleSort(E[] array)
	{
		int lastPos; //Position of last element
		int index; 
		E temp; //Used to swap element

		for(lastPos = array.length - 1; lastPos >= 0; lastPos--) //lastPos = array.length - 1; lastPos >= 0; lastPos--
		{
			for(index = 0; index <= lastPos -1; index++) //stops when index = lastPos -1 instead of lastPos because 
			{                                            //index and index + 1 must be swap later.

				//Compare elements
				if (array[index].compareTo(array[index + 1]) > 0)
				{
					//Swap values
					temp = array[index]; //temp holds value 
					array[index] = array[index + 1]; //first element assigned second value
					array[index + 1] = temp; //second element assigned first value

				}
			}
		}
	}
	
	
	public static void printList(Object[] arr) 
	{
		for (int index = 0; index < arr.length; index++)
		{
			System.out.print(arr[index] + " ");
		}
		System.out.println("\n");
	}

}
