
/* The following program uses the bubblesort, insertion sort and quicksort to sort randomly generated lists   
   (sizes 10, 100 and 1000) of integers in the range of 0 and 99.

   Output: Sorted arrays of sizes 10, 100 and 1000 respectively
   		   Number of comparisons done by each algorithm
   		   Average number of comparisons

   Source: Starting Out with Java: From Control Structures through Data Structures, 3rd Edition by Gaddis and Muganda
   		   Chapters 4.11, 17.1 & 18.3

   Done by: Kimberley Trotz
   Date:    10/12/2017
 */


package classWork;
import java.util.Random;

public class ModuleTwo 
{
	//Total comparisons by sort
	public static int totalBubble = 0;
	public static int totalInsert = 0;
	public static int totalQuick = 0;
	
	//Total comparison by size
	public static int totalTen = 0;
	public static int totalHundred = 0;
	public static int totalThousand = 0;
	
	//Used for Quicksort
	public static int swapTotal = 0;
	public static int compTotal = 0;

	public static void main(String[] args)
	{ 	
		int ten = 10;
		int hundred = 100;
		int thousand = 1000;
		int[] random;
		int[] random2;
		int[] random3;
		
		

		System.out.println("\n\n_____10 ITEMS_____");
		
		//BUBBLESORT		
		System.out.println("\n\n*****BUBBLE SORT*****");
		random = randomListGen(ten);
		
		System.out.print("\nSorted Array: ");

		bubbleSort(random);


		//INSERTION SORT
		System.out.println("\n\n*****INSERTION SORT*****");
		random = randomListGen(ten);
		
		System.out.print("\nSorted Array: ");

		insertionSort(random);
		

		//QUICKSORT
		System.out.println("\n\n*****QUICKSORT*****");
		random2 = randomListGen(ten);
		
		System.out.print("\nSorted Array: ");

		ModuleTwo.quickSortCall(random); 

		System.out.println();


		
		System.out.println("\n\n\n_____100 ITEMS_____");
		
		//BUBBLESORT
		System.out.println("\n\n*****BUBBLE SORT*****");
		random2 = randomListGen(hundred);
		
		System.out.print("\nSorted Array: ");

		bubbleSort(random2);


		//INSERTION SORT
		System.out.println("\n\n*****INSERTION SORT*****");
		random2 = randomListGen(hundred);
		
		System.out.print("\nSorted Array: ");

		insertionSort(random2); //call


		//QUICKSORT		
		System.out.println("\n\n*****QUICKSORT*****");
		random2 = randomListGen(hundred);
		
		System.out.print("\nSorted Array: ");

		ModuleTwo.quickSortCall(random2); 

		System.out.println();

		

		System.out.println("\n\n\n_____1000 ITEMS_____");
		
		//BUBBLESORT
		System.out.println("\n\n*****BUBBLE SORT*****");
		random3 = randomListGen(thousand);
		
		System.out.print("\nSorted Array: ");

		bubbleSort(random3);


		//INSERTION SORT
		System.out.println("\n\n*****INSERTION SORT*****");
		random3 = randomListGen(thousand);
		
		System.out.print("\nSorted Array: ");

		insertionSort(random3); //call


		//QUICKSORT
		System.out.println("\n\n*****QUICKSORT*****");
		random3 = randomListGen(thousand);
		
		System.out.print("\nSorted Array: ");

		ModuleTwo.quickSortCall(random3); 

		System.out.println();
		
		
		///////AVERAGES
		int avgBubble = totalBubble/3;
		int avgInsert = totalInsert/3;
		int avgQuick = totalQuick/3;
		
		int avgTen = totalTen/3;
		int avgHundred = totalHundred/3;
		int avgThousand = totalThousand/3;
		
		System.out.println("\n\nAverage comparisons of Bubble Sorts: " + avgBubble);
		System.out.println("Average comparisons of Insertion Sorts: " + avgInsert);
		System.out.println("Average comparisons of Quicksorts: " + avgQuick);
		
		System.out.println("\nAverage comparisons of 10 Items: " + avgTen);
		System.out.println("Average comparisons of 100 Items: " + avgHundred);
		System.out.println("Average comparisons of 1000 Items: " + avgThousand);
		
		

	}
	
