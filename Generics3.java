package classWork;

public class Generics3<T, S>
{
	/* Multiple generic parameters */

	     private T first;		
	     private S second;    	
	    
	     //Constructor
	     public Generics3(T firstArg, S secondArg)
	     {
	        first = firstArg;
	        second = secondArg;
	     }
	    
	     //Get values
	     public T getFirst()
	     {
	        return first;
	     }
	    
	     public S getSecond()
	     {
	        return second;
	     }
	     
	   
	     
	//Main
	public static void main(String[] args)
	     {
	        // Create an Integer to hold an ID number.   
	        Integer idNumber = new Integer(475);
	       
	        // Create a String to hold a name.
	        String name = "Smith, Sally";
	       
	        // Create a class object to hold the ID and name
	        Generics3<Integer, String> pair = new Generics3<>(idNumber, name);
	       
	        
	        System.out.println("\nID Number: " + pair.getFirst());
	        System.out.println("Name: " + pair.getSecond());
	     }
}