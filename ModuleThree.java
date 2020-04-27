/*Here	is	what	your	code	should	do: 
		1. Do	this	10	times:
			a. Generate	a random	list	of	1000 items.
			b. Make	a	sorted	version	of	the	list.
			c. Make	a	reverse-sorted	(i.e. high	to	low)	version	of	the	list.
			d. Have	each	version	of	quicksort	sort	each	of	the	three	lists.
			e. Give	the	original	list,	the	sorted	list,	and	the	number	of	comparisons	done	by	
			each	version	of	the	algorithm.
		2. At	the	end:
			a. For	each	quicksort	version and	each	list	type	(random,	pre-sorted,	reverse sorted)
			give	the	average	of	the	number	of	comparisons.
	
	Source: Starting Out with Java: From Control Structures through Data Structures, 3rd Edition by Gaddis and Muganda
   		   Chapters 4.11, 17.1 & 18.3
   		   
	Done by: Kimberley Trotz
	Date: 11/08/2017			*/

package classWork;

import java.util.Random;

public class ModuleThree 
{ 
	//Used for QuickSort
	public static int swapV1 = 0;
	public static int swapV2 = 0;
	public static int swapV3 = 0;
	
	
	//Total swaps by QuickSort version
	public static int totalV1 = 0;
	public static int totalV2 = 0;
	public static int totalV3 = 0;
	
	
	public static void main(String[] args)
	{
		int unSwaps = 0;
		int sortSwaps = 0;
		int revSwaps = 0;
		
		int unSwaps2 = 0;
		int sortSwaps2 = 0;
		int revSwaps2 = 0;
		
		int unSwaps3 = 0;
		int sortSwaps3 = 0;
		int revSwaps3 = 0;
		
		//Generate 10 random lists of 1000 items
		for(int index = 1; index <= 10; index++)
		{
			System.out.println("\n\n\n\n*********EXECUTION " + index + "*********\n");
			
			//Unsorted List
			int[] random = randomListGen(1000);
			
			int[] rand1 = random; //reference to original array
			int[] randV1 = random;	
			int[] random2 = random; 
			int[] random3 = random;
			
			System.out.println("Unsorted List: ");
			printList(random);
			

			//Sorted List
			System.out.println("Sorted List: ");
			sort(rand1); //sorts random array
			printList(rand1);
			
			int[] rand2 = rand1;
			int[] rand3 = rand1;
			
			
			//Reverse List
			System.out.println("Reverse Sorted List: ");
			reverseSort(randV1); //reverse sorts random array
			printList(randV1);
			
			int[] randV2 = randV1;
			int[] randV3 = randV1;
			

			//Version One QuickSort
			System.out.println("\n\n*******QUICKSORT VERSION ONE*******\n");
			System.out.println("Unsorted to Quicksorted: ");
			unSwaps = unSwaps + quickSortV1(random);
			
			printList(random);
			
			System.out.println("Sorted to Quicksorted: ");
			sortSwaps = sortSwaps + quickSortV1(rand1);
			printList(rand1);
			
			System.out.println("Reverse Sorted to Quicksorted: ");
			revSwaps = revSwaps + quickSortV1(randV1);
			printList(randV1);
			

			//Version Two QuickSort
			System.out.println("\n\n*******QUICKSORT VERSION TWO*******\n");
			System.out.println("Unsorted to Quicksorted: ");
			unSwaps2 = unSwaps2 + quickSortV2(random2);
			printList(random2);

			System.out.println("Sorted to Quicksorted: ");
			sortSwaps2 = sortSwaps2 + quickSortV2(rand2);
			printList(rand2);
			
			System.out.println("Reverse Sorted to Quicksorted: ");
			revSwaps2 = revSwaps2 + quickSortV2(randV2);
			printList(randV2);
			
			
			//Version Three QuickSort
			System.out.println("\n\n*******QUICKSORT VERSION THREE*******\n");
	
			System.out.println("Unsorted to Quicksorted: ");
			unSwaps3 = unSwaps3 + quickSortV3(random3);
			printList(random3);
			
			System.out.println("Sorted to Quicksorted: ");
			sortSwaps3 = sortSwaps3 + quickSortV3(rand3);
			printList(rand3);
			
			System.out.println("Reverse Sorted to Quicksorted: ");
			revSwaps3 = revSwaps3 + quickSortV3(randV3);
			printList(randV3);		
		}
		
		//Averages
		int avgV1 = totalV1/10;
		int avgV2 = totalV2/10;
		int avgV3 = totalV3/10;
		
		int avgUnsorted = (unSwaps + unSwaps2 + unSwaps3)/30 ;
		int avgSorted = (sortSwaps + sortSwaps2 + sortSwaps3)/30;
		int avgReverse = (revSwaps + revSwaps2 + revSwaps3)/30;
		
		
		System.out.println("Average Comparisions of Unsorted: " + avgUnsorted);
		System.out.println("Average Comparisions of Sorted: " + avgSorted);
		System.out.println("Average Comparisions of Reverse Sorted: " + avgReverse);
		
		
		System.out.println("\nAverage Comparisions  of Quicksort Version 1: " + avgV1);
		System.out.println("Average Comparisions of Quicksort Version 2: " + avgV2);
		System.out.println("Average Comparisions of Quicksort Version 3: " + avgV3);
	}

	
	//Print list to screen
	public static void printList(int[] array) 
	{
		for (int index = 0; index < array.length; index++)
		{
			System.out.print(array[index] + " ");
		}
		System.out.println("\n");
	}


