/* Use of the bubble sort method with integers in an array*/
package classWork;

public class IntBubbleSort
{  
  public static void main(String[] args)
  { 
    int array[] = {23, 10, 5, 14, 15}; 
    
    bubbleSort(array);
    
    System.out.print("\nThe sorted array is {");
    
    for(int index = 0; index <= array.length - 1; index++)
    {
       System.out.print(array[index] + ",");
    }
    
    
    System.out.println("}");
  }
  
  public static void bubbleSort(int[] array)
  {
    int lastPos; //Position of last element
    int index; 
    int temp; //Used to swap element
    
    for(lastPos = array.length - 1; lastPos >= 0; lastPos--)
    {
      for(index = 0; index <= lastPos -1; index++) //stops when index = lastPos -1 instead of lastPos because 
      {                                            //index and index + 1 must be swap later.
        
        //Compare elements
        if(array[index] > array[index + 1]) 
        {
          //Swap values
          temp = array[index]; //temp holds value 
          array[index] = array[index + 1]; //first element assigned second value
          array[index + 1] = temp; //second element assigned first value
        }
      }
    }
  }
}
