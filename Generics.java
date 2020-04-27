package classWork;

public class Generics <T>
{
	/* The Generics class holds X and Y coordinates. The data type of the 
	   coordinates is generic. Type T will adapt to the input parameters
	   initialized in main*/

	private T xCoordinate; 	
	private T yCoordinate; 	

	
	//Constructor
	public Generics(T x, T y)
	{
		xCoordinate = x;
		yCoordinate = y;
	}
	

	//Set values
	public void setX(T x)
	{
		xCoordinate = x;
	}

	public void setY(T y)
	{
		yCoordinate = y;
	}
	
	
	//Get values
	public T getX()
	{
		return xCoordinate;
	}

	public T getY()
	{
		return yCoordinate;
	}


	//Main
	public static void main(String[] args)
	{
		//SCENARIO 1
		System.out.println("\nSCENARIO 1");
		
		//Create two Double objects to use as coordinates.
		Double doubleX = new Double(1.5);
		Double doubleY = new Double(2.5);

		//Create a class object that can hold Doubles.
		Generics<Double> doubles = new Generics<>(doubleX, doubleY);

		//Create two Integer objects to use as coordinates.
		Integer intX = new Integer(10);
		Integer intY = new Integer(20);

		//Create a class object that can hold Integers.
		Generics<Integer> integers = new Generics<>(intX, intY);



		System.out.println("\nX Coordinate: " + doubles.getX());
		System.out.println("Y Coordinate: " + doubles.getY());
		
		System.out.println("\nX Coordinate: " + integers.getX());
		System.out.println("Y Coordinate: " + integers.getY());




		//SCENARIO 2
		System.out.println("\n\nSCENARIO 2");

		//Create various Point objects.
		Generics<Integer> integers2 = new Generics<>(1, 2);
		Generics<Double> doubles2 = new Generics<>(1.5, 2.5);
		Generics<Long> longs = new Generics <>(10L, 20L);
		Generics<Float> floats = new Generics<>(7.9f, 9.9f);

		// Display each object's coordinates.
		System.out.println("\nInteger:");
		printPoint(integers2);

		System.out.println("\nDouble:");
		printPoint(doubles2);

		System.out.println("\nLong:");
		printPoint2(longs);

		System.out.println("\nFloat:");
		printPoint2(floats);



		//SCENARIO 3
		System.out.println("\n\nSCENARIO 3");

		String[] names = { "Alfonso", "Beatrice", "Celine" };
		displayArray(names);
	}



	//Scenario 2

	//Two ways to create a Generic method
	public static void printPoint(Generics<? extends Number> point)
	{

		/* Wildcard allows the input parameter to be of any 'Generics' class type and it extends 
		   the wrapper class Number which access lower sub classes like Integer, Doubles etc. */


		System.out.println("X Coordinate: " + point.getX());
		System.out.println("Y Coordinate: " + point.getY());
	}

	public static <T extends Number> void printPoint2(Generics<T> point)
	{
		/* Type parameter defined in method header and it is constrained to
		   wrapper class Number as its upper bound */

		System.out.println("X Coordinate: " + point.getX());
		System.out.println("Y Coordinate: " + point.getY());
	}

	


	//Scenario 3
	//Generic method with its own type
	public static <E> void displayArray(E[] array)
	{
		System.out.println();

		for (E element : array)
			System.out.println(element);
	}
}