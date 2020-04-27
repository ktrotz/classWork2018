/* The following code is an example of the factorial using the recursive method.
 * Date: Sept 9, 2017 */

package classWork;

public class RecursionEx
{
	public static void main (String[] args)
	{
		System.out.println ("\nFactorial (3) = " + factorial(3));
	}

	public static int factorial(int n)
	{
		if (n == 0)
			return 1;

		else 
			return n * factorial(n - 1);
	}
	
	int iterativeFactorial(int n)
	{
	 int result = 1;
	 
	 for (int loop = 1; loop <= n; loop++)
	    result = result * loop;
	 
	 return result;
	}
}