	public static int[] randomListGen(int x)
	{
		int[] randomList = new int[x]; //Declare size
		
		Random randomNum = new Random(); //Random object 
		
		for(int index = 0; index < x; index++)
		{
			randomList[index] = randomNum.nextInt(100); //100 is exclusive
		}

		System.out.print("\nOriginal Array: ");
		for(int e: randomList) //scans through each element of array
		{
			System.out.print(e + " ");
		}
		
		return randomList; 
	}


	public static void printList(int[] array) 
	{
		for (int index = 0; index < array.length; index++)
		{
			System.out.print(array[index] + " ");
		}
		System.out.println("\n");
	}


	public static void bubbleSort(int[] array)
	{
		int lastPos; //Position of last element
		int index; 
		int temp; //Used to swap element
		int comp = 0; //Total number of comparisons
		int swaps = 0; //Total number of swaps

		for(lastPos = array.length - 1; lastPos >= 0; lastPos--) //lastPos = array.length - 1; lastPos >= 0; lastPos--
		{
			
			for(index = 0; index <= lastPos -1; index++) //stops when index = lastPos -1 instead of lastPos because 
			{                                            //index and index + 1 must be swap later.
				comp++;

				//Compare elements
				if(array[index] > array[index + 1]) 
				{
					swaps++;
					
					//Swap values
			          temp = array[index]; //temp holds value 
			          array[index] = array[index + 1]; //first element assigned second value
			          array[index + 1] = temp; //second element assigned first value */
					
				}
			}
			
		}

		
		printList(array); //print sorted array to screen

		System.out.println("Comparisons: " + comp);
		System.out.println("Swaps: " + swaps);
		
		//Comparisons by sort
		totalBubble = totalBubble + comp;
		
		//Comparisons by size
		if(array.length == 10)
			totalTen = totalTen + comp;

		else if (array.length == 100)
			totalHundred = totalHundred + comp;
		
		else
			totalThousand = totalThousand + comp;
	}



   	public static void insertionSort(int[] array)
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
				comp++;
				swap++;
				
				array[scan] = array[scan - 1]; //swap values

				scan--;
				array[scan] = unsortedValue; //insert into proper position

			} 
			
			comp++;
		} 


		printList(array);

		System.out.println("Comparisons: " + comp);
		System.out.println("Swaps: " + swap);
		
		//Comparisons by sort
		totalInsert= totalInsert + comp;

		//Comparisons by size
		if(array.length == 10)
			totalTen = totalTen + comp;

		else if (array.length == 100)
			totalHundred = totalHundred + comp;

		else
			totalThousand = totalThousand + comp;
	} 


   	public static void quickSortCall(int[] a)
   	{
   		quickSort(a, 0, a.length - 1);

   		printList(a); //print sorted array to screen

		System.out.println("Comparisons: " + compTotal);
		System.out.println("Swaps: " + swapTotal);
		
		//Comparisons by sort
		totalQuick = totalQuick + compTotal;

		//Comparisons by size
		if(a.length == 10)
			totalTen = totalTen + compTotal;

		else if (a.length == 100)
			totalHundred = totalHundred + compTotal;

		else
			totalThousand = totalThousand + compTotal;
   	}


   	private static void quickSort(int[] array, int index, int end)
   	{ 
   		int pivotPosition;

   		if(index < end)
   		{			
   			pivotPosition = partition(array, index, end); //Get pivot

   			quickSort(array, index, pivotPosition - 1); //left sublist recursive call
   			quickSort(array, pivotPosition + 1, end); //right sublist
   		}			
   	}


	private static int partition (int[] a, int index, int end)
	{
		int pivotValue;
		int leftLast; //last element of the left sublist
		int mid; //hold the mid-point subscript

		mid = (index + end)/2; //will be pivot

		swap(a, index, mid); //method below

		pivotValue = a[index]; //save pivot for comparisons 

		leftLast = index; //temporary assignment

		//Move elements less than pivot to the left sublist
		for (int scan = index + 1; scan <= end; scan++) //scans list
		{
			compTotal++; 

			if(a[scan] < pivotValue)
			{
				swapTotal++;

				leftLast++;

				swap(a, leftLast, scan); //move elements to the left
			}
		}

		swap(a, index, leftLast); //pivot moved to end of the left sublist

		return leftLast; //return position of pivot value
	}


	private static void swap(int[] a, int x, int y)
	{
		int temp;

		//swap
		temp = a[x];			
		a[x] = a[y];
		a[y] = temp;
	}
}
