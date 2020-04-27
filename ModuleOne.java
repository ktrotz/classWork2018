/*In this program you will design and write a computer program to execute the following 
 task.
 Basically, it uses a recursive algorithm to reverse strings until the user types “done” as 
 the entry string.
 
 1. Read in a string from the user.  Prompt her with something like “Enter the string to 
 reverse, or ‘done’ to exit. If the user enters “done” then exit.
 
 2. Use a recursive algorithm and implementation to reverse the string.
 
 The program should loop through these two steps until the user indicates they are done.  
 For example, if the user entered “Finally” the program would reverse the string so that it 
 was “yllaniF” and would display that. Then it would prompt for the next string.*/

package classWork;
import java.util.Scanner;

public class ModuleOne {static char[] inputArray; //put string into an array

//Put string elements into an array of characters
public ModuleOne(String y, int z)
{
  inputArray = new char[y.length()];
  
  for(int index = 0; index <= z; index++)
  {
    inputArray[index] = y.charAt(index);
  }
}

public static void main(String[] args)
{
  int index; //loop control
  int end; //last element position
  String input; 
  
  
  Scanner sc = new Scanner(System.in); //receives user input
  
  System.out.print("Enter word to print in reverse or 'done' to exit: ");
  input = sc.nextLine();
  
  end = input.length() - 1; //converts string to int
  
  ModuleOne toChar = new ModuleOne(input, end); //call to class   
  
  //
  for(index = 0; index <= end; index++)
  {
    if(input == "done") //exits if true
    {
      break;
    }
    
    else //
    {
      System.out.println("The reverse of" + input + "is ");
      
      if(index != end)
        System.out.println(reverse(inputArray));
      
    }
    
    System.out.print("Enter word to print in reverse or 'done' to exit: ");      
  }
}

public static char [] reverse(char[] x)
{
  int length = inputArray.length; //position of last element
  
  if((x == null) || (length == 1))
  {
    return x;
  } 
  
  else
    return reverse(inputArray [length - 1]);
}            

}
