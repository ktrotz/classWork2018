package classWork;

public class RecursiveMax
{
  public static void main (String[] args)
  {
    int[] array = {3, 6, 9, 11, 1, 5};
    
    System.out.println("The max element of the array is " + maxRec (array, 0, 
                                                                    array.length -1)); //method call
    
  }
  
  public static int maxRec(int[] arr, int index, int end)
  {
    
    if (index == (end))   //Base case
      return arr[index];
      
    else if (arr[index] > arr[end])
      return maxRec (arr, index , end - 1);
    
    else  
     return maxRec (arr, index + 1, end);
  }
}