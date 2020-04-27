

package classWork;
import java.util.Scanner;

public class RecursiveBinary 
{
	public static void main(String [] args)
	{
		int result;
		int searchValue;
		String input;
		
		int numbers[] = {536, 289, 296, 429, 319, 142, 394, 101, 388, 147, 417, 199, 207, 222,
				            189, 310, 447, 521, 234, 600};

		Scanner keyboard = new Scanner(System.in);

		bubbleSort(numbers);

		
		do
		{
			System.out.print("Enter a value to search for: ");
			searchValue = keyboard.nextInt();

			// Search for the value
			result = RecursiveBinary.search(numbers, searchValue);

			if (result == -1)
				System.out.println(searchValue + " was not found.");
			
			else
				System.out.println(searchValue + " was found at element " + result);
			
			
			keyboard.nextLine(); //consume the remaining newline

			System.out.print("Do you want to search again? (Y or N): ");
			input = keyboard.nextLine();
		} 
		while (input.charAt(0) == 'y' || input.charAt(0) == 'Y');
		
		//Closes scanner object
		if (input.charAt(0) == 'y' || input.charAt(0) == 'Y')
			 keyboard.close(); 
	}

	public static int search(int[] array, int value)
	{
		return binarySearch(array, 0, array.length - 1, value); 
	}

	private static int binarySearch(int[] array, int first, int last, int value)
	{
		int middle = (first + last) / 2;;     // Mid point of search

		//Base case
		if (first > last)
			return -1;		

		// Search for the value via recursion
		if (array[middle] == value)
			return middle;
		
		else if (array[middle] < value)
			return binarySearch(array, middle + 1, last, value);
		
		else
			return binarySearch(array, first, middle - 1, value);
	}


	public static void bubbleSort(int[] array)
	{
		int lastPos; 
		int index; 
		int temp; 

		for(lastPos = array.length - 1; lastPos >= 0; lastPos--)
		{
			for(index = 0; index <= lastPos -1; index++) 
			{                                            
				if(array[index] > array[index + 1]) 
				{
					temp = array[index]; 
					array[index] = array[index + 1]; 
					array[index + 1] = temp;
				}
			}
		}
	}

}