	//Generate a random list
	public static int[] randomListGen(int x)
	{
		int[] randomList = new int[x]; //Declare size

		Random randomNum = new Random(); //Random object 

		for(int index = 0; index < x; index++)
		{
			randomList[index] = randomNum.nextInt(100); //100 is exclusive
		}

		return randomList; 
	}

	//Sort from low to high
	public static void sort(int[] array)
	{
		int lastPos; //Position of last element
		int index; 

		for(lastPos = array.length - 1; lastPos >= 0; lastPos--)
		{
			for(index = 0; index <= lastPos -1; index++) 
			{
				//Compare elements
				if(array[index] > array[index + 1]) 
				{                  
					//Swap values
					swap(array, index, index + 1);
				}
			}
		}	    
	}


	//Sort from high to low 
	public static void reverseSort(int[] array)
	{
		int lastPos;
		int index; 

		for(lastPos = array.length - 1; lastPos >= 0; lastPos--)
		{
			for(index = 0; index <= lastPos - 1; index++)
			{                                                   
				//Compare elements
				if(array[index] < array[index + 1]) 
				{                  
					//Swap values
					swap(array, index, index + 1);
				}
			}
		}	    
	}


	//VERSION ONE QUICKSORT
	public static int quickSortV1(int a[])
	{
		int swaps = 0; 
		
		quickSort(a, 0, a.length - 1);	
		
	    System.out.println("Swaps: " + swapV1);
	    
	    //Swap count by list type
	    if(totalV1 < swapV1)
	    	swaps = swapV1 - totalV1;
	    
	    else
	    	swaps = totalV1 - swapV1;	    	
		        
	    totalV1 = totalV1 + swapV1;
		
		return swaps; 
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

	private static int partition (int a[], int index, int end)
	{
		int pivotValue;
		int leftLast; //last element of the left sublist
		int mid; //hold the mid-point subscript

		mid = (index + end)/2; //will be pivot
		swap(a, index, mid); //method below
		swapV1++;
		
		pivotValue = a[index]; //save pivot for comparisons 

		leftLast = index; //temporary assignment

		//Move elements less than pivot to the left sublist
		for (int scan = index + 1; scan <= end; scan++) //scans list
		{
			if(a[scan] < pivotValue)
			{
				leftLast++;
				swapV1++;

				swap(a, leftLast, scan); //move elements to the left
			}
		}

		swap(a, index, leftLast); //pivot moved to end of the left sublist
		swapV1++;
		
		return leftLast; //return position of pivot value		
	}
	

	//Swap values
	private static void swap(int[] a, int x, int y)
	{
		int temp;

		//swap
		temp = a[x];			
		a[x] = a[y];
		a[y] = temp;
	}


	//VERSION TWO QUICKSORT
	public static int quickSortV2(int a[])
	{
		int swaps = 0;
		
		quickSort2(a, 0, a.length - 1);	
		
		System.out.println("Swaps: " + swapV2);
		
		if(totalV2 < swapV2)
	    	swaps = swapV2 - totalV2;
	    
	    else
	    	swaps = totalV2 - swapV2;	    	
		        
	    totalV2 = totalV2 + swapV2;
		
		return swaps;

	}

	private static void quickSort2(int[] array, int index, int end)
	{ 
		int pivotPosition;
		
		if(index < end)
		{			
			pivotPosition = partition2(array, index, end); 

			quickSort2(array, index, pivotPosition - 1); 
			quickSort2(array, pivotPosition + 1, end); 
		}			
	}


	private static int partition2 (int a[], int index, int end)
	{
		int pivotValue;
		int leftLast; 
		int random;
		int range = end - index + 1; 
		
		
		Random rand = new Random();
		
	    random = rand.nextInt(range) + index; //inclusive range of 0 - 999 
	    			
		swap(a, index, random);
		swapV2++;
		
		pivotValue = a[index];  

		leftLast = index;


		//Move elements less than pivot to the left sublist
		for (int scan = index + 1; scan <= end; scan++) 
		{
			if(a[scan] < pivotValue)
			{
				leftLast++;
				swapV2++;

				swap(a, leftLast, scan);
			}
		}

		swap(a, index, leftLast);
		swapV2++;		
		
		return leftLast; //return position of pivot value
	}


	//VERSION THREE QUICKSORT
	public static int quickSortV3(int a[])
	{
		int swaps = 0;
		
		quickSort3(a, 0, a.length - 1);	
		
	    System.out.println("Swaps: " + swapV3);
	    
	    if(totalV3 < swapV3)
	    	swaps = swapV3 - totalV3;
	    
	    else
	    	swaps = totalV3 - swapV3;	    	
		        
	    totalV3 = totalV3 + swapV3;
		
		return swaps;

	}

	private static void quickSort3(int[] array, int index, int end)
	{ 
		int pivotPosition;

		if(index < end)
		{
			pivotPosition = partition3(array, index, end); //Get pivot

			quickSort3(array, index, pivotPosition - 1); //left sublist recursive call
			quickSort3(array, pivotPosition + 1, end); //right sublist
		}		
	}

	private static int partition3(int a[], int index, int end)
	{
		int pivotValue;
		int leftLast;
		int mid;
		int median;
		
		mid = (index + end)/2;
	    
	    median = median(index, mid, end); //method call
	    
		swap(a, index, median); 
		swapV3++;
		
		pivotValue = a[index]; //save pivot for comparisons 

		leftLast = index; //temporary assignment

		//Move elements less than pivot to the left sublist
		for (int scan = index + 1; scan <= end; scan++) //scans list
		{
			if(a[scan] < pivotValue)
			{
				leftLast++;
				swapV3++;

				swap(a, leftLast, scan); //move elements to the left
			}
		}

		swap(a, index, leftLast); //pivot moved to end of the left sublist
		swapV3++;
		
		return leftLast; //return position of pivot value		
	}

	
	public static int big(int index, int end)
	{
		if (index == end)
			return index;
		
		else if (index < end)
			return end;
		
		else
			return index;
	}
	
	public static int max(int index, int mid, int end)
	{
		return big(mid, big(index, end)); //returns biggest value
	}
	
	
	public static int median(int index, int mid, int end)
	{
		int middle = max(index, mid, end);
		
		//if the index is the biggest it will return the max of the mid and end
		if (middle == index)         
			return big(mid, end);
		
		else if (middle == mid)
			return big(index, end);
		
		else 
			return big(index, mid);
		
	}


}



