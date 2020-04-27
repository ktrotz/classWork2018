/* EXAMPLE OF SUBSTRING METHOD */
package classWork; 

public class SubstringTest
{  
 public static void main(String args[])
 {  
   String s = "KimberleyTrotz";  
   
   //This method returns from start index and is inclusive
   System.out.println(s.substring(9)); //Trotz
   
   //This method returns from start index to the end index which is exclusive (therefore drops position 6)
   System.out.println(s.substring(0,9)); //Kimberley 
 }  
}