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

public class ModuleOnex
{
  public static void main(String[] args) 
  {
    int index; //loop control
    int end; //last element position
    String input = " "; 
    
    Scanner sc = new Scanner(System.in); //receives user input
    
    System.out.print("Enter word to print in reverse or 'done' to exit: ");
    input = sc.nextLine();
    
    end = input.length() - 1; //converts string to int
    
    for(index = end; index >= end; index++)
    {
      if(input.equals("done")) //compare fstrings
      {
        break;
      }
      
      else
      {
        System.out.println("The reverse of " + input + " is " + reverse(input));
        System.out.print("\nEnter word to print in reverse or 'done' to exit: ");  
        input = sc.nextLine();
      }
      
    }
  }
  
  
  public static String reverse(String x)
  {
    if (x.length() == 0 || x.length() == 1) 
    {
      return x;
    }
    
    //takes first char of String and then calls itself
    //substring take first letter & charAt add
    return reverse(x.substring(1)) + x.charAt(0); 
  }
}
