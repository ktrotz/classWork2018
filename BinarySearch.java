
/* Search algorithm that begins with the middle element. If value is found returns value and the search 
 * is ended. If the search value is greater than the middle the algorithm search the 2nd half and if it
 * is less it searches the 1st half. */


package classWork;
import java.util.Scanner;


public class BinarySearch
{ 
	public static void main(String[] args)
	{
		int result; 
		int searchValue;
		String input;

		int numbers[] = {536, 289, 296, 429, 319, 142, 394, 101, 388, 147, 
				         417, 199, 207, 222,189, 310, 447, 521, 234, 600};

		Scanner keyboard = new Scanner(System.in);

		bubbleSort(numbers); //sort the array in ascending order


		do
		{
			System.out.print("Enter a value to search for: ");
			searchValue = keyboard.nextInt();

			//Search for the value
			result = BinarySearch.search(numbers, searchValue);

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
		int first = 0;
		int last = array.length - 1;
		int position = -1;
		boolean found = false;
		int middle;

		// Search for the value.
		while (!found && first <= last)
		{
			middle = (first + last) / 2; //only works when initialized here
			
			//If value is middle
			if (array[middle] == value)
			{
				found = true;
				position = middle;
			}
			
			//Value is in lower half
			else if (array[middle] > value)
				last = middle - 1;
			
			//Value is in upper half
			else
				first = middle + 1;
		}

		return position;
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


