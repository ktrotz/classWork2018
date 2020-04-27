package classWork;

public class QuickSortEx
{
	public static void main(String[] args)
	{
		int[] array = { 2, 9, 3, 4, 5, 6, 7, 1};

		System.out.print("Original order: ");

		for (int e: array)
			System.out.print(e + " ");

		QuickSortEx.quickSortCall(array);

		System.out.print("\n\nSorted order: ");

		for (int e: array)
			System.out.print(e + " ");

		System.out.println();
	}


	public static void quickSortCall(int a[])
	{
		quickSort(a, 0, a.length - 1);		
		
	}

	private static void quickSort(int a[], int index, int end)
	{ 
		int pivotPosition;

		if(index < end)
		{
			pivotPosition = partition(a, index, end); //Get pivot

			quickSort(a, index, pivotPosition - 1); //left sublist recursive call
			quickSort(a, pivotPosition + 1, end); //right sublist
		}		
	}

	private static int partition (int a[], int index, int end)
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
			if(a[scan] < pivotValue)
			{
				leftLast++;

				swap(a, leftLast, scan); //move elements to the left
			}
		}

		swap(a, index, leftLast); //pivot moved to end of the left sublist
		return leftLast; //return position of pivot value
	}

	private static void swap(int a[], int x, int y)
	{
		int temp;

		//swap
		temp = a[x];			
		a[x] = a[y];
		a[y] = temp;			
	}
}

