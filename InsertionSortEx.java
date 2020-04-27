/*This is an example of the insertion sort code*/

package classWork;

import java.util.Random;

public class InsertionSortEx
{
	public static void main (String[] args)
	{
		int[] randomList = new int[10];

		Random randomNum = new Random(); //Random object 

		//Generate random list of 10 integers
		for(int index = 0; index < 10; index++)
		{
			randomList[index] = randomNum.nextInt(100); //100 is exclusive
		}

		System.out.print("Original Array: ");
		printList(randomList);

		System.out.print("Sorted Array: ");
		insertionSorter(randomList);

	}

	public static void printList(int[] array) 
	{
		for (int index = 0; index < array.length; index++)
		{
			System.out.print(array[index] + " ");
		}
		System.out.println("\n");
	}


	public static void insertionSorter(int [] array)
	{
		int unsortedValue; 
		int scan; //used to scan array
		int comp = 0;
		int swap = 0;

		//The first unsorted value is actually the second value therefore index = 1
		for(int index = 1; index < array.length; index++)
		{
			unsortedValue = array[index]; 
			scan = index; //start scan at first unsolved part

			//Move the first element to be sorted
			while (scan > 0 && array[scan - 1] > unsortedValue)
			{
				array[scan] = array[scan - 1]; //swap values

				scan--;
				array[scan] = unsortedValue; //insert into proper position
				
				comp++;
				swap++;
				
			}

			comp++;

		}

		printList(array);

		System.out.println("Comparisons: " + comp);
		System.out.println("Swaps: " + swap);



	} 

}
