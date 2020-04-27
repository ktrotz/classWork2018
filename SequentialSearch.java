
/* Uses a loop to step sequentially through an array, starting with the first element */

package classWork;

public class SequentialSearch 
{	 
	public static void main(String[] args)
	{
		int[] tests = {87, 75, 98, 100, 82};
		int results;

		// Search the array for the value 100.
		results = search(tests, 100);

		
		// Determine whether 100 was found
		if (results == -1)
		{
			System.out.println("\nYou did not " +
					"earn 100 on any test.");
		}
		
		else
		{
			System.out.println("\nYou earned 100 " +
					"on test " + (results + 1));
		}
	}

	public static int search(int[] array, int value)
	{
		int index = 0; //start of search
		int position = -1; //return -1 if search value not found
		boolean found = false; //remains false if "if" condition not true

		//Search the array.
		while (!found && index < array.length)
		{
			if (array[index] == value)
			{
				found = true;
				position = index;
			}
			
			index++;
		}

		return position;
	}
}
